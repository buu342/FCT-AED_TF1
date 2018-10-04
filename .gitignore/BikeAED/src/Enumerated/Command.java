package Enumerated;

public enum Command {
	ADDUSER("AddUser"), REMOVEUSER("RemoveUser"), GETUSERINFO("GetUserInfo"), ADDPARK("AddPark"),
	ADDBIKE("AddBike"), REMOVEBIKE("RemoveBike"), GETPARKINFO("GetParkInfo"), PICKUP("PickUp"),
	PICKDOWN("PickDown"), CHARGEUSER("ChargeUser"), BIKEPICKUPS("BikePickUps"), USERPICKUPS("UserPickUps"),
	PARKEDBIKE("ParkedBike"), LISTDELAYED("ListDelayed"), FAVORITEPARKS("FavoriteParks"), EXIT("XS"),
	UNKNOWN("Unknown Comand");
	private String description;
	private Command(String description) {
		this.description = description;
	}
	/**
	 * returns the description of the command
	 * @return descricao
	 */
	@Override
	public String toString() {
		return description;
	}
}
