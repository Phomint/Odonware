package odonware.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe para gerar objetos do tipo Servico
 * @author Patrick Amaral
 * @sinse Classe criada em 01/06/2017
 */
@Entity
@Table(name = "tbl_servico")
public class Servico implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "ser_codigo", nullable = false)
    private int codigo;
    @Column(name = "ser_nome", nullable = false, length = 100)
    private String nome;
    
    //CONSTRUTOR DEFAULT    
    public Servico() {
    }//fim do construtor
    
    //CONSTRUTOR
    public Servico(String nome) {
        this.nome = nome;
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

      @Override
    public String toString() {
        return getNome();
    }
    
}//fim da classe Servico
