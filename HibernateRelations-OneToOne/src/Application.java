
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

		Student s1 = new Student();
		s1.setRollNo(01);
		s1.setName("Ammy");
		s1.setMarks(98);
		s1.setLap(l1);

		Configuration cfg = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		SessionFactory sf = cfg.buildSessionFactory(reg);
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(l1);
		session.save(s1);
		session.getTransaction().commit();
		session.close();

	}
}
