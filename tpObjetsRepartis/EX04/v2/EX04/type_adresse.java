import java.lang.String;
package tpcorba.exo4;

public final class type_adresse implements org.omg.CORBA.portable.IDLEntity {
    public String   rue     = "";
    public String   ville   = "";
    public int      numero;
    public int      code_postal;
    
    type_adresse(String rue, String ville, int numero, int code_postal) {
        this.rue            = rue;
        this.ville          = ville;
        this.numero         = numero;
        this.code_postal    = code_postal;
    }   
}
