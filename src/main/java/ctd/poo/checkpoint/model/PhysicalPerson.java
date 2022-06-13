package ctd.poo.checkpoint.model;

public class PhysicalPerson extends User {
    private String cpf;

    /**
     * Contrutor da Classe Cliente
     *
     * @param id           id do Cliente
     * @param name         Nome do Cliente
     * @param cpf           CPF do Cliente
     * @param phone        Telefone do Cliente
     * @param street       Logradouro do Cliente
     * @param postalCod    CEP do Cliente
     * @param numberStreet Número do logadouro do Cliente
     */
    public PhysicalPerson(int id, String name, String cpf, String phone, String street, String postalCod, String numberStreet) {
        super(id, name, phone, street, postalCod, numberStreet);
        setCpf(cpf);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
