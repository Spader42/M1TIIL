package tpcorba.exo4;
/**
 *	Generated from IDL definition of enum "type_abonnement"
 *	@author JacORB IDL compiler 
 */

public final class type_abonnementHolder
	implements org.omg.CORBA.portable.Streamable
{
	public type_abonnement value;

	public type_abonnementHolder ()
	{
	}
	public type_abonnementHolder (final type_abonnement initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return type_abonnementHelper.type ();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = type_abonnementHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream out)
	{
		type_abonnementHelper.write (out,value);
	}
}
