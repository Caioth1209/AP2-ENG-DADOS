package teste.model;

import java.util.Date;

public class Usuario {
    private String cpf;
    private String nome;
    private Date dataNascimento;
    private int numeroCartao;

    public Usuario() {
    }

    public Usuario(String cpf, String nome, Date dataNascimento, int numeroCartao) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.numeroCartao = numeroCartao;
    }

    public Usuario(String nome, Date dataNascimento, int numeroCartao) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.numeroCartao = numeroCartao;
    }
    
    public Usuario(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public int getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(int numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
