package armes;

import projet.Arme;
import projet.Projectile;
import projet.SensTirer;

public class Pistolet extends Arme {
	public Pistolet() {
		this.setNom("Pistolet");
		this.setRechargement(300);
	}
	
	@Override
	public Projectile fire(int x, int y, SensTirer sens) {
		if(this.isReloaded()) {
			this.reload();
			//public Projectile(int x, int y, int largeur, int hauteur, int degats, int deplacementX, int deplacementY, String spriteLien) {
			if(sens == SensTirer.versEnnemis)
				return new Projectile(x, y, 5, 5, 2, 0, -1, "sprites/projectiles/1/1.png");
			else if(sens == SensTirer.versDefenseur)
				return new Projectile(x, y, 5, 5, 2, 0, 1, "sprites/projectiles/1/1.png");
		}
		return null;
	}
}
