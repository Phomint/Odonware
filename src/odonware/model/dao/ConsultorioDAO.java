package odonware.model.dao;

import odonware.model.Consultorio;
import odonware.model.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 * Classe para gerar objetos do tipo ConsultorioDAO
 * @author Patrick Amaral
 * @sinse Classe criada em 09/06/2017
 */
public class ConsultorioDAO {
/**
       * Metodo para salvar um objeto consultorio no banco
       * @param consultorio
       */
      public void createConsultorio(Consultorio consultorio){
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        Transaction transaction = session.beginTransaction();
        session.save(consultorio);
        transaction.commit();
        session.close();
      }//fim do metodo createConsultorio
      
       /**
        * Metodo para atualizar um consultorio no banco de dados
        * @param consultorio
        */
       public void updateConsultorio(Consultorio consultorio){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = sessao.beginTransaction();
        sessao.update(consultorio);
        transaction.commit();
        sessao.close();
    }//fim do metodo updateConsultorio
       
}//fim da classe ConsultorioDAO
