package com.ebaad.HibernateMappingRelations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {
    public static void main( String[] args ) {
    	
    	// Creating an instance of Mobile Class
    	Mobile mobile = new Mobile();
    	mobile.setMid(101);
    	mobile.setMname("Samsung");
    	
    	
    	// Creating an instance of Person Class
    	Person person = new Person();
    	person.setRollno(1);
    	person.setName("Ebaad");
    	person.setCourse("BCA");	
    	
    	mobile.setPerson(person); // relationship of ManyToOne
    	
      	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Person.class).addAnnotatedClass(Mobile.class);
    	ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
    	SessionFactory sf = con.buildSessionFactory(reg);
    	Session session = sf.openSession();
    	
    	session.beginTransaction();
    	
    	session.save(mobile);
    	session.save(person);
    	
    	session.getTransaction().commit();
    	
    
    }
}

