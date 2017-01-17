package projet;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import menu.*;

import javax.swing.JFrame;

class GestFenetre extends WindowAdapter {
	public GestFenetre(JFrame window) {
		window.addWindowListener(this);
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}

public class Main {

	public static void main(String[] args) {
		System.out.println("Bonjour !");
		
		JFrame window = new JFrame(); //Creation de la fenetre
		window.setResizable(false);
			
		GestionnaireMenu gestionnaireMenu  = new GestionnaireMenu(window);
		gestionnaireMenu.switchToMenuPrincipal();
		
		new GestFenetre(window); //Pour terminer le programme quand la fenêtre est fermée
	}

}
