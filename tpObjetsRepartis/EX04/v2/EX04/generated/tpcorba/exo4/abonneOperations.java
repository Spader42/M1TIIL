package tpcorba.exo4;

/**
 *	Generated from IDL interface "abonne"
 *	@author JacORB IDL compiler V 2.2.2, 1-Jun-2005
 */


public interface abonneOperations
{
	/* constants */
	/* operations  */
	int numero();
	java.lang.String nom_prenom();
	tpcorba.exo4.type_abonnement abonnement();
	void abonnement(tpcorba.exo4.type_abonnement arg);
	tpcorba.exo4.type_adresse adresse();
	void adresse(tpcorba.exo4.type_adresse arg);
}
