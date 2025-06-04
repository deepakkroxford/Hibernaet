package com.OneToOneMapping;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Configuration config = new Configuration();
        config.addAnnotatedClass(com.OneToOneMapping.Question.class);
        config.addAnnotatedClass(com.OneToOneMapping.Answer.class);
        config.configure();

        SessionFactory sf = config.buildSessionFactory();
        Session s = sf.openSession();

        // Creating the new Question and setting the values
        Question q2 = new Question();
        q2.setId(2);
        q2.setQuestionText("What is Hibernaet?");
        // Creating the new Answer and setting the values
        Answer a1 = new Answer();
        a1.setId(2);
        a1.setAnswerText("Hibernate is the ORM (Object relation Mapping )tool and reduce the complexity of database operations in Java applications.");
        q2.setAnswer(a1);


        Transaction t = s.beginTransaction();
        // Saving the Question and Answer objects
        s.persist(q2);

        t.commit();

        s.close();
    }
}