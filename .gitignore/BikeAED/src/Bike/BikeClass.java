package Bike;

import DataEstructures.Queue;
import User.User;

public class BikeClass implements Bike{
	private String idBike, idPark, matricula;
	private User user;
	private Queue<Bike> bikePickupList;
	public BikeClass(String idBike, String idPark, String matricula) {
		this.idBike = idBike;
		this.idPark = idPark;
		this.matricula = matricula;
		user = null;
	}
	
	public String getIdBike() {
		return idBike;
	}
	
	public String getIdPark() {
		return idPark;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public boolean isPickedUpp() {
		return user != null;
	}
	
	public void setPickUpp(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
}
