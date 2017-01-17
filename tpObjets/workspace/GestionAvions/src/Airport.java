import java.util.ArrayList;


public class Airport {
	String _name;
	ArrayList<Avion> _avionsPresent;
	
	Airport(String n){
		_name = n;
		_avionsPresent = new ArrayList<Avion>();
	}
	
	String getName(){
		return _name;
	}
}
