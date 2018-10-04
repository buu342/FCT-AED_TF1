package Park;

import Bike.Bike;
import Bike.BikeClass;

public class ParkClass implements Park{
	private String idPark, name, location;
	private Bike[] bikes;
	private int counter;
	public ParkClass(String idPark, String name, String location) {
		this.idPark = idPark;
		this.name = name;
		this.location = location;
		bikes = new BikeClass[1];
		counter = 0;
	}

	public String getIdPark() {
		return idPark;
	}

	public String getName() {
		return name;
	}
	
	public String getLocation() {
		return location;
	}
	
	public int getNumBikes() {
		return counter;
	}
}
