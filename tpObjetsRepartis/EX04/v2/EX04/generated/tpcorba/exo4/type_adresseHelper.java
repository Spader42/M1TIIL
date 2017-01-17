package tpcorba.exo4;


/**
 *	Generated from IDL definition of struct "type_adresse"
 *	@author JacORB IDL compiler 
 */

public final class type_adresseHelper
{
	private static org.omg.CORBA.TypeCode _type = null;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			_type = org.omg.CORBA.ORB.init().create_struct_tc(tpcorba.exo4.type_adresseHelper.id(),"type_adresse",new org.omg.CORBA.StructMember[]{new org.omg.CORBA.StructMember("numero", org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.from_int(3)), null),new org.omg.CORBA.StructMember("rue", org.omg.CORBA.ORB.init().create_string_tc(0), null),new org.omg.CORBA.StructMember("code_postal", org.omg.CORBA.ORB.init().get_primitive_tc(org.omg.CORBA.TCKind.from_int(3)), null),new org.omg.CORBA.StructMember("ville", org.omg.CORBA.ORB.init().create_string_tc(0), null)});
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final tpcorba.exo4.type_adresse s)
	{
		any.type(type());
		write( any.create_output_stream(),s);
	}

	public static tpcorba.exo4.type_adresse extract (final org.omg.CORBA.Any any)
	{
		return read(any.create_input_stream());
	}

	public static String id()
	{
		return "IDL:tpcorba/exo4/type_adresse:1.0";
	}
	public static tpcorba.exo4.type_adresse read (final org.omg.CORBA.portable.InputStream in)
	{
		tpcorba.exo4.type_adresse result = new tpcorba.exo4.type_adresse();
		result.numero=in.read_long();
		result.rue=in.read_string();
		result.code_postal=in.read_long();
		result.ville=in.read_string();
		return result;
	}
	public static void write (final org.omg.CORBA.portable.OutputStream out, final tpcorba.exo4.type_adresse s)
	{
		out.write_long(s.numero);
		out.write_string(s.rue);
		out.write_long(s.code_postal);
		out.write_string(s.ville);
	}
}
