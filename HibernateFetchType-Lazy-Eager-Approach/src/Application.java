import java.util.Collection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Application 
{

	
	public static void main(String[] args) 
	{
	Configuration cfg= new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
	ServiceRegistry reg= new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
	SessionFactory sfg=  cfg.buildSessionFactory(reg);
	Session session = sfg.openSession();
	session.getTransaction().begin();
	
	Student s= (Student)session.get(Student.class, 1);
	System.out.println(s.getName());
	
	
	//Lazy Approach
	
	
//	Collection<Laptop>laps = s.getLaps();
//	for(Laptop l: laps)
//	{
//		System.out.println(l);
//	}
	
	
	session.getTransaction().commit();
	session.close();
	

	}
}