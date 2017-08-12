package odonware.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe para gerar objetos do tipo Usuario
 * @author Patrick Amaral
 * @sinse Classe criada em 31/05/2017
 */
@Entity
@Table(name = "tbl_usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "usr_codigo")
    private int codigo;
    @Column(name = "usr_usuario", nullable = false, length = 50)
    private String usuario;
    @Column(name = "usr_senha", nullable = false, length = 50)
    private String senha;
    
    //CONSTRUTOR DEFAULT
    public Usuario() {
    }//fim do construtor
    
    //CONSTRUTOR
    public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }//fim do construtor

    //SETTER E GETTER

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "codigo=" + codigo + ", usuario=" + usuario + '}';
    }
   
}//fim da classe Usuario
