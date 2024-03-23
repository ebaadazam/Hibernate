// Program to fetch the data from the database
package com.ebaad.HibernateFetchData;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Cars obj = new Cars(); // creating an instance of the Cars Class
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Cars.class);
        
        StandardServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
        obj = (Cars) session.get(Cars.class, 2022); 
        /* Storing the data into the Cars Object with the help of the get() method which takes two
           paramters i.e, class name and the primary key of the table which is year in this case. Using this primary key, we are fetching the whole
           row of the table and we are laos typcasting it with the Cars class as get() is of type Class Object */
        
        System.out.println(obj); // prints on the console
        
        tx.commit();
    }
}

