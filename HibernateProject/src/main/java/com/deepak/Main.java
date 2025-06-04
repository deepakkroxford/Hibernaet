package com.deepak;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setId(4);
        s1.setName("DIPU");
        s1.setGrade("A+");
        s1.setAddress("Paithanpur");
        s1.setEmail("dipu@gmail.com");
        s1.setAge(20);
        System.out.println(s1);

        // Create a Hibernate configuration and build the session factory
        Configuration config = new Configuration();
        //Adding the annotated class that we want to add in the database
        config.addAnnotatedClass(com.deepak.Student.class);
        config.addAnnotatedClass(com.deepak.Employee.class);
        /**
         Setting the properties for the database connection it defaults take the filename hibernate.cfg.xml if your file name is
         different then  you have to set the properties manually
         *
         */
        config.configure(); // only called once

        SessionFactory factory = config.buildSessionFactory(); // removed duplicate configure()
        Session session = factory.openSession();

        // Begin a transaction, persist the entity, and commit the transaction so it only saves the data in the databse
        // if you don't commit the transaction then it will not save the data in the database
        Transaction transaction = session.beginTransaction();
        /**@Insert
         * for inserting the data in the database we can use the persist method
         * after using the persist method we have to run the commit method to save the data in the database
         * * The persist method is used to save the data in the database it will not return any value.
         */
        session.persist(s1);

        /**@fetch
         * this is used to fetch the data from the database
         * we can use the find method to fetch the data from the database it is the new way of fetching the data
         * we can also use the get method to fetch the data from the database but it is the old way of fetching the data now it deprecated
         */
        Student a1 = session.find(Student.class, 4);
        Student a2 = session.find(Student.class, 1);
        System.out.println("the data is :" + a1);
        System.out.println("the data is :" + a2);

        /**@update
         *
         * Now we will update the data in the database using the method called merge
         * So the merge method is used to update the data in the database first it will check if the data is present in the database
         * if it is present then it will update the data in the databases otherwise it will create a new record in the database.
         */
        //session.merge(s1); //this is used to update the data in the database and after this we have to run the commit method to save the data in the database

        /**@delete
         *
         * first we have to fetch the data from the database then we can delete the data from the database.
         * remove method is used to delete the data from the database.
         * so the remove method takes the object as a parameter and it will delete the data from the database.
         *
         */
        if (a1 != null) {
            session.remove(a1); //this is used to delete the data from the database
        }

        //session.persist(s1); this is used to save the data in the database
        transaction.commit();
        session.close();

        /// -------- Now we will add the Employee data in the database using the same session factory --------
        Session session1 = factory.openSession();
        Transaction transaction1 = session1.beginTransaction();

        Employee e1 = new Employee();
        e1.setId(2);
        e1.setName("Deepak");
        e1.setGrade("A+");
        e1.setAddress("Paithanpur");
        e1.setEmail("deepak@gmail.com");
        e1.setAge(20);

        session1.persist(e1); // this is used for to save the data in the databse
        transaction1.commit(); //this is used for to commit the data in the databse
        session1.close();

        factory.close();
    }
}
