package Bike;

import User.User;

public interface Bike {
	String getIdBike();
	String getIdPark();
	String getMatricula();
	boolean isPickedUpp();
	void setPickUpp(User user);
	User getUser();
}
