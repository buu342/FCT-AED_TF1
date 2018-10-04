import java.util.Scanner;

import Aplication.Aplication;
import Aplication.AplicationClass;
import Enumerated.Command;
import Enumerated.Messages;
import Exceptions.ExistentUserException;
import Exceptions.InexistentBikeException;
import Exceptions.InexistentParkException;
import Exceptions.BikeInMovementException;
import Exceptions.BikeStoppedException;
import Exceptions.BikeUtilizedSystemException;
import Exceptions.ExistentBikeException;
import Exceptions.ExistentParkException;
import Exceptions.InexistentUserException;
import Exceptions.InsufiencientSalaryException;
import Exceptions.InvalidDataException;
import Exceptions.UserUtilizedSystemException;
import Park.Park;
import User.User;

public class Main {
	/**
     * returns the command of the user
     * @param input
     * @return command
     */
    private static Command getCommand(Scanner input) {
    	try {
    		String comm = input.next().toUpperCase();
    		return Command.valueOf(comm);
    	}catch (IllegalArgumentException e){
    	return Command.UNKNOWN;
    	}
    }
    
    private static void addUser(Aplication apl, Scanner in) {
    	String idUser = in.next();
    	int nif = in.nextInt();
    	String email = in.next();
    	int telephone = in.nextInt();
    	String name = in.next();
    	in.nextLine();
    	String location = in.nextLine();
    	try {
    	apl.addUser(idUser, nif, email, telephone, name, location);
    	System.out.println(Messages.USER_INSERTED);
    	}catch(ExistentUserException e) {
    		System.out.println(Messages.EXISTENT_USER);
    	}
    }
    
    private static void removeUser(Aplication apl, Scanner in) {
    	String idUser = in.next();
    	try {
    		apl.removeUser(idUser);
    		System.out.println(Messages.USER_REMOVIDO);
    	}catch(InexistentUserException e) {
    		System.out.println(Messages.INEXISTENT_USER);
    	}catch(UserUtilizedSystemException e) {
    		System.out.println(Messages.USER_UTILIZED_SYSTEM);
    	}
    }
    
    private static void getUserInfo(Aplication apl, Scanner in) {
    	String idUser = in.next();
    	User user;
    	try {
    		user = apl.getUserInfo(idUser);
    		System.out.println(user.getName() +": " + user.getNif() + ", " + user.getLocation() + ", " + user.getEmail() + ", " + user.getTelephone() + ", " + user.getSalary() + ", " + user.getPoints());
    	}catch(InexistentUserException e) {
    		System.out.println(Messages.INEXISTENT_USER);
    	}
    }
    
    private static void addPark(Aplication apl, Scanner in) {
    	String idPark = in.next();
    	String name = in.next();
    	in.nextLine();
    	String location = in.nextLine();
    	try {
    		apl.addPark(idPark, name, location);
    		System.out.println(Messages.PARK_ADDED);
    	}catch(ExistentParkException e) {
    		System.out.println(Messages.EXISTENT_PARK);
    	}
    }
    
    public static void addBike(Aplication apl, Scanner in) {
    	String idBike = in.next();
    	String idPark = in.next();
    	String matricula = in.next();
    	try {
    		apl.addBike(idBike, idPark, matricula);
    	}catch(ExistentBikeException e) {
    		System.out.println(Messages.EXISTENT_BIKE);
    	}catch(InexistentParkException e) {
    		System.out.println(Messages.INEXISTENT_PARK);
    	}
    }
    
    private static void removeBike(Aplication apl, Scanner in) {
    	String idBike = in.next();
    	try {
    		apl.removeBike(idBike);
    	}catch(InexistentBikeException e) {
    		System.out.println(Messages.INEXISTENT_BIKE);
    	}catch(BikeUtilizedSystemException e) {
    		System.out.println(Messages.BIKE_UTILIZED_SYSTEM);
    	}
	}
    
