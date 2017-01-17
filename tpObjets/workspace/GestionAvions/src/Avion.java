
public class Avion {
	String _name;
	int _max;	
	GestionClient _clients;
	
	Avion(String name, int max){
		_name = name;
		_max = max;
		_clients = new GestionClient();
	}
	
	void addClient(Client c){
		if(_clients.size() < _max)
			_clients.add(c);
	}
	
	void removeClient(Client c){
		_clients.remove(c);
	}
	
	void printClient(){
		_clients.print();
	}
	
	String getName(){
		return _name;
	}
}
