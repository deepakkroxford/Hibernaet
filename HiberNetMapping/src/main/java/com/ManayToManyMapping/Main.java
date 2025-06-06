package com.ManayToManyMapping;

import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
public class Main {
    public static void main(String[] args) {
        System.out.println("Many-to-Many Mapping Example");

        Configuration config = new Configuration();
        config.addAnnotatedClass(com.ManayToManyMapping.Emp.class);
        config.addAnnotatedClass(com.ManayToManyMapping.Project.class);
        config.configure();
       
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();

        Emp e1 = new Emp();
        e1.setEid(1);
        e1.setEmp_name("Deepak Kumar Singh");
        Emp e2 = new Emp();
        e2.setEid(2);
        e2.setEmp_name("Pratik Kumar Singh");

        Project p1 = new Project();
        p1.setPid(101);
        p1.setProjectName("Java full Stack");
        Project p2 = new Project();
        p2.setPid(102);
        p2.setProjectName("Python full Stack");


        p1.getEmp().add(e1);
        p1.getEmp().add(e2);


        List<Emp> employeeList = new ArrayList<Emp>();
        employeeList.add(e1);
        employeeList.add(e2);
        List<Project> projectList = new ArrayList<Project>();   
        projectList.add(p1);
        projectList.add(p2);

        e1.setProject(projectList);
        e2.setProject(projectList); // we are assinging the two project to one employee
        
        p2.setEmp(employeeList); // we are assigning the two employee to one project

        Transaction tx = session.beginTransaction();
        session.persist(e1);
        session.persist(e2);
        session.persist(p1);
        session.persist(p2);

        tx.commit();
        session.close();
        sf.close();

    }
}
