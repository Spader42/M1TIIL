
package tpcorba.exo4;

import org.omg.CORBA.*;

import java.io.*;

import java.lang.*;

import java.util.*;


public class Client {
    public static void main(String[] args) throws IOException {
        ////////////////////////////////////////////////////
        // On initialise l'ORB
        ////////////////////////////////////////////////////
        // initialize the ORB.
        ORB orb = ORB.init(args, null);

        if(args.length!=0)
            {
            System.err.println("utilisation : pas de parametre ");
            System.exit(1);
            }

        ////////////////////////////////////////////////////
        // Recuperation de la reference d'objet du serveur
        // Dans cet exemple, la reference est stockee sous
        // la forme d'une chaine de caracteres (IOR) dans un
        // fichier. A ce stade, il est bien sur possible 
        // d'invoquer un service de nommage.
        ////////////////////////////////////////////////////
        String ior = null;

        try {
            String ref = "gestion.ref";
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
        // Construction d'une reference d'objet, non typee d'abord,
        // puis "cast" en une reference sur l'interface 
        // "calcul"  avec narrow ("cast" dynamique)
        ////////////////////////////////////////////////////
        org.omg.CORBA.Object obj = orb.string_to_object(ior);

        if (obj == null) {
            System.err.println("Erreur sur string_to_object() ");
            throw new RuntimeException();
        }

        gestionabonnes gestion = gestionabonnesHelper.narrow(obj);

        if (gestion== null) {
            System.err.println("Erreur sur narrow() ");
            throw new RuntimeException();
        }

        ////////////////////////////////////////////////////
        // Invocation du serveur
        ////////////////////////////////////////////////////

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


	abonneHolder ref= new abonneHolder();
	String nom, prenom, numero, operation, adresse, abonnement;
	String ville, rue;
	int numeroadr, codePostal;

    type_adresse adr;
    type_abonnement abo = type_abonnement.from_int(0);
	while(true) 
		{	
		try
			{
      			System.out.println("Que faire : 1- Creation");
            	System.out.println("            2- Rechercher");
           	 	System.out.println("            3- Resilier");
      			operation = br.readLine();
      

			// Creation d'un abonne
			//
      			if (operation.equals("1"))  
				{
				System.out.print("- Numero  = " );
				numero = br.readLine();
				System.out.print("- Nom     = " );
				nom = br.readLine();
				System.out.print("- Prenom  = " );
				prenom = br.readLine();
				System.out.print("- Adresse : \n" );
				System.out.println("-- Rue          = ");
				rue = br.readLine();
				System.out.println("-- Ville        = ");
				ville = br.readLine();
				System.out.println("-- Code postal  = ");
				codePostal = new Integer(br.readLine());
				System.out.println("-- Numero rue   = ");
				numeroadr = new Integer(br.readLine());
				System.out.print("- Abonnement = ");
				abonnement = br.readLine();
				
				Integer num = new Integer(numero);
				
				adr = new type_adresse();
				adr.rue = rue;
				adr.code_postal = codePostal;
				adr.ville = ville;
				adr.numero = numeroadr;

				gestion.creation_abonne(num.intValue() ,nom, prenom, adr, abo, ref);
				System.out.println("--> Creation abonne :");
				System.out.println("-->N°         : " + numero);
				System.out.println("-->Nom        : " + ref.value.nom_prenom());
				
                String res = "";
                res += ref.value.adresse().numero;
                res += " rue ";
                res += ref.value.adresse().rue;
                res += " ";
                res += ref.value.adresse().ville;
                res += " ";
                res += ref.value.adresse().code_postal;
				
				System.out.println("-->Adresse    : " + res);
				System.out.println("-->Abonnement : " + ref.value.abonnement().value() + "\n");
				}  

				// Recherche d'un abonne
				//
      			else	if (operation.equals("2"))  
                			{
					System.out.print("- Numero = " );
					numero = br.readLine();
					Integer num = new Integer(numero);

					gestion.rechercher_abonne(num.intValue() ,ref);
					System.out.println("--> Numero " + numero + ":" + ref.value.nom_prenom() + "\n");
                			}

					// Resiliation d'un abonne
					//
      				else	if (operation.equals("3"))  
                				{
						System.out.print("- Numero = " );
						numero = br.readLine();
						Integer num = new Integer(numero);

						gestion.resilier_abonne(num.intValue());
						System.out.println("--> Numero " + numero + " resilie\n");
                				}
					else System.out.println("  Saisir '1', '2'  ou '3'");
			}
      		catch(IOException ex)
			{
			System.out.println("xx>Erreur lors de la lecture ");
			System.exit(1);
			}
      		catch(numeroInconnu ex)
			{
			System.out.println("xx>Exception : numeroInconnu");
			}
      		catch(dejaExistant ex)
			{
			System.out.println("xx>Exception : dejaExistant");
			}
		}

	}
}

