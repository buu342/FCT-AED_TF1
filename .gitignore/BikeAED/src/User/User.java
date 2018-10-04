package User;

public interface User {
	boolean hasPickUpps();
	String getIdUser();
	String getName();
	String getLocation();
	int getNif();
	String getEmail();
	int getTelephone();
	int getSalary();
	int getPoints();
	void setSalary(int amount);
}
