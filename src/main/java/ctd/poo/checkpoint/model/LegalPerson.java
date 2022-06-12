package ctd.poo.checkpoint.model;

public class LegalPerson extends User{
    private String cnpj;

    /**
     * Contrutor da Classe Cliente
     *
     * @param id           id do Cliente
     * @param name         Nome do Cliente
     * @param phone        Telefone do Cliente
     * @param street       Logradouro do Cliente
     * @param postalCod    CEP do Cliente
     * @param numberStreet Número do logadouro do Cliente
     */
    public LegalPerson(int id, String name, String cnpj, String phone, String street, String postalCod, String numberStreet) {
        super(id, name, phone, street, postalCod, numberStreet);
        setCnpj(cnpj);
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
