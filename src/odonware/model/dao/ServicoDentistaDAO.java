package odonware.model.dao;

import java.util.ArrayList;
import java.util.List;
import odonware.model.ServicoDentista;
import odonware.model.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

/**
 * Classe para gerar objetos do tipo ServicoDentistaDAO
 * @author Patrick Amaral
 * @sinse Classe criada em 21/06/2017
 */
public class ServicoDentistaDAO {
  /**
       * Metodo para salvar um objeto ServicoDentista no banco
       * @param s
       */
      public void createServicoDentista(ServicoDentista s){
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        Transaction transaction = session.beginTransaction();
        session.save(s);
        transaction.commit();
        session.close();
      }//fim do metodo createServicoDentista
      
        /**
         * Metodo para listar ServicoDentista em ordem asc
         * @return servicoDentistas
         */
       @SuppressWarnings("unchecked")
       public List<ServicoDentista> readServicoDentistaOrdem() {      
        Session sessao = HibernateUtil.getSessionFactory().openSession();
                
        List<ServicoDentista> servicoDentistas = new ArrayList<ServicoDentista>();
        sessao.beginTransaction();
        Criteria criterio = sessao.createCriteria(ServicoDentista.class);
        criterio.addOrder(Order.asc("nome"));   
        servicoDentistas = criterio.list();
        
        sessao.getTransaction().commit();      
        sessao.close();
        return servicoDentistas;
      }//fim do metodo readServicoDentistaOrdem
       
       /**
        * Metodo para atualizar um servicodentista no banco de dados
        * @param servicoDentista 
        */
       public void updateServicoDentista(ServicoDentista servicoDentista){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = sessao.beginTransaction();
        sessao.update(servicoDentista);
        transaction.commit();
        sessao.close();
    }//fim do metodo updateServicoDentista
       
       /**
        * Metodo para remover o ServicoDentista do banco de dados
        * @param servicoDentista 
        */
       public void deleteServicoDentista(ServicoDentista servicoDentista){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transactio = sessao.beginTransaction();  
        sessao.delete(servicoDentista);
        transactio.commit();
        sessao.close();
    }//fim do metodo deleteServicoDentista

}//fim da classe ServicoDentistaDAO
