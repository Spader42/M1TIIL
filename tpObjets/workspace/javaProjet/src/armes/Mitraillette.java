package armes;

import projet.Arme;
import projet.Projectile;
import projet.SensTirer;

public class Mitraillette extends Arme {
	public Mitraillette() {
		this.setNom("Mitraillette");
		this.setRechargement(100);
	}
	
	@Override
	public Projectile fire(int x, int y, SensTirer sens) {
		if(this.isReloaded()) {
			this.reload();
			//public Projectile(int x, int y, int largeur, int hauteur, int degats, int deplacementX, int deplacementY, String spriteLien) {
			if(sens == SensTirer.versEnnemis)
				return new Projectile(x, y, 5, 5, 1, 0, -2, "sprites/projectiles/1/1.png");
			else if(sens == SensTirer.versDefenseur)
				return new Projectile(x, y, 5, 5, 1, 0, 2, "sprites/projectiles/1/1.png");
		}
		return null;
	}

}
