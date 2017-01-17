package projet;


import armes.EnnemisArme;

public class Ennemi extends EntiteArmee implements Mobile {
	private int nbpoint;
	private EnnemiType type;
	
	public Ennemi(int x, int y, int largeur, int hauteur, EnnemiType type, String spriteLien) {
		super(x, y, largeur, hauteur, spriteLien);
		constructionParDefaut(type);
		this.addArme(new EnnemisArme());
	}
	
	protected void copie(Ennemi ennemi){
		this.nbpoint = ennemi.nbpoint;
		this.type = ennemi.type;
	}
	
	protected void constructionParDefaut(EnnemiType type){
		this.type = type;
		this.nbpoint = 1;
		return;
	}
	
	public EnnemiType getType() {
		return this.type;
	}

	public void setType(EnnemiType type) {
		this.type = type;
	}

	public int getNbpoint() {
		return this.nbpoint;
	}

	public void setNbpoint(int nbpoint) {
		this.nbpoint = nbpoint;
	}
	
	@Override
	public void seDeplacer(int x, int y) {
		this.getObjetGraphique().setX(this.getObjetGraphique().getX() + x);
		this.getObjetGraphique().setY(this.getObjetGraphique().getY() + y);
	}

	@Override
	public void changeHp() {
		
	}	
}
