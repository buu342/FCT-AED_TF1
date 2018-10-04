package Aplication;

import java.util.Scanner;

import Bike.Bike;
import Park.Park;
import User.User;

public interface Aplication {
	void addUser(String idUser, int nif, String email, int telephone, String name, String location);
	void removeUser(String idUser);
	User getUserInfo(String idUser);
	void addPark(String idPark, String name, String location);
	void addBike(String idBike, String idPark, String matricula);
	void removeBike(String idBike);
	Park getParkInfo(String idPark);
	void pickUp(String idBike, String idUser);
	void pickDown(String idBike, String idPark, int minutos);
	Bike getBike(String idUser);
	void chargeUser(String idUser, int amount);
	void hasBikePickup(String idBike);
}
