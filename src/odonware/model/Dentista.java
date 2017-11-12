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
 * Classe para gerar objetos do tipo Dentista
 * @author Patrick Amaral
 * @sinse Classe criada em 01/06/2017
 */
@Entity
@Table(name = "tbl_dentista")
public class Dentista implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "den_codigo")
    private int codigo;
    @Column(name = "den_nome", nullable = false, length = 150 )
    private String nome;
    @Column(name = "den_rg", nullable = false, length = 12)
    private String rg;
    @Column(name = "den_cpf", nullable = false, length = 14)
    private String cpf;
    @Column(name = "den_endereco", nullable = false, length = 150)
    private String endereco;
    @Column(name = "den_numeroEndereco", nullable = false, length = 10)
    private int numeroEndereco;
    @Column(name = "den_bairroEndereco", nullable = false, length = 100)
    private String bairroEndereco;
    @Column(name = "den_cidade", nullable = false, length = 100)
    private String cidade;
    @Column(name = "den_telefone", nullable = false, length = 15)
    private String telefone;
    @Column(name = "den_email", nullable = false, length = 100)
    private String email;
    @Column(name = "den_cro", nullable = false, length = 20)
    private int cro;
    @Column(name = "den_especialidade", nullable = false, length = 100)
    private String especialidade;
    
    @ManyToOne
    @JoinColumn(name= "fk_usr_codigo",nullable = false)
    private Usuario usuario;
        
    //CONSTRUTOR DEFAULT
    public Dentista() {
    }//fim do construtor
   
     //CONSTRUTOR
    public Dentista( String nome, String rg, String cpf, String endereco, int numeroEndereco, String bairroEndereco, String cidade, String telefone, String email, int cro, String especialidade, Usuario usuario) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.endereco = endereco;
        this.numeroEndereco = numeroEndereco;
        this.bairroEndereco = bairroEndereco;
        this.cidade = cidade;
        this.telefone = telefone;
        this.email = email;
        this.cro = cro;
        this.especialidade = especialidade;
        this.usuario = usuario;
    }//fim do construtor
        
     //SETTER E GETTER

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

    public int getCro() {
        return cro;
    }

    public void setCro(int cro) {
        this.cro = cro;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
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

    @Override
    public String toString() {
        return getNome();
    }
    
    
}//fim da classe Dentista
