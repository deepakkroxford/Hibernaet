package com.OneToManyMappingAndManytoOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Configuration config = new Configuration();
        config.configure();
        config.addAnnotatedClass(DepartMent.class);
        config.addAnnotatedClass(Employees.class);

        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();

        // ---------- Insert Data ----------
        DepartMent d1 = new DepartMent();
        d1.setDepartmentName("Computer Science");

        Employees e1 = new Employees();
        e1.setEmployeeName("John Doe");
        e1.setDepartment(d1);

        Employees e2 = new Employees();
        e2.setEmployeeName("Jane Smith");
        e2.setDepartment(d1);

        d1.setEmployeesList(Arrays.asList(e1, e2)); // Link both employees to department

        Transaction tx = session.beginTransaction();
        session.persist(d1); // Cascade saves employees too
        tx.commit();

        // ---------- Fetch Employees by Department ----------
        DepartMent fetchedDept = session.find(DepartMent.class, d1.getId());

        System.out.println("Department: " + fetchedDept.getDepartmentName());
        System.out.println("Employees working in this department:");
        for (Employees emp : fetchedDept.getEmployeesList()) {
            System.out.println("- " + emp.getEmployeeName());
        }

        session.close();
        sf.close();
    }
}
