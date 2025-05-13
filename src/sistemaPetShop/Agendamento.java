package sistemaPetShop;

import sistemaPetShop.exceptions.PetShopException;

public class Agendamento {
	//Cada agendamento está associado a:
	//	Um pet
	//	Um serviço (banho, tosa, consulta)
	//	Uma data e hora
	//	Os pets podem realizar múltiplos agendamentos.
	//private Date dataHora;
    private Pet pet;
    private Servico servico;
    private String data;

    public Agendamento(Pet pet, Servico servico, String data) throws PetShopException {
        if (pet == null || servico == null || data == null || data.isEmpty()) {
            throw new PetShopException();
        }
        this.pet = pet;
        this.servico = servico;
        this.data = data;
    }

    public void realizarAgendamento() {
        System.out.println("Agendamento realizado:");
        System.out.println("Pet: " + pet.getNome() + " (" + pet.getDono().getNome() + ")");
        System.out.println("Serviço: " + servico);
        System.out.println("Data: " + data);
        servico.executarServico(); // delegação
    }
}
