package odonware.model;

/**
 * Classe para gerar objetos do tipo Responsavel
 * @author Patrick Amaral
 * @sinse Classe criada em 01/06/2017
 */
public class Responsavel extends Paciente{
      private String nomeResponsavel;      
    //SETTER E GETTER

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }
}//fim da classe Responsavel
