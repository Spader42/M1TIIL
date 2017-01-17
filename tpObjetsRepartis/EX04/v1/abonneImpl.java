package tpcorba.exo4;

import org.omg.CORBA.*;
import java.lang.*;
import org.omg.PortableServer.*;

public class abonneImpl extends abonnePOA {
    private int     numeroId;
    private String  nomPrenom;
    
    public abonneImpl(int id, String nom) {
        numeroId    = id;
        nomPrenom   = nom;
    }
    
    public int numero() {
        return numeroId;
    }
    
    public String nom_prenom() {
        return nomPrenom;
    }
}
