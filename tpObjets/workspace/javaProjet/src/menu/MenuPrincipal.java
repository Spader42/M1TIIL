package menu;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPrincipal extends JPanel {
	private static final long serialVersionUID = 1L;
	
	JButton boutonJouer;
	JButton boutonQuitter;
	JButton boutonOptions;
	
	BorderLayout layout;
	
	JPanel panel;
	
	Options options;
	
	public MenuPrincipal(final GestionnaireMenu gestionnaireMenu) {
		boutonJouer 		= new JButton("Jouer");
		boutonQuitter 		= new JButton("Quitter");
		boutonOptions 		= new JButton("Options");
		
		panel 				= new JPanel();
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		boutonJouer.setAlignmentX(Component.CENTER_ALIGNMENT);
		boutonQuitter.setAlignmentX(Component.CENTER_ALIGNMENT);
		boutonOptions.setAlignmentX(Component.CENTER_ALIGNMENT);

		panel.add(boutonJouer);
		panel.add(boutonOptions);
		panel.add(boutonQuitter);

		this.add(panel);

		boutonJouer.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent agr0){
	    		gestionnaireMenu.switchToGame();
	    	}
		});
		boutonQuitter.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent agr0){
	    		gestionnaireMenu.switchToQuit();
	    	}
		});
		boutonOptions.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent agr0){
	    		gestionnaireMenu.switchToOptions();
	    	}
		});
	}
}
