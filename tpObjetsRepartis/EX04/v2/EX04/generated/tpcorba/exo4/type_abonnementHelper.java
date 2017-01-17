package tpcorba.exo4;
/**
 *	Generated from IDL definition of enum "type_abonnement"
 *	@author JacORB IDL compiler 
 */

public final class type_abonnementHelper
{
	private static org.omg.CORBA.TypeCode _type = null;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			_type = org.omg.CORBA.ORB.init().create_enum_tc(tpcorba.exo4.type_abonnementHelper.id(),"type_abonnement",new String[]{"forfait","consommation"});
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final tpcorba.exo4.type_abonnement s)
	{
		any.type(type());
		write( any.create_output_stream(),s);
	}

	public static tpcorba.exo4.type_abonnement extract (final org.omg.CORBA.Any any)
	{
		return read(any.create_input_stream());
	}

	public static String id()
	{
		return "IDL:tpcorba/exo4/type_abonnement:1.0";
	}
	public static type_abonnement read (final org.omg.CORBA.portable.InputStream in)
	{
		return type_abonnement.from_int(in.read_long());
	}

	public static void write (final org.omg.CORBA.portable.OutputStream out, final type_abonnement s)
	{
		out.write_long(s.value());
	}
}
