package armes;

import projet.Arme;
import projet.Projectile;
import projet.SensTirer;

public class Bazooka extends Arme {
	public Bazooka() {
		this.setNom("Bazooka");
		this.setRechargement(1000);
	}
	
	@Override
	public Projectile fire(int x, int y, SensTirer sens) {
		if(this.isReloaded()) {
			this.reload();
			//public Projectile(int x, int y, int largeur, int hauteur, int degats, int deplacementX, int deplacementY, String spriteLien) {
			if(sens == SensTirer.versEnnemis)
				return new Projectile(x, y, 30, 30, 10, 0, -1, "sprites/projectiles/1/1.png");
			else if(sens == SensTirer.versDefenseur)
				return new Projectile(x, y, 30, 30, 10, 0, 1, "sprites/projectiles/1/1.png");
		}
		return null;
	}
}
