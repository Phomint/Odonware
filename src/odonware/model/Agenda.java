package odonware.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe para gerar objetos do tipo Agenda
 * @author Patrick Amaral
 * @sinse Classe criada em 01/06/2017
 */
@Entity
@Table(name = "tbl_agenda")
public class Agenda implements Serializable {
     @Id
     @GeneratedValue
     @Column(name = "age_codigo", unique = true)
     private int codigo;
     @Column(name = "age_paciente", nullable = false, length = 150)
     private String paciente;
     @Column(name = "age_data", nullable = false, length = 12)
     private String data;
     @Column(name = "age_hora", nullable = false, length = 10)
     private String hora;
     @Column(name = "age_dentista", nullable = false, length = 150)
     private String dentista;
     @Column(name = "age_tipo", nullable = false, length = 10)
     private String tipo;
     @Column(name = "age_status", nullable = false, length = 50)
     private String status;
    
    //CONSTRUTOR DEFAULT
    public Agenda() {
    }//fim do construtor
     
    //CONSTRUTOR
    public Agenda(String paciente, String data, String hora, String dentista, String tipo) {
        this.paciente = paciente;
        this.data = data;
        this.hora = hora;
        this.dentista = dentista;
        this.tipo = tipo;
        this.status = "agendado";
    }//fim do construtor

    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDentista() {
        return dentista;
    }

    public void setDentista(String dentista) {
        this.dentista = dentista;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
     
}//fim da classe Agenda
