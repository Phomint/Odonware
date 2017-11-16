package odonware.controller;

import odonware.model.Orcamento;
import odonware.model.Paciente;
import odonware.model.ServicoDentista;
import odonware.model.dao.OrcamentoDAO;

/**
 *
 * @author Patrick Amaral
 */
public class OrcamentoController {
    public static void salvarOrcamento( float valorUnitario, Paciente paciente, ServicoDentista servicoDentista){
        
        Orcamento orcamento = new Orcamento(valorUnitario, paciente, servicoDentista);
        OrcamentoDAO oDao = new OrcamentoDAO();
        oDao.createOrcamento(orcamento);
    }//metodo salvarOrcamento
}//fim da classe OrcamentoController
