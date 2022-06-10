package ctd.poo.checkpoint.model;

import java.util.List;

public class PessoaJuridica extends Cliente{
    private String cnpj;
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * Contrutor da Classe Cliente
     *
     * @param idCliente id da Empresa
     * @param nome      Nome da Empresa
     * @param cnpj      CNPJ da Empresa
     * @param telefones Lista de Telefones da Empresa
     * @param logadouro Endereços Cadastrado
     */
    public PessoaJuridica(int idCliente, String nome, String cnpj, List<Telefone> telefones, List<Endereco> logadouro) {
        super(idCliente, nome, telefones, logadouro);
        this.setCnpj(cnpj);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + getIdCliente() +
                ", Nome = '" + getNome() + '\'' +
                ", CNPJ = " + getCnpj() +
                ", Telefones = " + getTelefones().toString() +
                ", Enderecos = " + getEnderecos().toString() +
                '}';
    }
}
