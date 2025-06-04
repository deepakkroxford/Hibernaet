package com.anotation;

import jakarta.persistence.*;
import java.util.Date;


@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private  int id;

    @Column(length = 40, nullable = false)
    private String name;

    @Column(length = 15, nullable = false)
    private String subject;

    @Column(length = 25, name = "email_address", unique = true)
    private String email;

    @Column(nullable = false)
    private int age;

    @Column(length = 50,nullable = false)
    private String address;

    @Column(nullable = false)
    private String grade;

    @Transient   // This field will not be persisted in the database
    private double x;

    @Temporal(TemporalType.DATE)
    private Date addedDate;







    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }
}


