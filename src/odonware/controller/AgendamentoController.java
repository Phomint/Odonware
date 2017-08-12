package odonware.controller;

import odonware.model.Agenda;
import odonware.model.dao.AgendaDAO;

/**
 * Classe para gerar objetos do tipo AgendamentoController
 * @author Patrick Amaral
 * @sinse Classe criada em 16/06/2017
 */
public class AgendamentoController {
    public static void salvarAgendamento(String paciente, String data, String hora, String dentista, String tipo){
         
           Agenda agenda = new Agenda(paciente, data, hora, dentista, tipo);
           AgendaDAO aDao = new AgendaDAO();
           aDao.createAgenda(agenda);
       }//fim do metodo salvarPaciente
}//fim da classe AgendamentoController
