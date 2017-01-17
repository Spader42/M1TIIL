package tpcorba.exo2;

/**
 *	Generated from IDL interface "calcul"
 *	@author JacORB IDL compiler V 2.2.2, 1-Jun-2005
 */


public interface calculOperations
{
	/* constants */
	/* operations  */
	double memoire();
	void incrementer(org.omg.CORBA.IntHolder data);
	void decrementer(org.omg.CORBA.IntHolder data);
	void multiplieMemoire(double data);
	void diviseMemoire(double data) throws tpcorba.exo2.divisionParZero;
	void ajouteMemoire(double data);
	void soustraitMemoire(double data);
	void miseAZero();
}
