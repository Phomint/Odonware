package odonware.model.dao;

import java.util.ArrayList;
import java.util.List;
import odonware.model.Usuario;
import odonware.model.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 * Classe para gerar objetos do tipo UsuarioDAO
 * @author Patrick Amaral
 * @sinse Classe criada em 05/06/2017
 */
public class UsuarioDAO {
  
      //CONSTRUTOR DEFAULT
      public UsuarioDAO(){
        System.out.println("construtor >> UsuarioDAO");
      }//fim do construtor 
       
       /**
       * Metodo para salvar um objeto usuario no banco
       * @param usuario
       */
       public void createUsuario(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(usuario);
        transaction.commit();
        session.close();
    } //fim do metodo createUsuario
      
        /**
         * Metodo para listar usuarios em ordem asc
         * @return usuarios
         */
       @SuppressWarnings("unchecked")
       public List<Usuario> readUsuarioOrdem() {      
        Session sessao = HibernateUtil.getSessionFactory().openSession();
                
        List<Usuario> usuarios = new ArrayList<Usuario>();
        sessao.beginTransaction();
        Criteria criterio = sessao.createCriteria(Usuario.class);
        criterio.addOrder(Order.asc("codigo"));   
        usuarios = criterio.list();
        
        sessao.getTransaction().commit();      
        sessao.close();
        return usuarios;
      }//fim do metodo readUsuarioOrdem
       
       /**
        * Metodo para atualizar um usuario no banco de dados
        * @param usuario 
        */
       public void updateUsuario(Usuario usuario){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = sessao.beginTransaction();
        sessao.update(usuario);
        transaction.commit();
        sessao.close();
    }//fim do metodo updateUsuario
       
       /**
        * Metodo para remover o usuario do banco de dados
        * @param usuario
        */
       public void deleteUsuario(Usuario usuario){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transactio = sessao.beginTransaction();  
        sessao.delete(usuario);
        transactio.commit();
        sessao.close();
    }//fim do metodo deleteUsuario
       
       
        public Usuario validarLogin(String login, String senha) {
           System.out.println("UsuarioDAO >> validarLogin ");
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criterio = sessao.createCriteria(Usuario.class);
        criterio.add(Restrictions.eq("usuario", login));
        criterio.add(Restrictions.eq("senha", senha));
        Usuario usuario = (Usuario)criterio.uniqueResult();
        sessao.close();
        return usuario;
    }//fim do metodo validarLogin

}//fim da classe UsuarioDAO
