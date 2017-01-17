package tpcorba.exo3;

import org.omg.CORBA.*;
import java.lang.*;
import org.omg.PortableServer.*;


public class allocateurImpl extends allocateurPOA
{
	protected  POA poa_;

	public  allocateurImpl(POA poa) {
	    poa_=poa;
	}
	
	public void nouveau_compte(compteHolder cpt, String titulaire, int numero_compte) {
	    compteImpl c = new compteImpl(titulaire, numero_compte);
        try {
            org.omg.CORBA.Object compte = poa_.servant_to_reference(c);
            cpt.value = compteHelper.narrow(compte);
        }
        catch(org.omg.PortableServer.POAPackage.ServantNotActive a){
        
        }
        catch(org.omg.PortableServer.POAPackage.WrongPolicy b){
        
        }   
	}
}
