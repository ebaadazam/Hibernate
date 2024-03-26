package com.ebaad.HibernateCaching2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App 
{
    public static void main( String[] args )
    {
    	Humans obj =null;
    
    	Configuration con = new Configuration().configure().addAnnotatedClass(Humans.class);
    	ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
    	SessionFactory sf = con.buildSessionFactory(reg);
    	
    	// Whenever we fire a query, it will first check in the First Level Cache. If the query is not there it goes to the Second Level Cache. If it is not in the 2LC as well then it will hit the database
    	
        // If we are firing the same query in two different sessions, we will get two separate queries on the console as First Level Cache works fora particular session.
        // Session 1
        Session session2 = sf.openSession();
        Transaction tx2 = session2.beginTransaction();    
        
        obj = (Humans) session2.get(Humans.class, 22);
        System.out.println(obj);
        
        tx2.commit();
        
        // Session 2
        Session session3 = sf.openSession();
        Transaction tx3 = session3.beginTransaction(); 
        
        obj = (Humans) session3.get(Humans.class, 22);
        System.out.println(obj);
        
        tx3.commit();
    }
}

