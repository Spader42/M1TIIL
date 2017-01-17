package projet;

import java.util.ArrayList;

public abstract class EntiteArmee extends Entite implements Armee {
	private Arme armeActuelle;
	private ArrayList<Arme> armeDipo;
	
	public EntiteArmee(int x, int y, int largeur, int hauteur, String spriteLien) {
		super(x, y, largeur, hauteur, spriteLien);
		this.armeDipo = new ArrayList<Arme>();
	}

	@Override
	public Projectile tirer(SensTirer sens) {
		Projectile projectile = this.getArmeActuelle().fire(this.getObjetGraphique().getX(), this.getObjetGraphique().getY(), sens);
		if(projectile != null) {
			projectile.getObjetGraphique().setX(this.getObjetGraphique().getX() + (this.getObjetGraphique().getLargeur() / 2) - (projectile.getObjetGraphique().getLargeur() / 2));
			
			if(sens == SensTirer.versDefenseur)
				projectile.getObjetGraphique().setY(projectile.getObjetGraphique().getY() + this.getObjetGraphique().getHauteur() + 5);
			else
				projectile.getObjetGraphique().setY(projectile.getObjetGraphique().getY() - 5);
		}
		
		return projectile;
	}

	public Arme getArmeActuelle() {
		return this.armeActuelle;
	}

	public void setArmeActuelle(Arme armeActuelle) {
		this.armeActuelle = armeActuelle;
	}
	
	public void addArme(Arme arme) {
		if(arme != null && !this.armeDipo.contains(arme)) {
			this.armeDipo.add(arme);
			System.out.println("Ajout de l'arme \"" + arme.getNom() + "\"");
		}
		
		if(this.armeDipo.size() == 1)
			this.setArme(1);
	}
	
	public void setArme(int id) {
		if(id <= 0 || id > this.armeDipo.size())
			return;
		this.armeActuelle = this.armeDipo.get(id - 1);
		System.out.println("Passage à l'arme \"" + this.armeActuelle.getNom() + "\"");
	}
}
