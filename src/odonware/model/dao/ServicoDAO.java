package odonware.model.dao;

import java.util.ArrayList;
import java.util.List;
import odonware.model.Servico;
import odonware.model.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 * Classe para gerar objetos do tipo ServicoDAO
 * @author Patrick Amaral
 * @sinse Classe criada em 21/06/2017
 */
public class ServicoDAO {
  /**
       * Metodo para salvar um objeto serviço no banco
       * @param servico
       */
      public void createServico(Servico servico){
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        Transaction transaction = session.beginTransaction();
        session.save(servico);
        transaction.commit();
        session.close();
      }//fim do metodo createServico
      
        /**
         * Metodo para listar serviços em ordem asc
         * @return servico
         */
       @SuppressWarnings("unchecked")
       public List<Servico> readServicoOrdem() {      
        Session sessao = HibernateUtil.getSessionFactory().openSession();
                
        List<Servico> servicos = new ArrayList<Servico>();
        sessao.beginTransaction();
        Criteria criterio = sessao.createCriteria(Servico.class);
        criterio.addOrder(Order.asc("nome"));   
        servicos = criterio.list();
        
        sessao.getTransaction().commit();      
        sessao.close();
        return servicos;
      }//fim do metodo readServicoOrdem
       
       /**
        * Metodo para atualizar um serviço no banco de dados
        * @param servico
        */
       public void updateServico(Servico servico){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = sessao.beginTransaction();
        sessao.update(servico);
        transaction.commit();
        sessao.close();
    }//fim do metodo updateServico
       
       /**
        * Metodo para remover o serviço do banco de dados
        * @param servico
        */
       public void deleteServico(Servico servico){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transactio = sessao.beginTransaction();  
        sessao.delete(servico);
        transactio.commit();
        sessao.close();
    }//fim do metodo deleteServico
       
       public List<Servico> buscarPorNome(String nome){
            System.out.println("ServicoDAO >> buscarPorNome");
        Session sessao = HibernateUtil.getSessionFactory().openSession(); 
           
         List<Servico> servicos = new ArrayList<Servico>();
        Criteria criterio = sessao.createCriteria(Servico.class);
        criterio.add(Restrictions.ilike("nome","%"+nome+"%"));
         servicos = criterio.list(); 
          
        sessao.close();
        
        return servicos;
        }//fim do metodo buscarPorNome

}//fim da classe ServicoDAO
