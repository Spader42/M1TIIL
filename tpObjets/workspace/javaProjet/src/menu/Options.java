package menu;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import projet.DonneesPartie;

public class Options extends JPanel{
	private static final long serialVersionUID = 1L;

	JButton boutonTextFieldOk;
	JButton boutonRevenir;
	
	JTextField textFieldPseudo;
	
	JPanel panel;
	
	Options(final GestionnaireMenu gestionnaireMenu) {
		panel = new JPanel();
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		textFieldPseudo		= new JTextField("Votre Pseudo");
		boutonTextFieldOk 	= new JButton("Ok");
		boutonRevenir		= new JButton("Revenir");

		textFieldPseudo.setAlignmentX(Component.CENTER_ALIGNMENT);
		boutonTextFieldOk.setAlignmentX(Component.CENTER_ALIGNMENT);
		boutonRevenir.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		panel.add(textFieldPseudo);
		panel.add(boutonTextFieldOk);
		
		this.add(panel);
		
		this.setVisible(true);
		
		boutonTextFieldOk.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent agr0){
	    		String nom = textFieldPseudo.getText();
	    		DonneesPartie.changerNomJoueur(nom);
	    		System.out.println("Nom du joueur changé en : " + nom);

	    		gestionnaireMenu.switchToMenuPrincipal();
	    	}
		});
	}
}
