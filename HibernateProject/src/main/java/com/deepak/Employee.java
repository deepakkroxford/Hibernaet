package com.deepak;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    @Column(name = "emp_id")
    private int id;

    @Column(name = "emp_name") // if you want to change the column name in the database then you can use this annotation
    private String name;

    private String grade;
    private String address;
    private String email;
    private int age;

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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {

        if (grade.equals("A") || grade.equals("B") || grade.equals("C")) {
            this.grade = grade;
        } else {
            this.grade = "A";
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

}
