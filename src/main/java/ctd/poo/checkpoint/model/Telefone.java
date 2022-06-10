package ctd.poo.checkpoint.model;

public class Telefone {
    private String ddd;
    private String numero;


    //modificadores

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }


    /**
     * Contrutor da Classe Telefone
     * @param ddd DDD da operadora
     * @param numero Numero do Telefone
     */
    public Telefone(String ddd, String numero) {
        this.setDdd(ddd);
        this.setNumero(numero);
    }


    @Override
    public String toString() {
        return " (" + this.getDdd() +") " + this.getNumero() ;
    }
}
