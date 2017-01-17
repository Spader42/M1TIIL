
public class BDDClient {
	GestionClient 		_clients;
	int 				_currId;
	
	BDDClient(){
		_clients 	= new GestionClient();
		_currId		= 0;
	}
	
	BDDClient(GestionClient c){
		_clients	= c;
	}
	
	Client createClient(String name){
		Client c = new Client(name, _currId++);
		_clients.add(c);
		return c;
	}
}
