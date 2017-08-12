package odonware.model.dao;

import java.util.ArrayList;
import java.util.List;
import odonware.model.Funcionario;
import odonware.model.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

/**
 * Classe para gerar objetos do tipo FuncionarioDAO
 * @author Patrick Amaral
 * @sinse Classe criada em 06/06/2017
 */
public class FuncionarioDAO {
 /**
       * Metodo para salvar um objeto funcionario no banco
       * @param funcionario
       */
      public void createFuncionario(Funcionario funcionario){
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        Transaction transaction = session.beginTransaction();
        session.save(funcionario);
        transaction.commit();
        session.close();
      }//fim do metodo createFuncionario
      
        /**
         * Metodo para listar Funcionarios em ordem asc
         * @return funcionario
         */
       @SuppressWarnings("unchecked")
       public List<Funcionario> readFuncionarioOrdem() {      
        Session sessao = HibernateUtil.getSessionFactory().openSession();
                
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        sessao.beginTransaction();
        Criteria criterio = sessao.createCriteria(Funcionario.class);
        criterio.addOrder(Order.asc("nome"));   
        funcionarios = criterio.list();
        
        sessao.getTransaction().commit();      
        sessao.close();
        return funcionarios;
      }//fim do metodo readFuncionarioOrdem
       
       /**
        * Metodo para atualizar um funcionario no banco de dados
        * @param funcionario 
        */
       public void updateFuncionario(Funcionario funcionario){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = sessao.beginTransaction();
        sessao.update(funcionario);
        transaction.commit();
        sessao.close();
    }//fim do metodo updateFuncionario
       
       /**
        * Metodo para remover o funcionario do banco de dados
        * @param funcionario
        */
       public void deleteFuncionario(Funcionario funcionario){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transactio = sessao.beginTransaction();  
        sessao.delete(funcionario);
        transactio.commit();
        sessao.close();
    }//fim do metodo deleteFuncionario

}//fim da classe FuncionarioDAO
