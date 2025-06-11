package com.FirstLevel_Caching;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Configuration config = new Configuration();
        config.addAnnotatedClass(Car.class);
        config.configure(); // it will look for the hibernate.cfg.xml file in the classPath.

        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();

        // for selecting
        String query = "From Car where id =: 1";
       Query query1 = session.createQuery(query, Car.class); // This will return a query object that can be used to execute the query
       List<Car> carsList = query1.list(); // This will return a list of cars from the database
       for(Car car: carsList ){
           System.out.println(car);
       }

//        String where = "From Car where price > :minPrice and price < :maxPrice";
//        Query<Car> query2 = session.createQuery(where, Car.class);
//        query2.setParameter("minPrice", 583202);
//        query2.setParameter("maxPrice", 999999);
//        List<Car> carPriceList = query2.list();
//        for (Car car : carPriceList) {
//            System.out.println(car);
//
//
//        }


        // for grouping
       String grouping = "select c.brand, count(c) from Car c group by c.brand";
       Query<Object[]> query2 = session.createQuery(grouping, Object[].class);
       List<Object[]> results = query2.list();
       for (Object[] row : results) {
           System.out.println("Brand: " + row[0] + ", Count: " + row[1]);
       }



        Transaction t = session.beginTransaction();

        // for delete
       String delete = "delete from Car c where c.brand = :brand";
       Query query3 = session.createQuery(delete);
       query3.setParameter("brand", "brand1");
       int x = query3.executeUpdate();

       if (x > 0) {
           System.out.println("the data is deleted");
       } else {
           System.out.println("the data is not deleted");
       }

       //for update
        String update = "update Car c set c.brand = :b where c.id = :i";
        Query query4 = session.createQuery(update);
        query4.setParameter("b", "Mahendra Tractor");
        query4.setParameter("i", 3);
        int y =  query4.executeUpdate();
        if (y > 0) {
            System.out.println("updated");
        } else {
            System.out.println("not updated");
        }


        t.commit(); // save the changes to the database
        session.close();


    }
}