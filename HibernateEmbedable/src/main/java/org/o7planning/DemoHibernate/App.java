package org.o7planning.DemoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
        AlienName an=new AlienName();
        
        an.setfName("Manprit");
        an.setlName("Nautiyal");
        an.setmName("Kaur");
    	Alien a1= new Alien();

    	a1.setAid(101);
    	a1.setColor("Green");
    	a1.setAname(an);
    	
    	Configuration cfg= new Configuration();
    	cfg.configure();
    	cfg.addAnnotatedClass(Alien.class);
    	
    	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
    	SessionFactory sf= cfg.buildSessionFactory(reg);
    	Session session=sf.openSession();
    	
    	Transaction tx = session.beginTransaction();
    	session.save(a1);
    	
    	
    	tx.commit();
    	
    	
    	System.out.println(a1);
    	
    }
}
