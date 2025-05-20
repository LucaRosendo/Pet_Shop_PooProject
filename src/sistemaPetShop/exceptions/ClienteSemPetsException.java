package sistemaPetShop.exceptions;

public class ClienteSemPetsException extends Exception {
    public ClienteSemPetsException(String nomeCliente) {
        super("O cliente '" + nomeCliente + "' não possui pets cadastrados.");
    }
}