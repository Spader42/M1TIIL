package projet;

import java.awt.Graphics;

public class Projectile extends Entite implements Mobile {
	private int degats;
	private int deplacementX;
	private int deplacementY;
	
	public Projectile(int x, int y, int largeur, int hauteur, int degats, int deplacementX, int deplacementY, String spriteLien) {
		super(x, y, largeur, hauteur, spriteLien);
		this.degats 		= degats;
		this.deplacementX 	= deplacementX;
		this.deplacementY 	= deplacementY;
	}
	
	public int getDegats(){
		return this.degats;
	}
	
	public int getDeplacementX(){
		return this.deplacementX;
	}
	
	public int getDeplacementY(){
		return this.deplacementY;
	}
	
	public void setDegats(int degats){
		this.degats = degats;
	}
	
	public void setDeplacementX(int deplacementX){
		this.deplacementX = deplacementX;
	}
	
	public void setDeplacementY(int deplacementY){
		this.deplacementY = deplacementY;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		this.comportement();
	}

	@Override
	public void seDeplacer(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeHp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void comportement() {
		this.getObjetGraphique().setY(this.getObjetGraphique().getY() + this.deplacementY);
		this.getObjetGraphique().setX(this.getObjetGraphique().getX() + this.deplacementX);
	}
}
