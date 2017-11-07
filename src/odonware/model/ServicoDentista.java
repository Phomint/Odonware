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
 * Classe para gerar objetos do tipo ServicoDentista
 * @author Patrick Amaral
 * @sinse Classe criada em 18/06/2017
 */
@Entity
@Table(name = "tbl_servico_dentista")
public class ServicoDentista implements Serializable {
      @Id
      @GeneratedValue
      @Column(name = "ser_den_codigo", nullable = false)
      private int codigo;
      @Column(name = "ser_den_valor", nullable = false)
      private float valor;
 

      @ManyToOne
      @JoinColumn(name = "ser_codigo", nullable = false)
      private Servico servico;
      @ManyToOne
      @JoinColumn(name = "den_codigo", nullable = false)
      private Dentista dentista;

    //CONSTRUTOR DEFAULT
    public ServicoDentista() {
    }//fim do construtor
    //CONSTRUTOR
    public ServicoDentista(float valor, Servico servico, Dentista dentista) {
        this.valor = valor;
        this.servico = servico;
        this.dentista = dentista;
    }//fim do construtor
    
    //SETTER E GETTER
      
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Dentista getDentista() {
        return dentista;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }
      
      
}//fim da classe ServicoDentista
