package projet;

import java.util.ArrayList;
import java.util.Random;

public class GestionnairePlateaux {
	static abstract class SubTableau {
		private int coefficient;
		
		public SubTableau(int coefficient) {
			this.coefficient = coefficient;
		}
		
		public int getCoefficient() {
			return this.coefficient;
		}
		
		public abstract ArrayList<Ennemi> getTableau();
	}
	
	static class SubTableauBasique extends SubTableau {

		public SubTableauBasique(int coefficient) {
			super(coefficient);
		}

		@Override
		public ArrayList<Ennemi> getTableau() {
			int initX = 10;
			int x = 10;
			int y = 20;
			DimensionDonnees dim = DonneesGenerales.getDimensionEnnemis();
			ArrayList<Ennemi> result = new ArrayList<Ennemi>();
						result.add(		new Ennemi((x = initX), y, dim.getX(), dim.getY(), EnnemiType.soldat, "sprites/ennemis/1/1.png"));
						result.add( 	new Ennemi((x += dim.getX() + 10), y, dim.getX(), dim.getY(), EnnemiType.soldat, "sprites/ennemis/1/1.png"));
						result.add(		new Ennemi((x += dim.getX() + 10), y, dim.getX(), dim.getY(), EnnemiType.soldat, "sprites/ennemis/1/1.png"));
						result.add(		new Ennemi((x += dim.getX() + 10), y, dim.getX(), dim.getY(), EnnemiType.soldat, "sprites/ennemis/1/1.png"));
						result.add(		new Ennemi((x += dim.getX() + 10), y, dim.getX(), dim.getY(), EnnemiType.soldat, "sprites/ennemis/1/1.png")); 
						
						result.add(		new Ennemi((x = initX), (y += dim.getY() + 10), dim.getX(), dim.getY(), EnnemiType.soldat, "sprites/ennemis/1/1.png"));
						result.add(		new Ennemi((x += dim.getX() + 10), y, dim.getX(), dim.getY(), EnnemiType.soldat, "sprites/ennemis/1/1.png"));
						result.add(		new Ennemi((x += dim.getX() + 10), y, dim.getX(), dim.getY(), EnnemiType.soldat, "sprites/ennemis/1/1.png"));
						result.add(		new Ennemi((x += dim.getX() + 10), y, dim.getX(), dim.getY(), EnnemiType.soldat, "sprites/ennemis/1/1.png"));
						result.add(		new Ennemi((x += dim.getX() + 10), y, dim.getX(), dim.getY(), EnnemiType.soldat, "sprites/ennemis/1/1.png"));
									
						result.add(		new Ennemi((x = initX), (y += dim.getY() + 10), dim.getX(), dim.getY(), EnnemiType.soldat, "sprites/ennemis/1/1.png"));
						result.add(		new Ennemi((x += dim.getX() + 10), y, dim.getX(), dim.getY(), EnnemiType.soldat, "sprites/ennemis/1/1.png"));
						result.add(		new Ennemi((x += dim.getX() + 10), y, dim.getX(), dim.getY(), EnnemiType.soldat, "sprites/ennemis/1/1.png"));
						result.add(		new Ennemi((x += dim.getX() + 10), y, dim.getX(), dim.getY(), EnnemiType.soldat, "sprites/ennemis/1/1.png"));
						result.add(		new Ennemi((x += dim.getX() + 10), y, dim.getX(), dim.getY(), EnnemiType.soldat, "sprites/ennemis/1/1.png"));
											
						result.add(		new Ennemi((x = initX), (y += dim.getY() + 10), dim.getX(), dim.getY(), EnnemiType.soldat, "sprites/ennemis/1/1.png"));
						result.add(		new Ennemi((x += dim.getX() + 10), y, dim.getX(), dim.getY(), EnnemiType.soldat, "sprites/ennemis/1/1.png"));
						result.add(		new Ennemi((x += dim.getX() + 10), y, dim.getX(), dim.getY(), EnnemiType.soldat, "sprites/ennemis/1/1.png"));
						result.add(		new Ennemi((x += dim.getX() + 10), y, dim.getX(), dim.getY(), EnnemiType.soldat, "sprites/ennemis/1/1.png"));
						result.add(		new Ennemi((x += dim.getX() + 10), y, dim.getX(), dim.getY(), EnnemiType.soldat, "sprites/ennemis/1/1.png")); 
									
			return result;
		}
		
	}
	
	static int coefficient;
	static ArrayList<SubTableau> subTableaux;
	
	static void init(){
		subTableaux = new ArrayList<SubTableau>();
		
		subTableaux.add(new SubTableauBasique(2));
		subTableaux.add(new SubTableauBasique(6));
		subTableaux.add(new SubTableauBasique(6));
		subTableaux.add(new SubTableauBasique(2));
		
		for(SubTableau subTableau : subTableaux)
			coefficient += subTableau.getCoefficient();
	}
	
	static ArrayList<Ennemi> getNexTableau() {
		Random r = new Random();
		int valeur = r.nextInt(coefficient);
		
		int index = 0;
		int previousValue = 0;
		int newValue = subTableaux.get(0).getCoefficient();
		while(previousValue != coefficient) {
			if(valeur >= previousValue && valeur < newValue)
				break;
			
			previousValue = newValue;
			newValue += subTableaux.get(index + 1).getCoefficient();
			index++;
		}
		
		return subTableaux.get(index).getTableau();
	}
}
