package projet;

public class DonneesGenerales {
	private static DimensionDonnees taillePlateau;
	private static int hightScore;
	private static DimensionDonnees dimensionEnnemis;
	private static DimensionDonnees dimensionDecalage;
	private static DimensionDonnees dimensionCoordonneesBasique;
	
	static void init() {
		hightScore = 0;
		dimensionEnnemis 			= new DimensionDonnees(35,35);
		dimensionDecalage			= new DimensionDonnees(20, 20);
		dimensionCoordonneesBasique	= new DimensionDonnees(20, 20);
		taillePlateau 				= new DimensionDonnees(1500, 500);
	}
	
	public static DimensionDonnees getTaillePlateau(){
		return taillePlateau;
	}
	static void setTaillePlateau(DimensionDonnees taillePlateau){
		DonneesGenerales.taillePlateau.setX(taillePlateau.getX());
		DonneesGenerales.taillePlateau.setY(taillePlateau.getY());
	}
	
	static int getHightScore() {
		return hightScore;
	}
	

	static DimensionDonnees getDimensionEnnemis() {
		return dimensionEnnemis;
	}
	
	static DimensionDonnees getDimensionDecalage() {
		return dimensionDecalage;
	}
	
	static DimensionDonnees getDimensionCoordonneesBasique() {
		return dimensionCoordonneesBasique;
	}
	
	static void setDimensionEnnemis(DimensionDonnees dimensionEnnemis){
		DonneesGenerales.dimensionEnnemis.setX(dimensionEnnemis.getX());
		DonneesGenerales.dimensionEnnemis.setY(dimensionEnnemis.getY());
	}

	static void setDimensionEnnemis(int x, int y){
		DonneesGenerales.dimensionEnnemis.setX(x);
		DonneesGenerales.dimensionEnnemis.setY(y);
	}
	
	static void setHightScore(int hightScore) {
		DonneesGenerales.hightScore = hightScore;
	}
}
