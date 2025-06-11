package com.SecondLevel_Caching;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration().configure(); // loads hibernate.cfg.xml
        SessionFactory factory = config.buildSessionFactory();

        // ----------------------
        // First Session
        // ----------------------
        Session session1 = factory.openSession();
        session1.beginTransaction();

        System.out.println("Fetching Animal with ID 1 in Session 1...");
        Animal animal1 = session1.find(Animal.class, 1); // from DB, then cached

        System.out.println("Animal (Session 1): " + animal1.getName());

        session1.getTransaction().commit();
        session1.close();

        // ----------------------
        // Second Session
        // ----------------------
        Session session2 = factory.openSession();
        session2.beginTransaction();

        System.out.println("Fetching Animal with ID 1 in Session 2...");
        Animal animal2 = session2.find(Animal.class, 1); // from cache

        System.out.println("Animal (Session 2): " + animal2.getName());

        session2.getTransaction().commit();
        session2.close();

        factory.close();


    }
}
