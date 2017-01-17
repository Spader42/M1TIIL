
package tpcorba.exo3;

import org.omg.CORBA.*;
import java.lang.*;


public class compteImpl extends comptePOA {

	private int nombreOp;
    private int numeroCompte;
	private String titulaireCompte;
	private double soldeCompte;

    public int numero_compte() {
        return numeroCompte;
    }
    
    public String titulaire() {
        return titulaireCompte;
    }   
    
    public double solde() {
        return soldeCompte;
    }
    
    public String afficher() {
	    String res = "";
	    
	    res += "Nom        : " + titulaireCompte;
	    res += "\nSolde      : " + soldeCompte + "e";
	    res += "\nCompte N°  : " + numeroCompte;
	    res += "\nNombre OPs : " + nombreOp;
	    res += "\n";
	    
	    return res;
	}
    
	public compteImpl(String t, int num) {
        titulaireCompte = t;
        nombreOp        = 0;
        numeroCompte    = num;
        soldeCompte     = 0;
	}
	
	public void nombre_operations(IntHolder nombre) {
	    nombre.value = nombreOp;
	    nombreOp++;
	}
	
	public void debiter(double montant) {
	    soldeCompte -= montant;
	    nombreOp++;
	    log("Débit  de " + montant + "€");
	}
	
	public void crediter(double montant) {
	    soldeCompte += montant;
	    nombreOp++;
	    log("Crédit de " + montant + "€");
	}

	public void prelevement(double montant, compte destination) {
	    soldeCompte -= montant;
	    destination.crediter(montant);
	    nombreOp++;
	    log("Prélèvement de " + montant + "€ vers le compte : " + destination.numero_compte());
	}
	
	private void log(String s) {
	    System.out.println("[Compte n°" + numeroCompte + "] " + s);
	}
}


