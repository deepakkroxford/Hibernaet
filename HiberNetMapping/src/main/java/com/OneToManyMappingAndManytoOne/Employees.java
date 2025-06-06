package com.OneToManyMappingAndManytoOne;

import jakarta.persistence.*;

@Entity
public class Employees {
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(nullable = false, length = 50)
    private  String employeeName;

    @ManyToOne(cascade = CascadeType.ALL)  // Establishing a many-to-one relationship
    @JoinColumn(name = "department_id")  // This column will be the foreign key in the Employees table
    private DepartMent department;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public DepartMent getDepartment() {
        return department;
    }

    public void setDepartment(DepartMent department) {
        this.department = department;
    }
}
