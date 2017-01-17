package projet;

import java.awt.Graphics;

public class HUD {
	public void paint(Graphics g) {
		String score = DonneesPartie.getJoueurs().getNom()  + " : "+  DonneesPartie.getJoueurs().getScore();
		String hightScore = "Hight Score : " + DonneesGenerales.getHightScore();
		String energie = "Energie : " + DonneesPartie.getJoueurs().getHP();
		
		int cordX = DonneesGenerales.getDimensionCoordonneesBasique().getX();
		int cordY = DonneesGenerales.getDimensionCoordonneesBasique().getY();
		
		int decalageX = DonneesGenerales.getDimensionDecalage().getX();
		int decalageY = DonneesGenerales.getDimensionDecalage().getY();
		
		g.drawString(score, 20, 20);
		
		g.drawString(hightScore, (int)	(Plateau.getWindow().getSize().getWidth() 
										- Plateau.getWindow().getGraphics().getFontMetrics().stringWidth(hightScore) 
										- decalageX), cordY);
		
		g.drawString(energie, cordX, (int)	(Plateau.getWindow().getSize().getHeight()
											- Plateau.getWindow().getGraphics().getFontMetrics().getHeight()
											- decalageY));
	}
}
