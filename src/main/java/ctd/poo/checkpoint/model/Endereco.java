package ctd.poo.checkpoint.model;

public class Endereco {
    private String logadouro;
    private String cep;
    private Integer numero;


    public String getLogadouro() {
        return logadouro;
    }

    public void setLogadouro(String logadouro) {
        this.logadouro = logadouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /*
     * Construtor da classe Endereço
     * @param logadouro Endereço do cliente
     * @param cep       CEP do cliente
     * @param numero    Número do logadouro
     */
    public Endereco(String logadouro, String cep, Integer numero) {
        this.setLogadouro(logadouro);
        this.setCep(cep);
        this.setNumero(numero);
    }

    @Override
    public String toString() {
        return "Endereco [ " + System.lineSeparator() +
                "Logadouro = " + this.getLogadouro() +
                ", CEP = " + this.getCep() +
                ", numero = " + this.getNumero() + "]" + System.lineSeparator();
    }

}
