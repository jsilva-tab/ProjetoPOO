package br.com.clinicaxuliapoo.dal;
import java.util.Date;

public class Cliente{
    private String cpf;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String endereco;
    private Date data_nasc;

    public Cliente(String cpf, String nome, String email, String senha, String telefone, String endereco, Date data_nasc) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.endereco = endereco;
        this.data_nasc = data_nasc;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }
    
}
