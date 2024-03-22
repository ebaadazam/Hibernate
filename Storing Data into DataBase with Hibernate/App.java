package com.ebaad.HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App {
    public static void main(String[] args) {
    	// Create an instance of the Cars entity to be saved in the database
        Cars obj = new Cars();
        // Data to be inserted into the Database
        obj.setYear(2018);
        obj.setKmsDriven(15000);
        obj.setBrand("Aston Martin");
        obj.setModel("DB 12");
        
        /* This line initializes a new Configuration object. The Configuration class is used to configure Hibernate. It includes 
        settings related to the database connection, dialect, entity classes, and other Hibernate-specific configurations.
        Typically, the Configuration object reads settings from the hibernate.cfg.xml file. */
        Configuration con = new Configuration().configure().addAnnotatedClass(Cars.class);
        /* Above configure() method is used to have access to the hibernate.cfg.xml file. And we also need to specify the class
           we are working with i.e, Cars using addAnnotatedClass method */

        /* SessionFactory is an interface that provides factory methods for Session instances. It is typically configured with the 
        help of the Configuration object, which loads Hibernate configuration parameters (e.g., database connection settings, entity
        mappings) from the hibernate.cfg.xml file or through programmatic configuration. */
        StandardServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        
        /* We need to create the instance of Session Interface to use the save() method which belongs to the Session interface and 
        Session is obtained from the SessionFactory interface by calling the openSession() method that provides with the object
        of Session. */
        SessionFactory sf = con.buildSessionFactory(reg);

        // Open a session. A session is used to get a physical connection with a database.
        // The Session object is lightweight and designed to be instantiated each time an interaction is needed with the database.
        Session session = sf.openSession();
        
        /* Whenever we are saving the data into the database using save(), you'll be making some changes. And when you make a change
         * you have to follow the acid property(i.e atomicity, consistency, isolation, durability). So to maintain that we have to make
         * sure all the changes should be a part of the transaction. So we are creating the object of the transaction and after saving
         * the object into databse we are commiting the transaction instance. */
        
        // Begin a unit of work and return the associated Transaction object.
        // A transaction is associated with a Session and is usually instantiated by a call to Session.beginTransaction().
        Transaction tx = session.beginTransaction();
        
        // Save the object into the database. This line makes the instance persistent.
        session.save(obj);
            
        // Commit the transaction to save the changes into the database and close the current session of work.
        tx.commit();
    }
}
