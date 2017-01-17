
public class Client {
	String 	_name;
	int 	_id;
	
	Client(String name, int id){
		_name = name;
		_id = id;
	}
	
	String getName(){
		return _name;
	}
	
	int getId(){
		return _id;
	}
	
	Voyage book(Trajet t){
		Avion a = new Avion("BobbyAirline", 300);
		return new Voyage(a, t);		
	}
}
