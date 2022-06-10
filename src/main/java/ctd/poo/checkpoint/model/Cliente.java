package ctd.poo.checkpoint.model;

import java.util.List;

public class Cliente {
    private int idCliente;
    private String nome;
    private List<Telefone> telefones;
    private List<Endereco> enderecos;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    /**
     * Contrutor da Classe Cliente
     * @param idCliente id do Cliente
     * @param nome Nome do Cliente
     * @param telefones Lista de Telefones do Cliente
     * @param logadouro Endereços Cadastrado
     */
    public Cliente(int idCliente, String nome, List<Telefone> telefones, List<Endereco> logadouro) {
        this.setIdCliente(idCliente);
        this.setNome(nome);
        this.setTelefones(telefones);
        this.setEnderecos(logadouro);
    }

    @Override
    public String toString() {
        return "Cliente { " + System.lineSeparator() +
                "  id = " + getIdCliente() +
                ", Nome = '" + getNome() + '\'' + System.lineSeparator() +
                ", Telefones = " + getTelefones().toString() + System.lineSeparator() +
                ", Enderecos = " + getEnderecos().toString() + '}' + System.lineSeparator();
    }
}
