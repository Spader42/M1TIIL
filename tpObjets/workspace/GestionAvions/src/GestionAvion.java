import java.util.ArrayList;

public class GestionAvion {
	ArrayList<Avion> _avionsList;
	
	GestionAvion(){
		_avionsList = new ArrayList<Avion>();
	}
	
	void add(Avion c){
		if(_avionsList.contains(c)){
			return;
		}
		_avionsList.add(c);
	}
	
	void print(){
		java.util.Iterator<Avion> itr = _avionsList.iterator();
		
		while(itr.hasNext()){
			Avion c = itr.next();
			System.out.println("Avion : " + c.getName());
		}
	}
	
	void remove(Client c){
		if(_avionsList.contains(c)){
			_avionsList.remove(c);
		}
	}
	
	boolean hasClient(Client c){
		return _avionsList.contains(c);
	}
	
	int size(){
		return _avionsList.size();
	}
}
