package projet;

import armes.Pistolet;

public class Defenseur extends EntiteArmee implements Mobile {
	private int score;
	
	public Defenseur(int x, int y, int largeur, int hauteur, String spriteLien) {
		super(x, y, largeur, hauteur, spriteLien);
		this.addArme(new Pistolet());
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public void addScore(int score) {
		this.score += score;
		DonneesPartie.checkScore();
	}
	
	@Override
	public void seDeplacer(int x, int y) {
		this.getObjetGraphique().setX(this.getObjetGraphique().getX() + x);
		this.getObjetGraphique().setY(this.getObjetGraphique().getY() + y);
	}

	@Override
	public void changeHp() {
		// TODO Auto-generated method stub
	}
}
