package sistemaPetShop.exceptions;

public class PetShopException extends Exception {
	
    public PetShopException() {
        super("Erro ao criar agendamento: Dados inválidos.");
    }
}
