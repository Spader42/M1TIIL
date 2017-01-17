package menu;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SelectNewGame extends JPanel {
	private static final long serialVersionUID = 1L;
	
	JButton boutonReprendrePartie;
	JButton boutonNewGame;
	
	BorderLayout layout;
	
	JPanel panel;
	
	public SelectNewGame(final GestionnaireMenu gestionnaireMenu) {
		boutonReprendrePartie	= new JButton("Reprendre la partie précédente");
		boutonNewGame 			= new JButton("Créer une nouvelle partie");
		
		panel = new JPanel();
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		boutonReprendrePartie.setAlignmentX(Component.CENTER_ALIGNMENT);
		boutonNewGame.setAlignmentX(Component.CENTER_ALIGNMENT);

		panel.add(boutonReprendrePartie);
		panel.add(boutonNewGame);

		this.add(panel);

		boutonReprendrePartie.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent agr0){
	    		gestionnaireMenu.switchToActualGame();;
	    	}
		});
		boutonNewGame.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent agr0){
	    		gestionnaireMenu.switchToNewGame();
	    	}
		});
	}

}
