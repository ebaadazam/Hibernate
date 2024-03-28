package com.ebaad.HibernateHQL;

import java.util.List;

import javax.persistence.Query;

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
    	Configuration con = new Configuration().configure().addAnnotatedClass(DummyTable.class);
    	ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
    	SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
//      Inserting data into the table 
//        for(int i=1; i<=15; i++) {
//        	DummyTable dt = new DummyTable();
//        	dt.setId(i);
//        	dt.setName("Boy"+i);
//        	dt.setScore(i*i);
//        	session.save(dt);
//        }
        
        // Query for printing all the rows of the table
//        Query query = session.createQuery("from DummyTable"); //first create an object of Query to fire the query
//        List<DummyTable> dummy = query.getResultList(); // we need a list if we want mutiple rows of table
        // using enhanced for loop for printing all the rows
//        for(DummyTable table : dummy) {
//        	System.out.println(table);
//        }
        
        // Query for printing a particular rows of the table
//        Query query = session.createQuery("from DummyTable where id>10");
//        List<DummyTable> dummy = query.getResultList();
//        for(DummyTable table : dummy) {
//        	System.out.println(table);
//        }
        
        // Query for printing a particular row of the table
//        Query query = session.createQuery("from DummyTable where id=10"); //fetching only one row
//        DummyTable dummy = (DummyTable) ((org.hibernate.query.Query) query).uniqueResult(); // uniqueResult() is used only for one row and we are also not using the List here as it is just a single row
//        System.out.println(dummy);
        
        // Query for fetching only selected columns not all. All columns are treated as Objects
//        Query query = session.createQuery("select id,name from DummyTable");
//        List<Object[]> dummy = (List<Object[]>) query.getResultList();
//        for(Object[] table : dummy) {
//        	System.out.println(table[0] + "  " + table[1]);
//        }
        
        
        // Query for fetching row contents
//        Query query = session.createQuery("select id, name, score from DummyTable where id=8");
//        Object[] dummy = (Object[]) ((org.hibernate.query.Query) query).uniqueResult();
//        for(Object rs : dummy) {
//        	System.out.println(rs);
//        }
        
        // Query to calculate the sum of any field
        Query query = session.createQuery("select sum(id) from DummyTable where id<15");
        Integer sum1 =  (Integer) ((org.hibernate.query.Query) query).uniqueResult();
        System.out.println(sum1);
        
        tx.commit();
    }
}

