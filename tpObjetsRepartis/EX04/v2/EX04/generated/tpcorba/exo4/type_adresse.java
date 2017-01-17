package tpcorba.exo4;

/**
 *	Generated from IDL definition of struct "type_adresse"
 *	@author JacORB IDL compiler 
 */

public final class type_adresse
	implements org.omg.CORBA.portable.IDLEntity
{
	public type_adresse(){}
	public int numero;
	public java.lang.String rue = "";
	public int code_postal;
	public java.lang.String ville = "";
	public type_adresse(int numero, java.lang.String rue, int code_postal, java.lang.String ville)
	{
		this.numero = numero;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
	}
}
