
public class BDDAvion {
	GestionAvion 		_avions;
	int 				_currId;
	
	BDDAvion(){
		_avions 	= new GestionAvion();
		_currId		= 0;
	}
	
	BDDAvion(GestionAvion c){
		_avions	= c;
	}
	
	Avion createAvion(String name){
		Avion c = new Avion(name, 300);
		_avions.add(c);
		return c;
	}
}
