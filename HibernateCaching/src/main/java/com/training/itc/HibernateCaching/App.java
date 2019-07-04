package com.training.itc.HibernateCaching;

import org.hibernate.Query;
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
    	Alien a1= new Alien();
        Configuration cfg = new Configuration().configure().addAnnotatedClass(Alien.class);
        ServiceRegistry reg= new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        SessionFactory sfg= cfg.buildSessionFactory(reg);
        
        
        // Code to enter the data in the table.
        
        
//        Session session= sfg.openSession();
//        session.getTransaction().begin();
//        a1.setAid(102);
//        a1.setAname("Manu");
//        a1.setColor("Yellow");
//        
//        session.save(a1);
//        session.getTransaction().commit();
//        session.close();
//        
        
        
        
        //First Level Cache 
       
//        Session session1= sfg.openSession();
//        session1.beginTransaction();
//        
//        a1=(Alien)session1.get(Alien.class, 101);
//        
//        System.out.println(a1);

//        a1=(Alien)session1.get(Alien.class, 101);
//        
//        System.out.println(a1);
        
//        session1.getTransaction().commit();
//        session1.close();
//        
       
        
        // Second Level cache
//        
//        Session session2 = sfg.openSession();
//        session2.beginTransaction();
//        
//        a1= (Alien)session2.get(Alien.class, 101);
//        
//        System.out.println(a1);
//        
//        session2.getTransaction().commit();
//        session2.close();
        
        
        
        // Caching using Query // first Level Hitting the Query only one time.
        
//        Session session= sfg.openSession();
//        session.beginTransaction();
//        
//        Query q1= session.createQuery("from Alien where aid=101");
//        q1.setCacheable(true);
//        
//        a1= (Alien) q1.uniqueResult();
//        
//        System.out.println(a1);
//        
//        Query q2= session.createQuery("from Alien where aid=101");
//        
//        a1=(Alien) q1.uniqueResult();
//        System.out.println(a1);
//        
//        session.getTransaction().commit();
//        session.close();
        
        
        //Caching using Query // second level
        
      Session session1= sfg.openSession();
      session1.beginTransaction();
      
      Query q1= session1.createQuery("from Alien where aid=101");
      q1.setCacheable(true);
      
      a1= (Alien) q1.uniqueResult();
      
      System.out.println(a1);
      
      session1.beginTransaction().commit();
      session1.close();
      
      
      Session session2= sfg.openSession();
      session2.beginTransaction();
      
      Query q2= session2.createQuery("from Alien where aid=101");
      
      a1=(Alien) q1.uniqueResult();
      System.out.println(a1);
      
      session2.getTransaction().commit();
      session2.close();
      
    }
}
