package Embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        // This is the main method where you can run your application
        Configuration config = new Configuration();
        config.addAnnotatedClass(com.anotation.Teacher.class);
        config.configure();
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();


        // Creating the new Boys ans setting the values

        Boys b1 = new Boys();
        b1.setName("Deepak Kumar");
        b1.setAge(20);

        Certificate c1 = new Certificate();
        c1.setCourseName("Java Programming");
        c1.setDuration("3 Months");
        b1.setCertificate(c1);

        Transaction ts = session.beginTransaction();

        session.persist(b1);

        ts.commit();

        sf.close();




    }
}
