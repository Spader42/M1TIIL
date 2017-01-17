package comportement;

import projet.DonneesGenerales;
import projet.DonneesPartie;
import projet.Mobile;

public class SeDeplacerDroite extends Comportement {
	private int value;
	
	public SeDeplacerDroite(Mobile entite, int value) {
		super((Mobile)entite, ComportementType.seDeplacerDroite);
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
	
	@Override
	public void faire() {
		if(!((DonneesPartie.getJoueurs().getObjetGraphique().getX() + this.value) > DonneesGenerales.getTaillePlateau().getX()))
			((Mobile)this.getEntite()).seDeplacer(this.value, 0);
	}

	@Override
	public void etapeSuivante() {
		
	}

}
