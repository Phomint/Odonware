package odonware.controller;

import odonware.model.Consultorio;
import odonware.model.dao.ConsultorioDAO;

/**
 * Classe para gerar objetos do tipo ConsultorioController
 * @author Patrick Amaral
 * @sinse Classe criada em 09/06/2017
 */
public class ConsultorioController {
   public static void salvarConsultorio(String nomeFantasia, String razaoSocial, long cnpj,
           int inscricaoEstadual, String endereco, int numero, String bairro, String cidade, String telefone, String email){
         
          
          Consultorio consultorio = new Consultorio(nomeFantasia, razaoSocial, cnpj, inscricaoEstadual, endereco, numero, bairro, cidade, telefone, cidade);
          ConsultorioDAO cDao = new ConsultorioDAO();
          cDao.createConsultorio(consultorio);
          
      }//fim do metodo salvarUsuario
}//fim da classe ConsultorioController
