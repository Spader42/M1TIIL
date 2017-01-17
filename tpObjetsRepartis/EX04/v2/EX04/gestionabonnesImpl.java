package tpcorba.exo4;

import org.omg.CORBA.*;
import java.lang.*;
import org.omg.PortableServer.*;

import java.util.ArrayList;
import java.lang.IndexOutOfBoundsException;
import java.util.Iterator;

public class gestionabonnesImpl extends gestionabonnesPOA {
    protected   POA             poa_;
    private     abonne[]        l_abonnes;
    
    public gestionabonnesImpl(POA poa) {
        poa_ = poa;
        l_abonnes = new abonne[10];
        
        for(int i = 0; i < l_abonnes.length; i++) {
            l_abonnes[i] = null;
        }
    }
    
    public abonne[] liste_abonnes() {
        return l_abonnes;
    }
    
    public void liste_abonnes(abonne[] value) {
        this.l_abonnes = value;
    }
    
    public void creation_abonne(int numero,	String nom,	String prenom, type_adresse adresse, type_abonnement abonnement, abonneHolder ref) throws dejaExistant {
        try {
            int free = -1;
            for(int i = 0; i < l_abonnes.length; i++) {
                if(l_abonnes[i] != null && l_abonnes[i].numero() == numero) {
                    throw new dejaExistant();
                }
                else if(l_abonnes[i] == null){
                    free = i;
                }
            }
            
            if(free != -1) {
                abonneImpl abo = new abonneImpl(numero, nom + " " + prenom, adresse, abonnement);
                org.omg.CORBA.Object a = poa_.servant_to_reference(abo);
                ref.value = abonneHelper.narrow(a);
                l_abonnes[free] = ref.value;
            }
            else {
                System.out.println("Erreur : liste abonnés pleine");
            }
        }
        catch(org.omg.PortableServer.POAPackage.ServantNotActive a){
        
        }
        catch(org.omg.PortableServer.POAPackage.WrongPolicy b){
        
        } 
    }
    
    public void resilier_abonne(int numero) throws numeroInconnu {
        for(int i = 0; i < l_abonnes.length; i++) {
            if(l_abonnes[i] != null && l_abonnes[i].numero() == numero) {
                try {
                    byte [] ObjID = poa_.reference_to_id(l_abonnes[i]);
                    poa_.deactivate_object(ObjID);
                }
                
                catch (Exception e){
                    System.out.println("POA Execption " + e);
                }
                l_abonnes[i] = null;
                return;
            }
        }
            throw new numeroInconnu();
    }
    
    public void rechercher_abonne(int numero, abonneHolder ref) throws numeroInconnu {
        for(int i = 0; i < l_abonnes.length; i++) {
            if(l_abonnes[i] != null && l_abonnes[i].numero() == numero) {
                ref.value = l_abonnes[i];
                return;
            }
        }
        throw new numeroInconnu();
    }
}
