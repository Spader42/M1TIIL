package menu;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import projet.DimensionDonnees;
import projet.DonneesGenerales;
import projet.Plateau;

public class GestionnaireMenu {
	private JFrame jframe;
	
	private final MenuPrincipal menuPrincipal;
	private final MenuEnParti menuEnPartie;
	private final Options options;
	private final SelectNewGame selectNewGame;
	
	private Plateau plateau;
	
	private DimensionDonnees tailleBasique;
	
	private boolean gameEnded;
	
	public GestionnaireMenu(JFrame jframe) {
		this.jframe = jframe;
		this.tailleBasique = new DimensionDonnees(500, 500);
		this.jframe.setSize(this.tailleBasique.getX(), this.tailleBasique.getY());
		
		this.menuPrincipal = new MenuPrincipal(this);
		this.plateau = new Plateau(jframe, this);
		this.menuEnPartie = new MenuEnParti(this);
		this.options = new Options(this);
		this.selectNewGame = new SelectNewGame(this);
		
		this.gameEnded = true;
	}
	
	private void centerFrame() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.jframe.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.jframe.getHeight()) / 2);
	    this.jframe.setLocation(x, y);
	}
	
	public void switchToMenuPrincipal() {
		this.jframe.setSize(this.tailleBasique.getX(), this.tailleBasique.getY());
		this.centerFrame();
		jframe.setContentPane(this.menuPrincipal);
		jframe.setVisible(true);
		jframe.requestFocusInWindow();
	}
	
	public void switchToGameMenu() {
		this.gameEnded = false;
		this.jframe.setSize(this.tailleBasique.getX(), this.tailleBasique.getY());
		this.centerFrame();
		jframe.setContentPane(this.menuEnPartie);
		jframe.setVisible(true);
		jframe.requestFocusInWindow();
	}
	
	public void switchToOptions() {
		this.jframe.setSize(this.tailleBasique.getX(), this.tailleBasique.getY());
		this.centerFrame();
		jframe.setContentPane(this.options);
		jframe.setVisible(true);
		jframe.requestFocusInWindow();
	}
	
	public void switchToGame() {
		if(!this.gameEnded)
			this.switchToSelectNewGame();
		else
			this.switchToActualGame();
	}
	
	public void switchToActualGame() {
		this.jframe.setSize(DonneesGenerales.getTaillePlateau().getX(), DonneesGenerales.getTaillePlateau().getY());
		this.centerFrame();
		jframe.setContentPane(this.plateau);
		jframe.setVisible(true);
		jframe.requestFocusInWindow();
	}
	
	public void switchToSelectNewGame() {
		this.jframe.setSize(this.tailleBasique.getX(), this.tailleBasique.getY());
		this.centerFrame();
		jframe.setContentPane(this.selectNewGame);
		jframe.setVisible(true);
		jframe.requestFocusInWindow();
	}
	
	public void switchToNewGame() {
		this.gameEnded = false;
		this.plateau.reset();
		this.switchToActualGame();
	}

	public void endGame() {
		this.gameEnded = true;
		this.switchToMenuPrincipal();
	}
	
	public void switchToQuit() {
		System.exit(0);
	}
}
