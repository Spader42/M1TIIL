package tpcorba.exo3;

import org.omg.CORBA.*;

import java.io.*;
import java.lang.*;
import java.util.*;


public class Client {
    public static void main(String[] args) throws IOException {
        ////////////////////////////////////////////////////
        ORB orb = ORB.init(args, null);

        if(args.length!=0)
               {
               System.err.println("utilisation : pas de parametre ");
               System.exit(1);
               }

        ////////////////////////////////////////////////////
        String ior = null;

        try {
            String ref = "cpt.ref";
            FileInputStream file = new FileInputStream(ref);
            BufferedReader in = new BufferedReader(new InputStreamReader(file));
            ior = in.readLine();
            file.close();
        } catch (IOException ex) {
            System.err.println("Impossible de lire fichier : `" +
                ex.getMessage() + "'");
            System.exit(1);
        }

        ////////////////////////////////////////////////////
        org.omg.CORBA.Object obj = orb.string_to_object(ior);

        if (obj == null) {
            System.err.println("Erreur sur string_to_object() ");
            throw new RuntimeException();
        }

        allocateur alloc= allocateurHelper.narrow(obj);

        if (alloc == null) {
            System.err.println("Erreur sur narrow() ");
            throw new RuntimeException();
        }

        ////////////////////////////////////////////////////
        // Invocation du serveur
        ////////////////////////////////////////////////////

        // Creation de deux comptes
        //
        compteHolder Hcpt1 = new compteHolder();
        compte cpt1;

        alloc.nouveau_compte(Hcpt1, "Maxime", 1);

        cpt1=Hcpt1.value;
        
        compteHolder Hcpt2 = new compteHolder();
        compte cpt2;
        
        alloc.nouveau_compte(Hcpt2, "Steeven", 2);
        
        cpt2 = Hcpt2.value;

        System.out.println(cpt1.afficher());
        System.out.println(cpt2.afficher());
        
        cpt1.crediter(250);
        cpt2.debiter(500);

        System.out.println(cpt1.afficher());
        System.out.println(cpt2.afficher());
        
        cpt1.prelevement(250, cpt2);
        
        System.out.println(cpt1.afficher());
        System.out.println(cpt2.afficher());
        
        System.exit(0);
    }
}
