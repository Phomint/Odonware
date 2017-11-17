package odonware.model.dao;

import java.util.ArrayList;
import java.util.List;
import odonware.model.Paciente;
import odonware.model.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 * Classe para gerar objetos do tipo PacienteDAO
 * @author Patrick Amaral
 * @sinse Classe criada em 11/06/2017
 */
public class PacienteDAO {
      /**
       * Metodo para salvar um objeto paciente no banco
       * @param paciente
       */
      public void createPaciente(Paciente paciente){
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        Transaction transaction = session.beginTransaction();
        session.save(paciente);
        transaction.commit();
        session.close();
      }//fim do metodo createPaciente
      
        /**
         * Metodo para listar paciente em ordem asc
         * @return paciente
         */
       @SuppressWarnings("unchecked")
       public List<Paciente> readPacienteOrdem() {      
        Session sessao = HibernateUtil.getSessionFactory().openSession();
                
        List<Paciente> pacientes = new ArrayList<Paciente>();
        sessao.beginTransaction();
        Criteria criterio = sessao.createCriteria(Paciente.class);
        criterio.addOrder(Order.asc("nome"));   
        pacientes = criterio.list();
        
        sessao.getTransaction().commit();      
        sessao.close();
        return pacientes;
      }//fim do metodo readPacienteOrdem
       
       /**
        * Metodo para atualizar um paciente no banco de dados
        * @param paciente
        */
       public void updatePaciente(Paciente paciente){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = sessao.beginTransaction();
        sessao.update(paciente);
        transaction.commit();
        sessao.close();
    }//fim do metodo updatePaciente
       
       /**
        * Metodo para remover o paciente do banco de dados
        * @param paciente
        */
       public void deletePaciente(Paciente paciente){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transactio = sessao.beginTransaction();  
        sessao.delete(paciente);
        transactio.commit();
        sessao.close();
    }//fim do metodo deletePaciente
       
        public List<Paciente> buscarPorNome(String nome){
            System.out.println("PacienteDAO >> buscarPorNome");
        Session sessao = HibernateUtil.getSessionFactory().openSession(); 
           
         List<Paciente> pacientes = new ArrayList<Paciente>();
        Criteria criterio = sessao.createCriteria(Paciente.class);
        criterio.add(Restrictions.ilike("nome","%"+nome+"%"));
         pacientes = criterio.list(); 
          
        sessao.close();
        
        return pacientes;
        }//fim do metodo buscarPorNome

}//fim da classe PacienteDAO
