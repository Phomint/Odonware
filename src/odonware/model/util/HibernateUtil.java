package odonware.model.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 * @author Patrick Amaral
 * @since Hibernate criado em 01/06/2017
 */
public class HibernateUtil {
   
    private static SessionFactory factory = null;
    private static Configuration conf;
    
    private static SessionFactory buildSessionFactory(){
        try {
            conf = new Configuration();
            conf.configure("hibernate.cfg.xml");
            
            System.out.println("#P# Configurou hibernate.cfg.xml");
            
            factory = conf.buildSessionFactory();
            
            System.out.println("#P# Construiu ");
            return factory;
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }//fim do catch
    }//fim do buildSessionFactory
    
    public static SessionFactory getSessionFactory() {
        if (factory == null) {
            factory = buildSessionFactory();
        }//fim if
        return factory;
    }//fim do getSessionFactory
}//fim da classe HibernateUtil