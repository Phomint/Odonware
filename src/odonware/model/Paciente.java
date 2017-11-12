package odonware.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe para gerar objetos do tipo Paciente
 * @author Patrick Amaral
 * @sinse Classe criada em 01/06/2017
 */
@Entity
@Table(name = "tbl_paciente")
public class Paciente implements Serializable {
     @Id
     @GeneratedValue
     @Column(name = "pac_codigo")
     private int codigo;
     @Column(name = "pac_nome", length = 150, nullable = false)
     private String nome;
     @Column(name = "pac_nascimento", nullable = false, length = 10)
     private String nascimento;
     @Column(name = "pac_cpf", nullable = false, length = 14)
     private String cpf;
     @Column(name = "pac_rg", nullable = false, length = 12)
     private String rg;
     @Column(name = "pac_telefone", nullable = false, length = 15)
     private String telefone;
     @Column(name = "pac_endereco", nullable = false, length = 150)
     private String endereco;
     @Column(name = "pac_numero", nullable = false, length = 10)
     private int numero;
     @Column(name = "pac_bairro", nullable = false, length = 100)
     private String bairro;
     @Column(name = "pac_cidade", nullable = false, length = 100)
     private String cidade;
     @Column(name = "pac_tipoSanguineo", nullable = true, length = 3)
     private String tipoSanguineo;
     @Column(name = "pac_doecasAlergias", nullable = true, length = 255)
     private String doençasAlergias;
     @Column(name = "pac_observacao", nullable = true, length = 255)
     private String observacao;

    //CONSTRUTOR DEFAULT
    public Paciente() {
    }//fim do construtor
    
    //CONSTRUTO
    public Paciente(String nome, String nascimento, String cpf, String rg, String telefone, String endereco, int numero, String bairro, String cidade, String tipoSanguineo, String doençasAlergias, String observacao) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.tipoSanguineo = tipoSanguineo;
        this.doençasAlergias = doençasAlergias;
        this.observacao = observacao;
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

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getDoençasAlergias() {
        return doençasAlergias;
    }

    public void setDoençasAlergias(String doençasAlergias) {
        this.doençasAlergias = doençasAlergias;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

       @Override
    public String toString() {
        return getNome();
    }
     
}//fim da classe Paciente
