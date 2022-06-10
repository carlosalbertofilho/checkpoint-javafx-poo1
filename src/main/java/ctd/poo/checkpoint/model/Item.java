package ctd.poo.checkpoint.model;

public class Item {
    private String nome;
    private Integer quantidade;
    private Double preco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    /**
     * Contrutora da Classe Item
     * @param nome No do item
     * @param quantidade quantidade do item em estoque
     * @param preco preço do item
     */
    public Item(String nome, Integer quantidade, Double preco) {
        this.setNome(nome);
        this.setQuantidade(quantidade);
        this.setPreco(preco);
    }

    @Override
    public String toString() {
        return "Item {" +
                "Nome ='" + this.getNome() + '\'' +
                ", Quantidade =" + this.getQuantidade() +
                ", Preco =" + this.getPreco() +
                '}';
    }
}