    private static void getParkInfo(Aplication apl, Scanner in) {
    	String idPark = in.next();
    	Park park;
    	try {
    		park = apl.getParkInfo(idPark);
    		System.out.println(park.getName() + ": " + park.getLocation() + ", " + park.getNumBikes());
    	}catch(InexistentParkException e) {
    		System.out.println(Messages.INEXISTENT_PARK);
    	}
    }
    
    private static void pickUp(Aplication apl, Scanner in) {
    	String idBike = in.next();
    	String idUser = in.next();
    	try {
    		apl.pickUp(idBike, idUser);
    		System.out.println(Messages.PICK_UPP_SUCESS);
    	}catch(InexistentBikeException e) {
    		System.out.println(Messages.INEXISTENT_BIKE);
    	}catch(BikeInMovementException e) {
    		System.out.println(Messages.BIKE_MOVEMENT);
    	}catch(InexistentUserException e) {
    		System.out.println(Messages.INEXISTENT_USER);
    	}catch(InsufiencientSalaryException e) {
    		System.out.println(Messages.INSUFICIENT_SALARY);
    	}
    }
    
    private static void pickDown(Aplication apl, Scanner in) {
    	String idBike = in.next();
    	String idPark = in.next();
    	int minutos = in.nextInt();
    	try {
    		apl.pickDown(idBike, idPark, minutos);
    		User user = apl.getBike(idBike).getUser();
    		System.out.print(Messages.PICK_DOWN_SUCCESS);
    		System.out.println(user.getSalary() + " euros, " + user.getPoints() + " pontos.");
    	}catch(InexistentBikeException e) {
    		System.out.println(Messages.INEXISTENT_BIKE);
    	}catch(BikeStoppedException e) {
    		System.out.println(Messages.BIKE_STOPPED);
    	}catch(InexistentParkException e) {
    		System.out.println(Messages.INEXISTENT_PARK);
    	}catch(InvalidDataException e) {
    		System.out.println(Messages.INVALID_DATA);
    	}
    }
    
    private static void chargeUser(Aplication apl, Scanner in) {
    	String idUser = in.next();
    	int amount = in.nextInt();
    	try {
    		apl.chargeUser(idUser, amount);
    		System.out.println("Saldo: " + apl.getUserInfo(idUser).getSalary() + "euros");
    	}catch(InexistentUserException e) {
    		System.out.println(Messages.INEXISTENT_USER);
    	}catch(InvalidDataException e) {
    		System.out.println(Messages.INVALID_CHARGE);
    	}
    }
    //queue
    private static void bikePickUps(Aplication apl, Scanner in) {
    	String idBike = in.next();
    	try {
    	    apl.hasBikePickup(idBike);
    	} catch(InexistentBikeException e){
    	    System.out.println(Messages.INEXISTENT_BIKE);
    	}
    }
    
	public static void main(String args[]) {
		Aplication apl = new AplicationClass();
		Scanner in = new Scanner(System.in);
		Command com = getCommand(in);
		do {
			switch(com) {
			case ADDUSER:
				addUser(apl, in);
				break;
			case REMOVEUSER:
				removeUser(apl, in);
				break;
			case GETUSERINFO:
				getUserInfo(apl, in);
				break;
			case ADDPARK:
				addPark(apl, in);
				break;
			case ADDBIKE:
				addBike(apl, in);
				break;
			case REMOVEBIKE:
				removeBike(apl, in);
				break;
			case GETPARKINFO:
				getParkInfo(apl, in);
				break;
			case PICKUP:
				pickUp(apl, in);
				break;
			case PICKDOWN:
				pickDown(apl, in);
				break;
			case CHARGEUSER:
				chargeUser(apl, in);
				break;
			case BIKEPICKUPS:
				bikePickUps(apl, in);
				break;
			default:
				break;
			}
		com = getCommand(in);
		}while(!com.equals(Command.EXIT));
	}
}
