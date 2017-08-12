package odonware.controller;

import odonware.model.Dentista;
import odonware.model.Servico;
import odonware.model.ServicoDentista;
import odonware.model.dao.ServicoDAO;
import odonware.model.dao.ServicoDentistaDAO;


/**
 * Classe para gerar objetos do tipo ServicoController
 * @author Patrick Amaral
 * @sinse Classe criada em 21/06/2017
 */
public class ServicoController {
       public static void salvarServico(String nome){
           Servico servico = new Servico(nome);
           ServicoDAO sDao = new ServicoDAO();
           sDao.createServico(servico);
       }//fim do salvarServico
       public static void salvarServicoDentista(float valor, float percentual, Servico servico, Dentista dentista){
           ServicoDentista serden = new ServicoDentista(valor, percentual, servico, dentista);
           ServicoDentistaDAO sdDao = new ServicoDentistaDAO();
           sdDao.createServicoDentista(serden);
       }
}//fim da classe ServicoController
