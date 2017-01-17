package tpcorba.exo4;

/**
 *	Generated from IDL definition of alias "table_abonne"
 *	@author JacORB IDL compiler 
 */

public final class table_abonneHolder
	implements org.omg.CORBA.portable.Streamable
{
	public tpcorba.exo4.abonne[] value;

	public table_abonneHolder ()
	{
	}
	public table_abonneHolder (final tpcorba.exo4.abonne[] initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return table_abonneHelper.type ();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = table_abonneHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream out)
	{
		table_abonneHelper.write (out,value);
	}
}
