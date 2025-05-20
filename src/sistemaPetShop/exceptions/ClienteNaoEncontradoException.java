package sistemaPetShop.exceptions;

public class ClienteNaoEncontradoException extends Exception {
	
    public ClienteNaoEncontradoException(String cpf) {
        super("Cliente com CPF " + cpf + " não encontrado.");
    }
}
