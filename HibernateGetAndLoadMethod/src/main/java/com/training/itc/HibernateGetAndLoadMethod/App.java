package com.training.itc.HibernateGetAndLoadMethod;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg = new Configuration().configure().addAnnotatedClass(Laptop.class);
        ServiceRegistry reg= new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        SessionFactory sfg= cfg.buildSessionFactory(reg);
       
        Session session1= sfg.openSession();
        session1.beginTransaction();
        
    //Laptop lap= (Laptop) session1.get(Laptop.class, 103);//It gives the Object Every time we use get it hits the database by writing a query.

       // Laptop lap = (Laptop) session1.load(Laptop.class, 103);//Unlike get Load gives the Proxy object.It doesn't hit the database untill and unless we use the object.
       
        try {
        	
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
        
    //    System.out.println(lap.toString());
        
        
        // Another difference between Load and get
       
        //Laptop lap1= (Laptop) session1.get(Laptop.class, 199); //Doesn't have a value 199 in the database thats why showing null result. 
        
        //System.out.println(lap1);
      
     Laptop lap1= (Laptop) session1.load(Laptop.class, 199);// It throws an Exception Object not found.
        
        System.out.println(lap1);
        
        session1.getTransaction().commit();
        
    }
}
