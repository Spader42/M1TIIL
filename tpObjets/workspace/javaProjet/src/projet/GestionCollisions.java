package projet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GestionCollisions {
	HashMap<Ennemi,ArrayList<Projectile>> getEnnemiTouche(){
		HashMap<Ennemi,ArrayList<Projectile>> resultat = new HashMap<Ennemi,ArrayList<Projectile>>();
		Iterator<Ennemi> itrEnnemi = DonneesPartie.getEnnemis().iterator();
		while (itrEnnemi.hasNext()){
			ArrayList<Projectile> listProjectile = new ArrayList<Projectile>();
			Ennemi ennemi = itrEnnemi.next();
			
			Iterator<Projectile> itrProjectile = DonneesPartie.getProjectileDefenseur().iterator();
			while(itrProjectile.hasNext()){
				Projectile projectileTemp = itrProjectile.next();
				
				if (collisionEntite(ennemi,projectileTemp)){
					listProjectile.add(projectileTemp);
				}
					
			}
			if (listProjectile.size() > 0)
				resultat.put(ennemi, listProjectile);
		}
		
		return resultat;
		
	}
	
	ArrayList<Projectile> getDefenseurToucheParProjectile(){
		ArrayList<Projectile> resultat = new ArrayList<Projectile>();
		if (DonneesPartie.getJoueurs() == null)
			return resultat;
		
		Iterator<Projectile> itrProjectile = DonneesPartie.getProjectileEnnemis().iterator();
		while(itrProjectile.hasNext()){
			Projectile projectileTemp = itrProjectile.next();
			
			if (collisionEntite(DonneesPartie.getJoueurs(),projectileTemp)){
				resultat.add(projectileTemp);
			}
				
		}
		
		return resultat;
		
	}
	
	ArrayList<Ennemi> getDefenseurToucheParEnnemi(){
		ArrayList<Ennemi> resultat = new ArrayList<Ennemi>();
		if (DonneesPartie.getJoueurs() == null)
			return resultat;
		
		Iterator<Ennemi> itrEnnemi = DonneesPartie.getEnnemis().iterator();
		while(itrEnnemi.hasNext()){
			Ennemi ennemiTemp = itrEnnemi.next();
			
			if (collisionEntite(DonneesPartie.getJoueurs(),ennemiTemp)){
				resultat.add(ennemiTemp);
			}
				
		}
		
		return resultat;
		
	}

	private boolean collisionEntite(Entite e1, Entite e2){
		int yE1 = e1.getObjetGraphique().getY();
		int xE1 = e1.getObjetGraphique().getX();
		int largeurE1 = e1.getObjetGraphique().getLargeur();
		int hauteurE1 = e1.getObjetGraphique().getHauteur();
		
		int yE2 = e2.getObjetGraphique().getY();
		int xE2 = e2.getObjetGraphique().getX();
		int largeurE2 = e2.getObjetGraphique().getLargeur();
		int hauteurE2 = e2.getObjetGraphique().getHauteur();
		
		return (// vérification prositionx
				xE2 + largeurE2 >=	xE1 && 
				xE2 <= xE1 + largeurE1 &&
				// vérification position Y
				yE2 + hauteurE2 >=	yE1 && 
				yE2 <= yE1 + hauteurE1);
			
	}
}
