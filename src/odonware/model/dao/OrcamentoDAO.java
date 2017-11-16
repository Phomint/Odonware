package odonware.model.dao;

import java.util.ArrayList;
import java.util.List;
import odonware.model.Orcamento;
import odonware.model.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

/**
 * Classe para gerar objetos do tipo OrcamentoDAO
 * @author Patrick Amaral
 * @since Classe gerada em 12/11/2017
 */
public class OrcamentoDAO {
    
    /**
       * Metodo para salvar um objeto orcamento no banco
       * @param orcamento
       */
      public void createOrcamento(Orcamento orcamento){
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        Transaction transaction = session.beginTransaction();
        session.save(orcamento);
        transaction.commit();
        session.close();
      }//fim do metodo createOrcamento
      
        /**
         * Metodo para listar orcamentos em ordem asc
         * @return orcamento
         */
       @SuppressWarnings("unchecked")
       public List<Orcamento> readOrcamentosOrdem() {      
        Session sessao = HibernateUtil.getSessionFactory().openSession();
                
        List<Orcamento> orcamentos = new ArrayList<Orcamento>();
        sessao.beginTransaction();
        Criteria criterio = sessao.createCriteria(Orcamento.class);
        criterio.addOrder(Order.asc("codigo"));   
        orcamentos = criterio.list();
        
        sessao.getTransaction().commit();      
        sessao.close();
        return orcamentos;
      }//fim do metodo readOrcamentoOrdem
       
       /**
        * Metodo para atualizar um orcamento no banco de dados
        * @param orcamento  
        */
       public void updateOrcamento(Orcamento orcamento){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = sessao.beginTransaction();
        sessao.update(orcamento);
        transaction.commit();
        sessao.close();
    }//fim do metodo updateOrcamento
       
       /**
        * Metodo para remover o orcamento do banco de dados
        * @param orcamento
        */
       public void deleteOrcamento(Orcamento orcamento){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transactio = sessao.beginTransaction();  
        sessao.delete(orcamento);
        transactio.commit();
        sessao.close();
    }//fim do metodo deleteOrcamento

}
