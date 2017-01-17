package tpcorba.exo4;

import org.omg.CORBA.*;
import java.lang.*;
import org.omg.PortableServer.*;

import java.util.ArrayList;
import java.lang.IndexOutOfBoundsException;
import java.util.Iterator;

public class gestionabonnesImpl extends gestionabonnesPOA {
    protected POA poa_;
    private   ArrayList<abonneImpl> abonnes;
    
    public gestionabonnesImpl(POA poa) {
        poa_ = poa;
        abonnes = new ArrayList<abonneImpl>();
    }
    
    public void creation_abonne(int numero,	String nom,	String prenom, abonneHolder ref) throws dejaExistant {
        try {
            Iterator<abonneImpl> itr = abonnes.iterator();
            while(itr.hasNext()) {
                abonneImpl tmp = itr.next();
                if(tmp.numero() == numero) {
                    throw new dejaExistant();
                }
            }
            abonneImpl abo = new abonneImpl(numero, nom + " " + prenom);
            org.omg.CORBA.Object a = poa_.servant_to_reference(abo);
            ref.value = abonneHelper.narrow(a);
            abonnes.add(abo);
        }
        catch(org.omg.PortableServer.POAPackage.ServantNotActive a){
        
        }
        catch(org.omg.PortableServer.POAPackage.WrongPolicy b){
        
        } 
    }
    
    public void resilier_abonne(int numero) throws numeroInconnu {
        Iterator<abonneImpl> itr = abonnes.iterator();
        boolean trouve = false;
        while(itr.hasNext()) {
            abonneImpl tmp = itr.next();
            if(tmp.numero() == numero) {
                abonnes.remove(tmp);
                trouve = true;
                break;
            }
        }
        if(!trouve)
            throw new numeroInconnu();
    }
    
    public void rechercher_abonne(int numero, abonneHolder ref) throws numeroInconnu {
        Iterator<abonneImpl> itr = abonnes.iterator();
        boolean trouve = false;
        while(itr.hasNext()) {
            abonneImpl tmp = itr.next();
            if(tmp.numero() == numero) {
                trouve = true;
                try {
                    org.omg.CORBA.Object a = poa_.servant_to_reference(tmp);
                    ref.value = abonneHelper.narrow(a);
                }
                catch(org.omg.PortableServer.POAPackage.ServantNotActive a){
                
                }
                catch(org.omg.PortableServer.POAPackage.WrongPolicy b){
                
                } 
                break;
            }
        }
        if(!trouve)
            throw new numeroInconnu();
    }
}
