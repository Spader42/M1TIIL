import java.util.ArrayList;

public class GestionClient {
	ArrayList<Client> _clientList;
	
	GestionClient(){
		_clientList = new ArrayList<Client>();
	}
	
	void add(Client c){
		if(_clientList.contains(c)){
			return;
		}
		_clientList.add(c);
	}
	
	void print(){
		java.util.Iterator<Client> itr = _clientList.iterator();
		
		while(itr.hasNext()){
			Client c = itr.next();
			System.out.println("n° :" + c.getId() + " - Mr / Mme : " + c.getName());
		}
	}
	
	void remove(Client c){
		if(_clientList.contains(c)){
			_clientList.remove(c);
		}
	}
	
	boolean hasClient(Client c){
		return _clientList.contains(c);
	}
	
	int size(){
		return _clientList.size();
	}
}
