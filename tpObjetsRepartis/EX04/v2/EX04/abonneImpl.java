package tpcorba.exo4;

import org.omg.CORBA.*;
import java.lang.*;
import org.omg.PortableServer.*;

public class abonneImpl extends abonnePOA {
    private int                 numeroId;
    private String              nomPrenom;
    private type_abonnement     t_abonnement;
    private type_adresse        t_adresse;
    
    public abonneImpl(int id, String nom, type_adresse adr, type_abonnement abo) {
        numeroId    = id;
        nomPrenom   = nom;
        t_abonnement = abo;
        t_adresse   = adr;
    }
    
    public int numero() {
        return numeroId;
    }
    
    public String nom_prenom() {
        return nomPrenom;
    }
    
    public type_abonnement abonnement() {
        return t_abonnement;
    }
    
    public void abonnement(type_abonnement value) {
        t_abonnement = value;
    }
    
    public type_adresse adresse() {
        return t_adresse;
    }
    
    public void adresse(type_adresse value) {
        t_adresse = value;
    }
}
