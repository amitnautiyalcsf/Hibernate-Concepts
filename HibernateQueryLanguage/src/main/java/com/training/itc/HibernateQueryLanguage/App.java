package com.training.itc.HibernateQueryLanguage;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg = new Configuration().configure().addAnnotatedClass(Student.class);
        ServiceRegistry reg= new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        SessionFactory sfg= cfg.buildSessionFactory(reg);
       
        Session session1= sfg.openSession();
        
        int b=60;
        session1.beginTransaction();
        
//        Random r = new Random();
//        
//        for(int i=1;i<50;i++)
//        {
//        	
//        	Student s= new Student();
//        	s.setRollNo(i);
//        	s.setName("Name" +i);
//        	s.setMarks(r.nextInt(100));
//        	session1.save(s);
//        }
        
        
        // Native Queries.....
        
//        SQLQuery query = session1.createSQLQuery("Select * from student where marks>60");
//        query.addEntity(Student.class);
//        List<Student> students = query.list();
//        for(Student o: students)
//        {
//        	System.out.println(o);
//        	
//        }
        
//        SQLQuery query = session1.createSQLQuery("select name,marks from student where marks<60");
//    
//        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
//        
//        List students = query.list();
//        for(Object o: students)
//        {
//        	Map m= (Map)o;
//        	System.out.println(m.get("NAME") + ":" + m.get("MARKS"));
//        	
//        }
        
        
        
        //HQL Queries
     
//        Query q1= session1.createQuery("from Student");
//        List<Student>students= q1.list();
//        for(Student s: students)
//        {
//        	
//        	System.out.println(s);
//        	
//        }
        
//        Query q1= session1.createQuery("from Student where marks > 50");
//        List<Student>students= q1.list();
//        for(Student s: students)
//        {
//        	
//        	System.out.println(s);
//        	
//        }
        
        
//        Query q1= session1.createQuery("from Student where rollNo=7");
//        Student s= (Student)q1.uniqueResult();
//        
//        	
//        	System.out.println(s);
//        	

//        Query q1= session1.createQuery("select rollNo,name,marks from Student where rollNo=7");
//      Object[] student= (Object[]) q1.uniqueResult();
//       
//      for(Object o: student)
//      {
//   	   System.out.print(o);
//     }
//       
//      System.out.println(student[0] + " : " + student[1] +" " + student[2]);
        

//        Query q1= session1.createQuery("select rollNo,name,marks from Student s where s.marks>60");
//       List<Object[]> students= (List<Object[]>) q1.list();
//
//       for(Object[] student: students)
//       {
//    	   
//    	   System.out.println(student[0] + " : " + student[1] + " : " + student[2]);
//    	   
//       }
        
        
        
//        Query q1= session1.createQuery("select sum(marks) from Student s where s.marks>60");
//        Long marks=(Long) q1.uniqueResult();
//        System.out.println(marks);
       
         Query q1= session1.createQuery("select sum(marks) from Student s where s.marks>:b");
         q1.setParameter("b", b);
         Long marks=(Long) q1.uniqueResult();
         System.out.println(marks);

        
        session1.getTransaction().commit();
        
    }
}
