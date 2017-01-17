package projet;

import java.util.ArrayList;
import java.util.Iterator;

import armes.Bazooka;
import armes.Mitraillette;

public class DonneesPartie {
	private static Defenseur 				joueur;
	private static ArrayList<Ennemi>		ennemis;
	private static ArrayList<Projectile> 	projectileDefenseur;
	private static ArrayList<Projectile>	projectileEnnemis;
	
	static void init() {
		ennemis = GestionnairePlateaux.getNexTableau();
		projectileDefenseur = new ArrayList<Projectile>();
		projectileEnnemis = new ArrayList<Projectile>();
	}
	
	public static void changerNomJoueur(String nom) {
		joueur.setNom(nom);
	}
	
	public static Defenseur getJoueurs(){
		return joueur;
	}
	
	static ArrayList<Ennemi> getEnnemis(){
		return ennemis;
	}
	
	static ArrayList<Projectile> getProjectileDefenseur(){
		return projectileDefenseur;
	}
	
	static ArrayList<Projectile> getProjectileEnnemis(){
		return projectileEnnemis;
	}
	
	static void setJoueur(Defenseur defenseur){
		joueur = defenseur;
	}
	
	static void setEnnemis(ArrayList<Ennemi> ennemis){
		DonneesPartie.ennemis = ennemis;
	}
	
	static void setProjectileDefenseur(ArrayList<Projectile> projectileDefenseur){
		DonneesPartie.projectileDefenseur = projectileDefenseur;
	}
	
	static void setProjectileEnnemis(ArrayList<Projectile> projectileEnnemis){
		DonneesPartie.projectileEnnemis = projectileEnnemis;
	}
	
	public static void addProjectileDefenseur(Projectile projectile){
		projectileDefenseur.add(projectile);
	}

	static void addProjectileEnnemi(Projectile projectile){
		projectileEnnemis.add(projectile);
	}
	
	static void addEnnemi(Ennemi ennemi){
		ennemis.add(ennemi);
	}
	
	static boolean removeEnnemi(Ennemi ennemi){
		return ennemis.remove(ennemi);
	}
	
	static boolean removeProjectileDefenseur(Projectile projectile){
		return projectileDefenseur.remove(projectile);
	}

	static boolean removeProjectileEnnemis(Projectile projectile){
		return projectileEnnemis.remove(projectile);
	}
	
	static int getNbEnnemis() {
		return ennemis.size();
	}
	
	static public void checkScore() {
		switch(DonneesPartie.getJoueurs().getScore()) {
		case 10:
			DonneesPartie.getJoueurs().addArme(new Mitraillette());
			break;
		case 20: 
			DonneesPartie.getJoueurs().addArme(new Bazooka());
			break;
		}
	}
	
	static Ennemi[][] ennemisToTable() {
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		
		//Récupération des index dans la liste correspondant au passage à une nouvelle ligne d'ennemis
		int index = 0;
		while(index != ennemis.size() - 1) {
			if(ennemis.get(index).getObjetGraphique().getY() < ennemis.get(index + 1).getObjetGraphique().getY()) {
				indexes.add(index);
				index++;
			}
			index++;
		}
				
		//System.out.println("index = " + indexes);
		int indexMax = 0;
		int indexCurrent = -1;
		int nbIndex = 0;
		int i = 0;
		
		//Récupération de la taille maximale d'une ligne
		for(int parcours = 0; parcours < indexes.size(); parcours++) {
			nbIndex = 0;
			for(i = indexCurrent;  i < indexes.get(parcours); i++)
				nbIndex++;
			
			if(nbIndex > indexMax)
				indexMax = nbIndex;
			
			indexCurrent = indexes.get(parcours);
		}
		
		//Création du tableau en fonction du nombre de ligne et de colonnes trouvés précédemment
		Ennemi result[][] = new Ennemi[indexes.size() + 1][indexMax];
		
		Iterator<Ennemi> ite = ennemis.iterator();
		for(i = 0; i < result.length; i++)
			for(int j = 0; j < result[i].length; j++)
				result[i][j] = ite.next();
		
		/*for(i = 0; i < result.length; i++) {
			for(int j = 0; j < result[i].length; j++)
				System.out.print(result[i][j].getNom() + "|");
			System.out.println();
		}*/
		
		return result;
	}
}
