package Enumerated;

public enum Messages {
	USER_INSERTED("Insercao de utilizador com sucesso."), USER_REMOVIDO("Utilizador removido com sucesso."),
	INEXISTENT_USER("Utilizador inexistente."), USER_UTILIZED_SYSTEM("Utilizador ja utilizou o sistema."),
	EXISTENT_USER("Utilizador existente."), EXISTENT_PARK("Parque existente."),
	PARK_ADDED("Parque adicionado com sucesso."), EXISTENT_BIKE("Bicicleta existente."),
	INEXISTENT_PARK("Parque inexistente."), INEXISTENT_BIKE("Bicicleta inexistente."),
	BIKE_UTILIZED_SYSTEM("Bicicleta ja foi utilizada."), BIKE_MOVEMENT("Bicicleta em movimento."),
	INSUFICIENT_SALARY("Quando o saldo atual do utilizador não atinge os 5 euros."),
	BIKE_STOPPED("Quando a bicicleta está estacionada."),
	INVALID_DATA("Duração do pickup é menor ou igual a zero."), PICK_UPP_SUCESS("PickUp com sucesso."),
	PICK_DOWN_SUCCESS("Pickdown com sucesso: "),
	INVALID_CHARGE("Valor de carregamento é menor ou igual a zero.");
	private String description;
	private Messages(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return description;
	}
}
