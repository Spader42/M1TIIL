package tpcorba.exo4;

/**
 *	Generated from IDL definition of struct "type_adresse"
 *	@author JacORB IDL compiler 
 */

public final class type_adresseHolder
	implements org.omg.CORBA.portable.Streamable
{
	public tpcorba.exo4.type_adresse value;

	public type_adresseHolder ()
	{
	}
	public type_adresseHolder(final tpcorba.exo4.type_adresse initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return tpcorba.exo4.type_adresseHelper.type ();
	}
	public void _read(final org.omg.CORBA.portable.InputStream _in)
	{
		value = tpcorba.exo4.type_adresseHelper.read(_in);
	}
	public void _write(final org.omg.CORBA.portable.OutputStream _out)
	{
		tpcorba.exo4.type_adresseHelper.write(_out, value);
	}
}
