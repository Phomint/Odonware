package odonware.model.dao;

import java.util.ArrayList;
import java.util.List;
import odonware.model.Agenda;
import odonware.model.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

/**
 * Classe para gerar objetos do tipo AgendaDAO
 * @author Patrick Amaral
 * @sinse Classe criada em 16/06/2017
 */
public class AgendaDAO {
 /**
       * Metodo para salvar um objeto agenda no banco
       * @param agenda
       */
      public void createAgenda(Agenda agenda){
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        Transaction transaction = session.beginTransaction();
        session.save(agenda);
        transaction.commit();
        session.close();
      }//fim do metodo createAgenda
      
        /**
         * Metodo para listar agendas em ordem asc
         * @return agendas
         */
       @SuppressWarnings("unchecked")
       public List<Agenda> readAgendaOrdem() {      
        Session sessao = HibernateUtil.getSessionFactory().openSession();
                
        List<Agenda> agendas = new ArrayList<Agenda>();
        sessao.beginTransaction();
        Criteria criterio = sessao.createCriteria(Agenda.class);
        criterio.addOrder(Order.asc("nome"));   
        agendas = criterio.list();
        
        sessao.getTransaction().commit();      
        sessao.close();
        return agendas;
      }//fim do metodo readAgendaOrdem
       
       /**
        * Metodo para atualizar um agenda no banco de dados
        * @param agenda
        */
       public void updateAgenda(Agenda agenda){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = sessao.beginTransaction();
        sessao.update(agenda);
        transaction.commit();
        sessao.close();
    }//fim do metodo updateAgenda
       
       /**
        * Metodo para remover o agenda do banco de dados
        * @parama agenda
        */
       public void deleteAgenda(Agenda agenda){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transactio = sessao.beginTransaction();  
        sessao.delete(agenda);
        transactio.commit();
        sessao.close();
    }//fim do metodo deleteAgenda

}//fim da classe AgendaDAO
