package comportement;

import projet.EntiteBasique;

public abstract class Comportement {
	private EntiteBasique entite;
	private ComportementType type;
	
	public Comportement(EntiteBasique entite, ComportementType type) {
		this.entite = entite;
		this.type = type;
	}
	
	public ComportementType getType() {
		return this.type;
	}
	
	public boolean hasType(ComportementType type) {
		return this.type == type;
	}
	
	public EntiteBasique getEntite() {
		return this.entite;
	}
	
	public abstract void faire();
	public abstract void etapeSuivante();
}
