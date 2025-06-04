package com.anotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Configuration config = new Configuration();
        config.addAnnotatedClass(com.anotation.Teacher.class);
        config.configure();
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();

        Transaction ts = session.beginTransaction();

        Teacher t1 = new Teacher();
        t1.setName("Harshit Singh");
        t1.setSubject("Science");
        t1.setEmail("harshitsingh@gmail.com");
        t1.setAge(30);
        t1.setAddress("Arrah, Bihar");
        t1.setGrade("A");
        t1.setAddedDate(new Date());


        session.persist(t1);

        Teacher f1 = session.find(Teacher.class, 1);
        System.out.println("the data is :" + f1.getName());
        // or
       Teacher f2 = (Teacher) session.byId(Teacher.class).load(1);
        System.out.println("the data is :" + f2.getAddress());

        ts.commit();


        sf.close();
        }
    }
