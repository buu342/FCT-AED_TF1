package Aplication;

import Bike.Bike;
import Bike.BikeClass;
import Exceptions.BikeInMovementException;
import Exceptions.BikeStoppedException;
import Exceptions.BikeUtilizedSystemException;
import Exceptions.ExistentBikeException;
import Exceptions.ExistentParkException;
import Exceptions.ExistentUserException;
import Exceptions.InexistentBikeException;
import Exceptions.InexistentParkException;
import Exceptions.InexistentUserException;
import Exceptions.InsufiencientSalaryException;
import Exceptions.InvalidDataException;
import Exceptions.UserUtilizedSystemException;
import Park.Park;
import Park.ParkClass;
import User.User;
import User.UserClass;
import DataEstructures.Queue;

public class AplicationClass implements Aplication{
	public static final int BIKE_COST = 5;
	private User user;
	private Park park;
	private Bike bike;
	private Queue<Bike> bikePickupList;
	
	public AplicationClass() {
		user = null;
		park = null;
		bike = null;
	}

	public void addUser(String idUser, int nif, String email, int telephone, String name, String location) {
		if(hasUser(idUser))
			throw new ExistentUserException();
		user = new UserClass(idUser, nif, email, telephone, name, location);
	}

	public void removeUser(String idUser) {
		if(!hasUser(idUser))
			throw new InexistentUserException();
		else if(user.hasPickUpps())
			throw new UserUtilizedSystemException();
		user = null;
	}
	
	public Bike getBike(String idBike) {
		return bike;
	}
	
	private boolean hasUser(String idUser) {
		if(user != null)
			return user.getIdUser().equals(idUser);
		return false;
	}
	
	private boolean hasPark(String idPark) {
		if(park != null)
			return park.getIdPark().equals(idPark);
		return false;
	}
	
	private boolean hasBike(String idBike) {
		if(bike != null)
			return bike.getIdBike().equals(idBike);
		return false;
	}

	public User getUserInfo(String idUser) {
		if(!hasUser(idUser))
			throw new InexistentUserException();
		return user;
	}
	
	public void addPark(String idPark, String name, String location) {
		if(hasPark(idPark))
			throw new ExistentParkException();
		park = new ParkClass(idPark, name, location);
	}

	public void addBike(String idBike, String idPark, String matricula) {
		if(hasBike(idBike))
			throw new ExistentBikeException();
		else if(!hasPark(idPark))
			throw new InexistentParkException();
		bike = new BikeClass(idBike, idPark, matricula);
	}

	public void removeBike(String idBike) {
		if(!hasBike(idBike))
			throw new InexistentBikeException();
		else if(bike.isPickedUpp())
			throw new BikeUtilizedSystemException();
		bike = null;
	}

	public Park getParkInfo(String idPark) {
		return park;
	}
	
	public void pickUp(String idBike, String idUser) {
		if(!hasBike(idBike))
			throw new InexistentBikeException();
		else if(bike.isPickedUpp())
			throw new BikeInMovementException();
		else if(!hasUser(idUser))
			throw new InexistentUserException();
		else if(user.getSalary() < 5)
			throw new InsufiencientSalaryException();
		bike.setPickUpp(user);
		user.setSalary(-5);
	}

	public void pickDown(String idBike, String idPark, int minutos) {
		if(!hasBike(idBike))
			throw new InexistentBikeException();
		else if(!bike.isPickedUpp())
			throw new BikeStoppedException();
		else if(!hasPark(idPark))
			throw new InexistentParkException();
		else if(minutos <= 0)
			throw new InvalidDataException();
		bike.setPickUpp(null);
	}

	public void chargeUser(String idUser, int amount) {
		user.setSalary(amount);
	}
		
	public void hasBikePickup(String idBike)
	{
	    if (!hasBike(idBike))
	        throw new InexistentBikeException();
	}
}
