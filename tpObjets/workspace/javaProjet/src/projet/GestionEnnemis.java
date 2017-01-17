package projet;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GestionEnnemis {
	

	int vitesseDeplacement;
	int longueurdeplacementHauteur;
	int valeurTimer;
	
	
	public void setValeurTimer(int valeurTimer){
		this.valeurTimer = valeurTimer;
	}
	
	public int getValeurTimer(){
		return this.valeurTimer;
	}
	
	public int getVitesseDeplacement() {
		return vitesseDeplacement;
	}
	public void setVitesseDeplacement(int vitesseDeplacement) {
		this.vitesseDeplacement = vitesseDeplacement;
	}
	public int getLongueurdeplacementHauteur() {
		return longueurdeplacementHauteur;
	}
	public void setLongueurdeplacementHauteur(int longueurdeplacementHauteur) {
		this.longueurdeplacementHauteur = longueurdeplacementHauteur;
		this.calculeNbDeplacementColone();
	}

	private int direction; // 0 pour gauche | 1 pour bas | 2 pour gauche | 3 bas encore \\
	private int nbDeplacementNecessaire;
	private int nbDeplacementNecessaireParcoursLigneGauche;
	private int nbDeplacementNecessaireParcoursLigneDroite;
	private int nbDeplacementNecessaireParcoursColone;
	private int positionMinX;
	private int positionMaxX;
	private int nbDeplacementActuel;
	private boolean waitEnd;
	private Timer timer;
	
	private boolean waitFireEnd;
	private Timer timerFire;
	
	private void calculeNbDeplacementColone(){
		nbDeplacementNecessaireParcoursColone = 
				longueurdeplacementHauteur /  vitesseDeplacement;
	}
	
	public GestionEnnemis(int vitesseDeplacement, int longueurdeplacementHauteur, int valeurTimer){
		init();
		this.vitesseDeplacement = vitesseDeplacement;
		this.longueurdeplacementHauteur = longueurdeplacementHauteur;
		this.valeurTimer = valeurTimer;
	}	
	
	public GestionEnnemis(){
		init();
	}
	
	public void init() {
		waitEnd = true;
		
		nbDeplacementActuel = 0;
		nbDeplacementNecessaire = 0;
		positionMinX = DonneesGenerales.getTaillePlateau().getX();
		positionMaxX = 0;
		direction = 0;
		vitesseDeplacement = 30;
		valeurTimer = 200;
		longueurdeplacementHauteur = DonneesGenerales.getTaillePlateau().getY()/6;
		this.calculeNbDeplacementColone();
		
		if(timerFire != null)
			timerFire.cancel();
		waitFireEnd = true;
		
		updatePlateau(DonneesPartie.getEnnemis());

		nbDeplacementNecessaire = nbDeplacementNecessaireParcoursLigneGauche;
	}
	public void nouveauPlateau(Ennemi[][] ennemis){
		direction = 0;
		
		updatePlateau(DonneesPartie.getEnnemis());
		this.calculeNbDeplacementColone();
	}
	
	private void goSleep() {
		waitEnd = false;
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				waitEnd = true;
				timer.cancel();
			}
		};
		this.timer = new Timer();
		this.timer.scheduleAtFixedRate(timerTask, valeurTimer, valeurTimer);
	}
	
	public void paint(Graphics g) {
		for(Ennemi ennemi : DonneesPartie.getEnnemis())
			ennemi.paint(g);
		
		for(Ennemi ennemi : DonneesPartie.getEnnemis())
			ennemi.update();
		
		ArrayList<Entite> aTuer = new ArrayList<Entite>();
		for(Ennemi ennemi : DonneesPartie.getEnnemis())
			if(ennemi.isMorte()){
				aTuer.add(ennemi);
				
			}
		if (aTuer.size() > 0)
		DonneesPartie.getEnnemis().removeAll(aTuer);
		
		if (this.waitEnd){
			this.comportementDefaut();
			this.goSleep();
		}
	}
	
	private void updatePlateau(ArrayList<Ennemi> ennemis){
		if (ennemis == null)
			return;
		int dernierXMinTrouve = -1;
		int dernierXMaxTrouve = -1;
		Iterator<Ennemi> itr = ennemis.iterator();
		while(itr.hasNext()){
			Ennemi ennemi = itr.next();
			if (ennemi == null)
				continue;

			if (dernierXMinTrouve == -1)
				dernierXMinTrouve = ennemi.getObjetGraphique().getX();
			else
				if (dernierXMinTrouve > ennemi.getObjetGraphique().getX())
					dernierXMinTrouve = ennemi.getObjetGraphique().getX();
		
			if (dernierXMaxTrouve == -1)
				dernierXMaxTrouve = ennemi.getObjetGraphique().getX();
			else
				if (dernierXMaxTrouve < ennemi.getObjetGraphique().getX())
					dernierXMaxTrouve = ennemi.getObjetGraphique().getX();
		}
		positionMinX = dernierXMinTrouve;
		int xMin = (positionMinX);
		nbDeplacementNecessaireParcoursLigneDroite = 
				(xMin / (vitesseDeplacement)); 

		positionMaxX = dernierXMaxTrouve;
		int xMax = (positionMaxX + DonneesGenerales.getDimensionEnnemis().getX() + 10 );
		nbDeplacementNecessaireParcoursLigneGauche = 
				(DonneesGenerales.getTaillePlateau().getX() - xMax) / (vitesseDeplacement); 

	}
	
	public void comportementDefaut(){
		if (nbDeplacementActuel >= nbDeplacementNecessaire){
			if(direction == 0){
				direction = 1;
				nbDeplacementNecessaire = nbDeplacementNecessaireParcoursColone;
				
			}
			else if (direction == 1){
				updatePlateau(DonneesPartie.getEnnemis());
				nbDeplacementNecessaire = nbDeplacementNecessaireParcoursLigneDroite;
				direction = 2;
			}
			else if (direction == 2){
				direction = 3;
				nbDeplacementNecessaire = nbDeplacementNecessaireParcoursColone;
				
				
			}
			else if (direction == 3){
				updatePlateau(DonneesPartie.getEnnemis());
				nbDeplacementNecessaire = nbDeplacementNecessaireParcoursLigneGauche;
				direction = 0;
				
			}
			
			nbDeplacementActuel = 1;
			
		}
		else
			nbDeplacementActuel++;
		
		int x = 0,y = 0;
		if (direction == 0 ){
			x = vitesseDeplacement;
		}
		if (direction == 1 || direction == 3){
			y = vitesseDeplacement;
		}
		if (direction == 2){
			x = -vitesseDeplacement;
		}
		
		Iterator<Ennemi> itr = DonneesPartie.getEnnemis().iterator();
		while(itr.hasNext()){
			Ennemi ennemi = itr.next();
			ennemi.seDeplacer(x,y);
		}
	}
	
	
	
	public void fireEnnemis() {
		if(!this.waitFireEnd)
			return;
		
		ArrayList<Ennemi> peutTirer = new ArrayList<Ennemi>();
		for(int i = 0; i < DonneesPartie.getNbEnnemis(); i++) {
			boolean found = false;
			
			Ennemi ennemi = DonneesPartie.getEnnemis().get(i);
			for(int j = i + 1; j < DonneesPartie.getNbEnnemis(); j++) {
				Ennemi compare = DonneesPartie.getEnnemis().get(j);
				if(ennemi.getObjetGraphique().getY() < compare.getObjetGraphique().getY() && ennemi.getObjetGraphique().getX() == compare.getObjetGraphique().getX()) {
					found = true;
					break;
				}
			}
			if(!found)
				peutTirer.add(ennemi);
		}
		
		if(peutTirer.size() == 1) {
			Projectile projectile = peutTirer.get(0).tirer(SensTirer.versDefenseur);
			if(!(projectile == null))
				DonneesPartie.addProjectileEnnemi(projectile);
		} else {
			Random rand = new Random();
			
			int nbEnnemi;
			if((peutTirer.size() / 2) <= 1)
				nbEnnemi = 1;
			else
				nbEnnemi = 1 + rand.nextInt((peutTirer.size() / 2) - 1);
			
			ArrayList<Ennemi> tireurs = new ArrayList<Ennemi>();
			
			for(int i = 0; i <= nbEnnemi; i++) {
				int index = rand.nextInt(peutTirer.size());
				tireurs.add(peutTirer.get(index));
				peutTirer.remove(index);
			}
			
			for(Ennemi ennemi: tireurs) {
				Projectile projectile = ennemi.tirer(SensTirer.versDefenseur);
				if(!(projectile == null))
					DonneesPartie.addProjectileEnnemi(projectile);
			}
		}
		this.goFireSleep();
	}

	private void goFireSleep() {
		waitFireEnd = false;
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				waitFireEnd = true;
				timerFire.cancel();
			}
		};
		Random rand = new Random();
		this.timerFire = new Timer();
		int time = 1 + rand.nextInt(3000 - 1);
		this.timerFire.scheduleAtFixedRate(timerTask, time, 1);
	}
	
}
