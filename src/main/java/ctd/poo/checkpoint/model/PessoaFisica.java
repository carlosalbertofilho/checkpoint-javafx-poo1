package ctd.poo.checkpoint.model;

import java.util.List;

public class PessoaFisica extends Cliente{
    private String cpf;
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Contrutor da Classe Cliente
     *
     * @param idCliente id do Cliente
     * @param nome      Nome do Cliente
     * @param cpf       CPF do Cliente
     * @param telefones Lista de Telefones do Cliente
     * @param logadouro Endereços Cadastrado
     */
    public PessoaFisica(int idCliente, String nome, String cpf, List<Telefone> telefones, List<Endereco> logadouro) {
        super(idCliente, nome, telefones, logadouro);
        this.setCpf(cpf);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + getIdCliente() +
                ", Nome = '" + getNome() + '\'' +
                ", CPF = " + getCpf() +
                ", Telefones = " + getTelefones().toString() +
                ", Enderecos = " + getEnderecos().toString() +
                '}';
    }
}