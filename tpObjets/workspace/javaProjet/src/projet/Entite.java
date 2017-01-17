package projet;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import comportements.Comportement;
import comportements.ComportementType;

public abstract class Entite implements EntiteBasique {
	private int hp;
	private String nom;
	private boolean morte;
	private BufferedImage sprite;
	
	private ObjetGraphique objetGraphique;
	
	private ArrayList<Comportement> comportements;
	
	public Entite(int x, int y, int largeur, int hauteur, String spriteLien) {
		this.objetGraphique = new ObjetGraphique(x, y, largeur, hauteur);
		//System.out.println("Entité créee.");
		this.nom = "Entité";
		this.hp = 1;
		try{
			sprite = ImageIO.read(new File(spriteLien));
		}
		catch(IOException e){
			e.printStackTrace();
		}
		this.comportements = new ArrayList<Comportement>();
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getHP() {
		return this.hp;
	}
	
	public void removeHP(int hp) {
		this.hp -= hp;
		if(this.hp <= 0)
			this.mourir();
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void setMorte(boolean morte) {
		this.morte = morte;
	}
	
	public boolean isMorte() {
		return this.morte;
	}
	
	public ObjetGraphique getObjetGraphique() {
		return this.objetGraphique;
	}
	
	
	public void addComportement(Comportement comportement) {
		for(Comportement compare : this.comportements)
			if(comportement.getType() == compare.getType())
				return;
		
		this.comportements.add(comportement);
		System.out.println("Ajout du comportement \"" + comportement.getType().toString() + "\" à l'entité \"" + this.getNom() + "\"");
	}
	
	public void removeComportement(ComportementType type) {
		Comportement aDelete = null;
		for(Comportement comportement : this.comportements) {
			if(comportement.hasType(type))
				aDelete = comportement;
				break;
		}
		if(aDelete != null) {
			System.out.println("Suppression du comportement \"" + aDelete.getType().toString() + "\" à l'entité \"" + this.getNom() + "\"");
			this.comportements.remove(aDelete);
			aDelete = null;
		}
	}
	
	
	public abstract void changeHp();
	
	public void comportement() {
		for(Comportement comportement : this.comportements)
			comportement.faire();
	}
	
	@Override
	public void update() {
		if(	this.getObjetGraphique().getX() >= Plateau.getWindow().getSize().getWidth() ||
			this.getObjetGraphique().getX() <= 0 ||
			this.getObjetGraphique().getY() >= Plateau.getWindow().getSize().getHeight() ||
			this.getObjetGraphique().getY() <= 0) {
			
			this.mourir();
		}
	}
	
	public void mourir() {
		this.morte = true;
		//System.out.println("Entité morte.");
	}
	
	@Override
	public void paint(Graphics g){
		g.drawImage(sprite, this.getObjetGraphique().getX(), this.getObjetGraphique().getY(), this.getObjetGraphique().getLargeur(), this.getObjetGraphique().getHauteur(), null);
		this.comportement();
	}
}
