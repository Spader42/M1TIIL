package tpcorba.exo4;

public final class type_abonnement implements org.omg.CORBA.portable.IDLEntity {
    private int value = -1;
    
    public static final int             _forfait        = 0;
    public static final type_abonnement forfait         = new type_abonnement(_forfait);
    public static final int             _consommation   = 1;
    public static final type_abonnement consommation    = new type_abonnement(_consommation);
    
    public int value() {
        return value;
    }
    
    public static type_abonnement from_int(int value) {
        switch(value) {
            case 0:
                return forfait;
            break;
            case 1:
                return consommation;   
            break;
            default:
                return null;
            break;
        }
    }
}
