package com.FirstLevel_Caching;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;

import org.hibernate.query.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("hello world");
        // Create a Hibernate configuration and build the session factory
        Configuration config = new Configuration();
        config.addAnnotatedClass(Dog.class);
        config.configure();
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        // Create a new Dog object and save it to the database
        Dog dog1 = new Dog();
        dog1.setName("Husky");
        dog1.setColor("white");

        Dog data1 = session.find(Dog.class,1);
        System.out.println(data1); // it will make a query to the database because the data is not present in the cache memory
        System.out.println(session.contains(data1)); // it check the data is present in the session or not in cache memory
        System.out.println("Doing some work.........");

        Dog data2 = session.find(Dog.class,1);
        System.out.println(data2); // it will not make any query to the database because the data is already present in the cache memory

        System.out.println(session.contains(data2)); // it check the data is present in the session or not in cache memory

        Transaction tx = session.beginTransaction();
        //int id = (int) session.save(dog1); the save method is depricated not in use 
        session.persist(dog1); // the persist method is used to save the data in the database
        tx.commit();
        session.close();


        Session session2 = factory.openSession();
        session2.beginTransaction();
        
        Dog dog2 = new Dog();
        dog2.setId(1);
        dog2.setName("Husky");
        dog2.setColor("white");
        session2.merge(dog2);
        session2.getTransaction().commit();

        //getting all dog data using HQL 
        String x = "from Dog";
        Query q =  session2.createQuery(x);
        List<Dog> l1 = q.list();
        for (Dog d : l1) {
            System.out.println(d);
        }
        session2.close();

        factory.close();

    }
}
