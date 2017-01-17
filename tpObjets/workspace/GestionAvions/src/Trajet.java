import java.sql.Date;


public class Trajet {
	Date _departureTime;
	Date _arrivalTime;
	
	private Airport _departureAirport;
	private Airport _arrivalAirport;
	
	Trajet(Date dT, Date aT, Airport dA, Airport aA){
		_departureTime 		= dT;
		_arrivalTime 		= aT;
		_departureAirport 	= dA;
		_arrivalAirport 	= aA;
	}

	public Airport getDepartureAirport() {
		return _departureAirport;
	}

	public void setDepartureAirport(Airport _departureAirport) {
		this._departureAirport = _departureAirport;
	}

	public Airport getArrivalAirport() {
		return _arrivalAirport;
	}

	public void setArrivalAirport(Airport _arrivalAirport) {
		this._arrivalAirport = _arrivalAirport;
	}
	
}
