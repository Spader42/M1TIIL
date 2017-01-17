package projet;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

import comportements.ComportementType;
import comportements.SeDeplacerDroite;
import comportements.SeDeplacerGauche;
import comportements.Tirer;
import menu.GestionnaireMenu;

public class Plateau extends JComponent implements KeyListener {
	/**
	 * 
	 */
	private static JFrame window;
	private static final long serialVersionUID = 1L;
	private GestionEnnemis 		gestionEnnemis;
	private GestionCollisions	gestionCollisions;
	private HUD hud;
	private Timer timer;
	private boolean pause;
	private BufferedImage pauseSprite;
	private GestionnaireMenu gestionnaireMenu;
	
	private HashMap<Integer, Boolean> touches;
	private HashMap<Integer, Boolean> stiilPressed;
	private HashMap<Integer, StiilkeyPressed> detectStiilPressed;
	
	public Plateau(JFrame window, final GestionnaireMenu gestionnaireMenu) {
		this.touches = new HashMap<Integer, Boolean>();
		this.touches.put(KeyEvent.VK_Q, false);
		this.touches.put(KeyEvent.VK_D, false);
		this.touches.put(KeyEvent.VK_SPACE, false);
		
		this.stiilPressed = new HashMap<Integer, Boolean>();
		this.stiilPressed.put(KeyEvent.VK_Q, false);
		this.stiilPressed.put(KeyEvent.VK_D, false);
		this.stiilPressed.put(KeyEvent.VK_SPACE, false);
		
		this.detectStiilPressed = new HashMap<Integer, StiilkeyPressed>();
		this.detectStiilPressed.put(KeyEvent.VK_Q, null);
		this.detectStiilPressed.put(KeyEvent.VK_D, null);
		this.detectStiilPressed.put(KeyEvent.VK_SPACE, null);
		
		DonneesGenerales.init();
		GestionnairePlateaux.init();
		DonneesPartie.init();
		
		this.gestionnaireMenu = gestionnaireMenu;
		Plateau.window = window;
		
		this.gestionEnnemis 	= new GestionEnnemis();
		this.gestionCollisions	= new GestionCollisions();
		this.hud 				= new HUD();
		this.pause 				= false;
		
		window.addKeyListener(this);
		
		DonneesPartie.setJoueur(new Defenseur(
					(int)(window.getSize().getWidth() / 2),
							DonneesGenerales.getTaillePlateau().getY()
							- (DonneesGenerales.getDimensionDecalage().getY() * 2)
							- 70,
					50, 50,
					"sprites/defenseurs/1/1.png"));
		DonneesPartie.getJoueurs().setHp(10);
		
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				repaint();
			}
		};
		this.timer = new Timer();
		this.timer.scheduleAtFixedRate(timerTask, 1, 1);
		
		try{
			this.pauseSprite = ImageIO.read(new File("sprites/pauses/1/1.png"));
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void reset() {
		DonneesPartie.setEnnemis(GestionnairePlateaux.getNexTableau());
		DonneesPartie.getProjectileDefenseur().clear();
		DonneesPartie.getProjectileEnnemis().clear();
		
		DonneesPartie.setJoueur(new Defenseur((int)(window.getSize().getWidth() / 2), 380, 50, 50, "sprites/defenseurs/1/1.png"));
		DonneesPartie.getJoueurs().setHp(10);
		
		if(this.timer != null) {
			this.timer.cancel();
			this.timer = null;
		}
		
		this.gestionEnnemis 	= new GestionEnnemis();
		this.gestionCollisions	= new GestionCollisions();
		this.hud 				= new HUD();
		this.pause 				= false;
		
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				repaint();
			}
		};
		this.timer = new Timer();
		this.timer.scheduleAtFixedRate(timerTask, 1, 1);
	}
	
	public static JFrame getWindow() {
		return Plateau.window;
	}
	
	public boolean isPaused() {
		return this.pause;
	}
	
	public void setPaused() {
		if(this.pause) {
			this.pause = false;
			this.repaint();
		} else
			this.pause = true;
	}
	
	public void paint(Graphics g) {
		if(this.pause) {
			g.drawImage(pauseSprite, window.getWidth() / 2 - pauseSprite.getWidth() / 2, window.getHeight() / 2 - pauseSprite.getHeight() / 2, null);
			return;
		}
		
		DonneesPartie.getJoueurs().paint(g);
		this.gestionEnnemis.paint(g);
		
		for(Projectile projectile: DonneesPartie.getProjectileDefenseur())
			projectile.paint(g);
		for(Projectile projectile: DonneesPartie.getProjectileEnnemis())
			projectile.paint(g);
		
		for(Projectile projectile: DonneesPartie.getProjectileDefenseur())
			projectile.update();
		for(Projectile projectile: DonneesPartie.getProjectileEnnemis())
			projectile.update();
		
		ArrayList<Entite> aTuer = new ArrayList<Entite>();
		for(Projectile projectile: DonneesPartie.getProjectileDefenseur())
			if(projectile.isMorte())
				aTuer.add(projectile);
		
		DonneesPartie.getProjectileDefenseur().removeAll(aTuer);
		aTuer.clear();
		
		for(Projectile projectile: DonneesPartie.getProjectileEnnemis())
			if(projectile.isMorte())
				aTuer.add(projectile);
		
		
		this.checkCollisions();
		this.gestionEnnemis.fireEnnemis();
		this.hud.paint(g);
		
		this.checkTouche();
		
	}
	
	private void checkCollisions() {
		//Liste des projectiles qui ont touchés le défenseur
		ArrayList<Projectile> collisionProjectile = this.gestionCollisions.getDefenseurToucheParProjectile();
		for(Projectile projectile : collisionProjectile) {
			DonneesPartie.getJoueurs().removeHP(projectile.getDegats());
			projectile.mourir();
			DonneesPartie.removeProjectileEnnemis(projectile);
			
			if(DonneesPartie.getJoueurs().isMorte())
				this.gestionnaireMenu.endGame();
		}
		
		
		//Liste des ennemis qui ont touchés physiquement le defenseur
		ArrayList<Ennemi> collisionEnnemi = this.gestionCollisions.getDefenseurToucheParEnnemi();
		for(Ennemi ennemi : collisionEnnemi) {
			DonneesPartie.getJoueurs().removeHP(ennemi.getHP());
			ennemi.mourir();
			DonneesPartie.removeEnnemi(ennemi);
			
			if(DonneesPartie.getJoueurs().isMorte())
				this.gestionnaireMenu.endGame();
		}
		
		//HashMap clef = 1 ennemi ; valeur = liste des projectiles qui l'ont touchés
		HashMap<Ennemi,ArrayList<Projectile>> ennemiTouche = this.gestionCollisions.getEnnemiTouche();
		for(Ennemi ennemi : ennemiTouche.keySet()) {
			for(Projectile projectile : ennemiTouche.get(ennemi)) {
				ennemi.removeHP(projectile.getDegats());
				projectile.mourir();
				DonneesPartie.removeProjectileDefenseur(projectile);
			}
			
			if(ennemi.isMorte()) {
				DonneesPartie.removeEnnemi(ennemi);
				
				DonneesPartie.getJoueurs().addScore(ennemi.getNbpoint());
				if(DonneesPartie.getJoueurs().getScore() > DonneesGenerales.getHightScore())
					DonneesGenerales.setHightScore(DonneesPartie.getJoueurs().getScore());
			}
		}
		
		if(DonneesPartie.getNbEnnemis() == 0) {
			DonneesPartie.setEnnemis(GestionnairePlateaux.getNexTableau());
			this.gestionEnnemis.init();
		}
			
	}
	
	private void checkTouche() {
		for(int e : this.touches.keySet()) {
			switch(e) {
			case KeyEvent.VK_Q:
				if(this.touches.get(e))	{
					this.touches.put(KeyEvent.VK_D, false);
					DonneesPartie.getJoueurs().removeComportement(ComportementType.seDeplacerDroite);
					DonneesPartie.getJoueurs().addComportement(new SeDeplacerGauche(DonneesPartie.getJoueurs(), 1));
				}
				else DonneesPartie.getJoueurs().removeComportement(ComportementType.seDeplacerGauche);
				break;
			case KeyEvent.VK_D:
				if(this.touches.get(e))	{
					this.touches.put(KeyEvent.VK_Q, false);
					DonneesPartie.getJoueurs().removeComportement(ComportementType.seDeplacerGauche);
					DonneesPartie.getJoueurs().addComportement(new SeDeplacerDroite(DonneesPartie.getJoueurs(), 1));
				}
				else {
					//System.out.println("HERE2");
					DonneesPartie.getJoueurs().removeComportement(ComportementType.seDeplacerDroite);
				}
				break;
			case KeyEvent.VK_SPACE:
				if(this.touches.get(e))	DonneesPartie.getJoueurs().addComportement(new Tirer(DonneesPartie.getJoueurs(), SensTirer.versEnnemis));
				else DonneesPartie.getJoueurs().removeComportement(ComportementType.tirer);
				break;
			}
		}
	}
	
	/*private void setReleased(int code) { //Appelé par le Released
		this.stiilPressed.put(code, true);
		this.detectStiilPressed.put(code, new StiilkeyPressed(code, this));
		System.out.println("Relachement de " + code);
	}
	
	private void checkStiilPressed(int code) { //Appelé par le Pressed()
		if(this.stiilPressed.get(code)) {
			this.detectStiilPressed.get(code).stopTimer();
			touches.put(code, true);
		} else {
			touches.put(code, false);
			System.out.println("Appuie sur " + code);
		}
	}
	
	public void setStiilPressed(int code) { //Appelé par l'objet qui check le non-stiilPressed
		this.stiilPressed.put(code, false);
		touches.put(code, false);
		this.detectStiilPressed.get(code).stopTimer();
		System.out.println("Touche \"" + code + "\" relachée !");
	}*/
	
	// si realeased ==> attente
	// si pressed rapidement ==> reste à true
	// sinon ==> false	
	
	@Override
	public void keyPressed(KeyEvent arg0) { //Touché tappée
		int code = arg0.getKeyCode();
		/*this.checkStiilPressed(code);
		/*if(this.touches.containsKey(code))
			this.touches.put(code, true);*/
		
			
		if(code == KeyEvent.VK_Q) {
			this.touches.put(code, true);
			DonneesPartie.getJoueurs().addComportement(new SeDeplacerGauche(DonneesPartie.getJoueurs(), 1));
			/*if(!((DonneesPartie.getJoueurs().getObjetGraphique().getX() - 10) < 0)) {
				DonneesPartie.getJoueurs().getObjetGraphique().setX(DonneesPartie.getJoueurs().getObjetGraphique().getX() - 10);
				this.repaint();
			}*/
		} else if(code == KeyEvent.VK_D){
			this.touches.put(code, true);
			DonneesPartie.getJoueurs().addComportement(new SeDeplacerDroite(DonneesPartie.getJoueurs(), 1));
			/*if(!((DonneesPartie.getJoueurs().getObjetGraphique().getX() + DonneesPartie.getJoueurs().getObjetGraphique().getLargeur() + 10) > Plateau.getWindow().getSize().getWidth())) {
				DonneesPartie.getJoueurs().getObjetGraphique().setX(DonneesPartie.getJoueurs().getObjetGraphique().getX() + 10);
				this.repaint();
			}*/
		} else if(code == KeyEvent.VK_SPACE) {
			this.touches.put(code, true);
			DonneesPartie.getJoueurs().addComportement(new Tirer(DonneesPartie.getJoueurs(), SensTirer.versEnnemis));
			/*Projectile projectile = DonneesPartie.getJoueurs().tirer(SensTirer.versEnnemis);
			if(!(projectile == null))
				DonneesPartie.addProjectileDefenseur(projectile);
			this.repaint();*/
		} else if(code == KeyEvent.VK_P) {
			this.setPaused();
		} else if(code == KeyEvent.VK_ESCAPE || code == KeyEvent.VK_M) {
			this.gestionnaireMenu.switchToGameMenu();
		} else if(code == KeyEvent.VK_F1) { DonneesPartie.getJoueurs().setArme(1);
		} else if(code == KeyEvent.VK_F2) {	DonneesPartie.getJoueurs().setArme(2);
		} else if(code == KeyEvent.VK_F3) {	DonneesPartie.getJoueurs().setArme(3);
		} else if(code == KeyEvent.VK_F4) {	DonneesPartie.getJoueurs().setArme(4);
		} else if(code == KeyEvent.VK_F5) {	DonneesPartie.getJoueurs().setArme(5);
		} else if(code == KeyEvent.VK_F6) {	DonneesPartie.getJoueurs().setArme(6);
		} else if(code == KeyEvent.VK_F7) {	DonneesPartie.getJoueurs().setArme(7);
		} else if(code == KeyEvent.VK_F8) {	DonneesPartie.getJoueurs().setArme(8);
		} else if(code == KeyEvent.VK_F9) { DonneesPartie.getJoueurs().setArme(9);
		}
	}
		


	@Override
	public void keyReleased(KeyEvent arg0) { //Touche relaché
		int code = arg0.getKeyCode();
		/*this.setReleased(code);*/
		/*System.out.println("touche : \"" + arg0.getKeyChar() + "\"");
		if(this.touches.containsKey(code))
			this.touches.put(code, false);*/
		
		
		
		if(code == KeyEvent.VK_Q) { 
			DonneesPartie.getJoueurs().removeComportement(ComportementType.seDeplacerGauche);
			this.touches.put(code, false);
		} else if(code == KeyEvent.VK_D){ 
			DonneesPartie.getJoueurs().removeComportement(ComportementType.seDeplacerDroite); 
			this.touches.put(code, false);
		} else if(code == KeyEvent.VK_SPACE) { 
			DonneesPartie.getJoueurs().removeComportement(ComportementType.tirer); 
			this.touches.put(code, false);
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
}