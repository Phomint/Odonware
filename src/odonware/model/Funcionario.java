package odonware.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe para gerar objetos do tipo Funcionario
 * @author Patrick Amaral
 * @sinse Classe criada em 05/06/2017
 */
@Entity
@Table(name = "tbl_funcionario")
public class Funcionario implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "fun_codigo")
    private int codigo;
    @Column(name = "fun_nome", nullable = false, length = 150 )
    private String nome;
    @Column(name = "fun_rg", nullable = false, length = 12)
    private String rg;
    @Column(name = "fun_cpf", nullable = false, length = 14)
    private String cpf;
    @Column(name = "fun_endereco", nullable = false, length = 150)
    private String endereco;
    @Column(name = "fun_numeroEndereco", nullable = false, length = 10)
    private int numeroEndereco;
    @Column(name = "fun_bairroEndereco", nullable = false, length = 100)
    private String bairroEndereco;
    @Column(name = "fun_cidade", nullable = false, length = 100)
    private String cidade;
    @Column(name = "fun_telefone", nullable = false, length = 15)
    private String telefone;
    @Column(name = "fun_email", nullable = false, length = 100)
    private String email;
    
    @ManyToOne
    @JoinColumn(name="usr_codigo",nullable = false)
    private Usuario usuario;
    //CONSTRUTOR DEFAULT
    public Funcionario() {
    }//fim do construtor
    
    //CONSTRUTOR 
    public Funcionario(String nome, String rg, String cpf, String endereco, int numeroEndereco, String bairroEndereco, String cidade, String telefone, String email,Usuario usuario) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.endereco = endereco;
        this.numeroEndereco = numeroEndereco;
        this.bairroEndereco = bairroEndereco;
        this.cidade = cidade;
        this.telefone = telefone;
        this.email = email;
        this.usuario = usuario;
    }//fim do construtor

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(int numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getBairroEndereco() {
        return bairroEndereco;
    }

    public void setBairroEndereco(String bairroEndereco) {
        this.bairroEndereco = bairroEndereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    } 

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
}//fim da classe Funcionario
