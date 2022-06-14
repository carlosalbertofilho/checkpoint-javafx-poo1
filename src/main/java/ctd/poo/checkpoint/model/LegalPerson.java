package ctd.poo.checkpoint.model;

public class LegalPerson extends User{
    private String cnpj;

    /**
     * Contrutor da LegalPerson
     *
     * @param id           id da Empresa
     * @param name         Nome da Empresa
     * @param cnpj         CNPJ da Empresa
     * @param phone        Telefone da Empresa
     * @param street       Logradouro da Empresa
     * @param postalCod    CEP da Empresa
     * @param numberStreet Número do logadouro da Empresa
     */
    public LegalPerson(int id,
                       String name,
                       String cnpj,
                       String phone,
                       String street,
                       String postalCod,
                       String numberStreet) {
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
