package comportement;

import projet.DonneesPartie;
import projet.Mobile;

public class SeDeplacerGauche extends Comportement {
	private int value;
	
	public SeDeplacerGauche(Mobile entite, int value) {
		super((Mobile)entite, ComportementType.seDeplacerGauche);
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
	
	@Override
	public void faire() {
		if(!((DonneesPartie.getJoueurs().getObjetGraphique().getX() - 10) < 0))
			((Mobile)this.getEntite()).seDeplacer(-this.value, 0);
	}

	@Override
	public void etapeSuivante() {
		// TODO Auto-generated method stub
		
	}

}
