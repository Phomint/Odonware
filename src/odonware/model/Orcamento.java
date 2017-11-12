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
    @Column(name = "orc_quantparc", nullable = true)
    private int quantidadeParcelas;
    @Column(name = "orc_valorparc", nullable = false)
    private float valorParcelas;
    
    @ManyToOne
    @JoinColumn(name= "fk_pac_codigo",nullable = false)
    private Paciente paciente;
    
    @ManyToOne
    @JoinColumn(name= "fk_ser_codigo",nullable = false)
    private Servico servico;
    
    //CONSTRUTOR DEFAULT
    public Orcamento() {
    }//fim do construtor
    
    //CONSTRUTOR
    public Orcamento(int codigo, float valorUnitario, int quantidadeParcelas, float valorParcelas, Paciente paciente, Servico servico) {
        this.codigo = codigo;
        this.valorUnitario = valorUnitario;
        this.quantidadeParcelas = quantidadeParcelas;
        this.valorParcelas = valorParcelas;
        this.paciente = paciente;
        this.servico = servico;   
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

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public float getValorParcelas() {
        return valorParcelas;
    }

    public void setValorParcelas(float valorParcelas) {
        this.valorParcelas = valorParcelas;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }
    
}//fim da classe Orcamento
