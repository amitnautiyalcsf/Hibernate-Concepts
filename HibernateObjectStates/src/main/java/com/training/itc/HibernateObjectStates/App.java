package com.training.itc.HibernateObjectStates;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    
    	Configuration cfg = new Configuration().configure().addAnnotatedClass(Laptop.class);
        ServiceRegistry reg= new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        SessionFactory sfg= cfg.buildSessionFactory(reg);
       
        Session session1= sfg.openSession();
        session1.beginTransaction();

        Laptop l= new Laptop(); //Transient state // here we got the object but it is not stored in the database
        
//        l.setlId(108);
//        l.setBrand("Acer");
//        l.setPrice(5000000);
        
//        session1.save(l); // persistent state // Here in this state the object is stored in the database but when you commit.
//        l.setPrice(600); // here we are expecting the value to be 5000000 but we got 600 bcoz the object is still in the persist state the changes we made with the object it get reflected in the database as well.
        
        l.setlId(110);
        l.setBrand("Asus");
        l.setPrice(300000);
        session1.save(l);
        l.setPrice(750);
        
//        session1.getTransaction().commit();
        //
        
//        session1.evict(l); // Now the object we made goes to detach state
//        l.setPrice(600);// what ever changes we make now will not reflect in the database.
//        
        //
        
        
        
        
    
        
        session1.delete(l);// remove state 
        session1.getTransaction().commit();
    }
}
