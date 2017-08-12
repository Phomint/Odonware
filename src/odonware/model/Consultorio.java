package odonware.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe para gerar objetos do tipo Consultorio
 * @author Patrick Amaral
 * @sinse Classe criada em 01/06/2017
 */
@Entity
@Table(name = "tbl_consultorio")
public class Consultorio implements Serializable {
     @Id
     @GeneratedValue
     @Column(name = "cons_codigo")
     private int codigo;
     @Column(name = "cons_nomeFantasia", nullable = false, length = 100)
     private String nomeFantasia;
     @Column(name = "cons_razaoSocial", nullable = false, length = 120)
     private String razaoSocial;
     @Column(name = "cons_cnpj", nullable = false, length = 14)
     private long cnpj;
     @Column(name = "cons_inscricaoEstadual", nullable = false, length = 20)
     private int inscricaoEstadual;
     @Column(name = "cons_endereco", nullable = false, length = 150)
     private String endereco;
     @Column(name = "cons_numero", nullable = false, length = 10)
     private int numero;
     @Column(name = "cons_bairro", nullable = false, length = 100)
     private String bairro;
     @Column(name = "cons_cidade", nullable = false, length = 20)
     private String cidade;
     @Column(name = "cons_telefone", nullable = false, length = 11)
     private String telefone;
     @Column(name = "cons_email", nullable = false, length = 100)
     private String email;
    
    //CONSTRUTOR DEFAULT 
    public Consultorio() {
    }//fim do construtor
     
     //CONSTRUTOR
    public Consultorio(String nomeFantasia, String razaoSocial, long cnpj, int inscricaoEstadual, String endereco, int numero, String bairro, String cidade, String telefone, String email) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.telefone = telefone;
        this.email = email;
    }//fim do construtor
    
    //SETTER E GETTER
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    public int getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(int inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
     
     
}//fim da classe Consultorio
