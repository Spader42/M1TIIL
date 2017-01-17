package menu;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuEnParti extends JPanel{
	private static final long serialVersionUID = 1L;
	
	JButton boutonReprendre;
	JButton boutonQuitter;
	JButton boutonMenuPrincipal;
	
	BorderLayout layout;
	
	JPanel panel;
	
	public MenuEnParti(final GestionnaireMenu gestionnaireMenu) {
		boutonReprendre		= new JButton("Reprendre la partie");
		boutonMenuPrincipal	= new JButton("Menu principal");
		boutonQuitter 		= new JButton("Quitter");
		
		panel 				= new JPanel();
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		boutonReprendre.setAlignmentX(Component.CENTER_ALIGNMENT);
		boutonMenuPrincipal.setAlignmentX(Component.CENTER_ALIGNMENT);
		boutonQuitter.setAlignmentX(Component.CENTER_ALIGNMENT);

		panel.add(boutonReprendre);
		panel.add(boutonMenuPrincipal);
		panel.add(boutonQuitter);

		this.add(panel);

		boutonReprendre.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent agr0){
	    		gestionnaireMenu.switchToActualGame();
	    	}
		});
		boutonQuitter.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent agr0){
	    		gestionnaireMenu.switchToQuit();
	    	}
		});
		boutonMenuPrincipal.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent agr0){
	    		gestionnaireMenu.switchToMenuPrincipal();
	    	}
		});
	}	
}
