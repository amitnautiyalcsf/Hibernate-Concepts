
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Application {

	public static void main(String args[]) {
		Laptop l1 = new Laptop();
		l1.setlId(101);
		l1.setlName("Dell");
		
		Student s= new Student();
		s.setName("Ammy");
		s.setRollNo(1);
		s.setMarks(98);
		s.getLaps().add(l1);
		
		l1.setSt(s);
		
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		SessionFactory sf = cfg.buildSessionFactory(reg);
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(l1);
     	session.save(s);
		session.getTransaction().commit();
		session.close();

	}
}
