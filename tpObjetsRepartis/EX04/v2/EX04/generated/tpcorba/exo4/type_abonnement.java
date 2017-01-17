package tpcorba.exo4;
/**
 *	Generated from IDL definition of enum "type_abonnement"
 *	@author JacORB IDL compiler 
 */

public final class type_abonnement
	implements org.omg.CORBA.portable.IDLEntity
{
	private int value = -1;
	public static final int _forfait = 0;
	public static final type_abonnement forfait = new type_abonnement(_forfait);
	public static final int _consommation = 1;
	public static final type_abonnement consommation = new type_abonnement(_consommation);
	public int value()
	{
		return value;
	}
	public static type_abonnement from_int(int value)
	{
		switch (value) {
			case _forfait: return forfait;
			case _consommation: return consommation;
			default: throw new org.omg.CORBA.BAD_PARAM();
		}
	}
	protected type_abonnement(int i)
	{
		value = i;
	}
	java.lang.Object readResolve()
	throws java.io.ObjectStreamException
	{
		return from_int(value());
	}
}
