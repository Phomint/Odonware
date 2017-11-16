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
 * Classe para gerar objetos do tipo Orcamento
 * @author Patrick Amaral
 * @sinse Classe criada em 01/06/2017
 */
@Entity
@Table(name="tbl_orcamento" )
public class Orcamento implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "orc_codigo")
    private int codigo;
    @Column(name = "orc_valorun", nullable = false)
    private float valorUnitario;
    
    @ManyToOne
    @JoinColumn(name= "fk_pac_codigo",nullable = false)
    private Paciente paciente;
    
    @ManyToOne
    @JoinColumn(name= "fk_serden_codigo",nullable = false)
    private ServicoDentista servicoDentista;
    
    //CONSTRUTOR DEFAULT
    public Orcamento() {
    }//fim do construtor
    
    //CONSTRUTOR
    public Orcamento(float valorUnitario,Paciente paciente, ServicoDentista servicoDentista) {
        this.valorUnitario = valorUnitario;
        this.paciente = paciente;
        this.servicoDentista = servicoDentista;   
    }//fim do construtor
    
    //SETTER E GETTER

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public ServicoDentista getServicoDentista() {
        return servicoDentista;
    }

    public void setServicoDentista(ServicoDentista servicoDentista) {
        this.servicoDentista = servicoDentista;
    }
    
}//fim da classe Orcamento
