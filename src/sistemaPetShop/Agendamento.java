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
        System.out.println("Dono do Pet: " +  pet.getDono().getNome());
        System.out.println("Pet: " + pet.getNome());
        System.out.println("Serviço: " + servico.getNomeServico());
        System.out.println("Data: " + data);
        System.out.println("Preço: R$ " + servico.getPreco());
        servico.executarServico(); // delegação
    }
    
    // Getters se quiser usar depois
    public Pet getPet() {
        return pet;
    }

    public Servico getServico() {
        return servico;
    }

    public String getData() {
        return data;
    }  
}
