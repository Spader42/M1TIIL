package tpcorba.exo4;

/**
 *	Generated from IDL definition of alias "table_abonne"
 *	@author JacORB IDL compiler 
 */

public final class table_abonneHelper
{
	private static org.omg.CORBA.TypeCode _type = null;

	public static void insert (org.omg.CORBA.Any any, tpcorba.exo4.abonne[] s)
	{
		any.type (type ());
		write (any.create_output_stream (), s);
	}

	public static tpcorba.exo4.abonne[] extract (final org.omg.CORBA.Any any)
	{
		return read (any.create_input_stream ());
	}

	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			_type = org.omg.CORBA.ORB.init().create_alias_tc(tpcorba.exo4.table_abonneHelper.id(), "table_abonne",org.omg.CORBA.ORB.init().create_sequence_tc(0, org.omg.CORBA.ORB.init().create_interface_tc("IDL:tpcorba/exo4/abonne:1.0", "abonne")));
		}
		return _type;
	}

	public static String id()
	{
		return "IDL:tpcorba/exo4/table_abonne:1.0";
	}
	public static tpcorba.exo4.abonne[] read (final org.omg.CORBA.portable.InputStream _in)
	{
		tpcorba.exo4.abonne[] _result;
		int _l_result0 = _in.read_long();
		_result = new tpcorba.exo4.abonne[_l_result0];
		for (int i=0;i<_result.length;i++)
		{
			_result[i]=tpcorba.exo4.abonneHelper.read(_in);
		}

		return _result;
	}

	public static void write (final org.omg.CORBA.portable.OutputStream _out, tpcorba.exo4.abonne[] _s)
	{
		
		_out.write_long(_s.length);
		for (int i=0; i<_s.length;i++)
		{
			tpcorba.exo4.abonneHelper.write(_out,_s[i]);
		}

	}
}
