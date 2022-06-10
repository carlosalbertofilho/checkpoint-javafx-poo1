package ctd.poo.checkpoint.model;

import java.time.LocalDate;
import java.util.List;

public class Pedido {
    private Integer idPedido;
    private LocalDate data;
    private List<Endereco> enderecoEntrega;
    private List<Item> itens;
    private final Cliente cliente;
    public Integer getIdPedido() {
        return idPedido;
    }
    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public List<Endereco> getEnderecoEntrega() {
        return enderecoEntrega;
    }
    public void setEnderecoEntrega(List<Endereco> enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }
    public List<Item> getItens() {
        return itens;
    }
    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Construtor da Classe Pedido
     *
     * @param idPedido id do Pedido
     * @param cliente  Cliente que fez o pedido
     * @param data     Data do Pedido
     * @param itens    Items do pedido
     */
    public Pedido(Integer idPedido, PessoaFisica cliente, LocalDate data, List<Item> itens) {
        this.cliente = cliente;
        this.setIdPedido(idPedido);
        this.setData(data);
        this.setEnderecoEntrega(cliente.getEnderecos());
        this.setItens(itens);
    }


    @Override
    public String toString() {
        return "Pedido numero " + getIdPedido() +
                ", Realizado em " + getData() +
                ", pelo Cliente " + cliente.getNome() +
                ", Endereço de Entrega " + getEnderecoEntrega().toString() +
                ", itens=" + getItens().toString();
    }
}
