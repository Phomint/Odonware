package odonware.model.dao;

import java.util.ArrayList;
import java.util.List;
import odonware.model.Dentista;
import odonware.model.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

/**
 * Classe para gerar objetos do tipo DentistaDAO
 * @author Patrick Amaral
 * @sinse Classe criada em 01/06/2017
 */
public class DentistaDAO {

    /**
       * Metodo para salvar um objeto dentista no banco
       * @param dentista
       */
      public void createDentista(Dentista dentista){
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        Transaction transaction = session.beginTransaction();
        session.save(dentista);
        transaction.commit();
        session.close();
      }//fim do metodo createDentista
      
        /**
         * Metodo para listar dentistas em ordem asc
         * @return dentista
         */
       @SuppressWarnings("unchecked")
       public List<Dentista> readDentistaOrdem() {      
        Session sessao = HibernateUtil.getSessionFactory().openSession();
                
        List<Dentista> dentistas = new ArrayList<Dentista>();
        sessao.beginTransaction();
        Criteria criterio = sessao.createCriteria(Dentista.class);
        criterio.addOrder(Order.asc("nome"));   
        dentistas = criterio.list();
        
        sessao.getTransaction().commit();      
        sessao.close();
        return dentistas;
      }//fim do metodo readDentistaOrdem
       
       /**
        * Metodo para atualizar um dentista no banco de dados
        * @param dentista 
        */
       public void updateDentista(Dentista dentista){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = sessao.beginTransaction();
        sessao.update(dentista);
        transaction.commit();
        sessao.close();
    }//fim do metodo updateDentista
       
       /**
        * Metodo para remover o dentista do banco de dados
        * @param dentista 
        */
       public void deleteDentista(Dentista dentista){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transactio = sessao.beginTransaction();  
        sessao.delete(dentista);
        transactio.commit();
        sessao.close();
    }//fim do metodo deleteDentista

}//fim da classe DentistaDAO
