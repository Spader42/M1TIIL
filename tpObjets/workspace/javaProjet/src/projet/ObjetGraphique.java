package projet;

public class ObjetGraphique {
	private int x;
	private int y;
	
	private int largeur;
	private int hauteur;
	
	public ObjetGraphique(int x, int y, int largeur, int hauteur) {
		this.x = x;
		this.y = y;
		this.largeur  = largeur;
		this.hauteur = hauteur;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	
	public int getLargeur() {
		return this.largeur;
	}
	
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
	
	public int getHauteur() {
		return this.hauteur;
	}
}
