package com.mychannel.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Application 
{
	public static void main(String[] args) {
		
	StudentData st= new StudentData();
	FullName fn= new FullName();
	fn.setfName("Manprit");
	fn.setmName("Kaur");
	fn.setlName("Nautiyal");
	
	
	st.setRollNo(01);
	st.setMarks(99);
	st.setName(fn);
	
	
	Configuration cfg = new Configuration().configure().addAnnotatedClass(StudentData.class).addAnnotatedClass(FullName.class);
	ServiceRegistry reg= new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
	SessionFactory sfg = cfg.buildSessionFactory(reg);
	Session session= sfg.openSession();
	
	session.getTransaction().begin();
	session.save(st);
	
	session.getTransaction().commit();
	
	session.close();
	
	
	
	
	}

}
