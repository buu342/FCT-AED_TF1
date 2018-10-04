package User;

public class UserClass implements User{
	private String idUser, email, name, location;
	private int nif, telephone, pickUpps, salary, points;
	public UserClass(String idUser, int nif, String email, int telephone, String name, String location) {
		this.idUser = idUser;
		this.nif = nif;
		this.email = email;
		this.telephone = telephone;
		this.name = name;
		this.location = location;
		pickUpps = 0;
		salary = 0;
		points = 0;
	}
	
	public boolean hasPickUpps() {
		return pickUpps != 0;
	}
	
	public String getIdUser() {
		return idUser;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public int getNif() {
		return nif;
	}

	public String getEmail() {
		return email;
	}

	public int getTelephone() {
		return telephone;
	}

	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int amount) {
		salary += amount;
	}

	public int getPoints() {
		return points;
	}
}
