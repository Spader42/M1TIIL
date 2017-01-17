package tpcorba.exo2;

import org.omg.CORBA.*;

import java.io.*;

import java.lang.*;

import java.util.*;


public class Client {
 
    public static void main(String[] args) throws IOException {

        ORB orb = ORB.init(args, null);
        
        if (args.length != 0) {
            System.err.println("pas de parametre svp");
            System.exit(1);
        }

        ////////////////////////////////////////////////////

        String ior = null;

        try {
            String ref = "calcul.ref";
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

        calcul calc = calculHelper.narrow(obj);

        if (calc == null) {
            System.err.println("Erreur sur narrow() ");
            throw new RuntimeException();
        }

        ////////////////////////////////////////////////////
        // Invocation du serveur
        ////////////////////////////////////////////////////
        try
        {

	
	        System.out.println("Contenu de la mémoire avant opération : " + calc.memoire());

	
	        System.out.println("Opération à effectuer :\n- 1 Ajouter\n- 2 Soustraire\n- 3 Diviser\n- 4 Multiplier\n- 5 Mise à zero");
            char car    = (char) System.in.read();
            double  data   = 0.0;
            Scanner sc = new Scanner(System.in);
            if(car == '1'){
                System.out.println("Entrez votre nombre : ");
                data = sc.nextDouble();
                calc.ajouteMemoire(data);
            }
            else if(car == '2'){
                System.out.println("Entrez votre nombre : ");
                data = sc.nextDouble();
                calc.soustraitMemoire(data);
            }
            else if(car == '3') {
                System.out.println("Entrez votre nombre : ");
                data = sc.nextDouble();
                calc.diviseMemoire(data);
            }
            else if(car == '4') {
                System.out.println("Entrez votre nombre : ");
                data = sc.nextDouble();
                calc.multiplieMemoire(data);
            }
            else if(car == '5') {
                calc.miseAZero();
            }

	        System.out.println("Contenu de la mémoire après opération : " + calc.memoire());
        }
        catch(divisionParZero ex)
                {
                System.err.println("Exception : division par zero" );
                System.exit(1);
                }

        System.exit(0);
    }
}
