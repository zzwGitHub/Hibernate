package com.example.Hib_Maven;

import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.example.Hib_Maven.model.Student;

/**
 * Hello world!
 *
 */
public class App 
{
   	private static Configuration configuration = null;  
    private static SessionFactory sessionFactory = null;  
    private static ServiceRegistry serviceRegistry = null;  
    public static void main(String[] args) {  
        try {  
            configuration = new Configuration().configure();  
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();  
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);  
            
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            Student student = new Student();
            student.setName("hibhib");
            
            session.save(student);
            
        } catch (HibernateException e) {  
            e.printStackTrace();  
        }  
    }  
    
}
