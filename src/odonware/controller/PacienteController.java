package odonware.controller;

import odonware.model.Paciente;
import odonware.model.dao.PacienteDAO;


/**
 * Classe para gerar objetos do tipo PacienteController
 * @author Patrick Amaral
 * @sinse Classe criada em 11/06/2017
 */
public class PacienteController {
       public static void salvarPaciente(String nome, String nascimento, String cpf,
               String rg, String telefone, String endereco, int numero, String bairro,
               String cidade, String tipoSanguineo, String doençasAlergias, String observacao){
         
           Paciente paciente = new Paciente(nome, nascimento, cpf, rg, telefone, endereco, numero, bairro, cidade, tipoSanguineo, doençasAlergias, observacao);
           PacienteDAO pDao = new PacienteDAO();
           pDao.createPaciente(paciente);
       }//fim do metodo salvarPaciente
      public static Paciente preencherPaciente(Paciente paciente){
          return paciente;
      }
}//fim da classe PacienteController
