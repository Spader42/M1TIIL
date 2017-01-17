package comportement;

import projet.DonneesPartie;
import projet.EntiteArmee;
import projet.Projectile;
import projet.SensTirer;

public class Tirer extends Comportement {
	private SensTirer sens;
	
	public Tirer(EntiteArmee entite, SensTirer sens) {
		super(entite, ComportementType.tirer);
		this.sens = sens;
	}

	public SensTirer getSens() {
		return this.sens;
	}
	
	@Override
	public void faire() {
		Projectile projectile = ((EntiteArmee)this.getEntite()).tirer(this.sens);
		if(!(projectile == null))
			DonneesPartie.addProjectileDefenseur(projectile);
	}

	@Override
	public void etapeSuivante() {
		// TODO Auto-generated method stub
		
	}

}
