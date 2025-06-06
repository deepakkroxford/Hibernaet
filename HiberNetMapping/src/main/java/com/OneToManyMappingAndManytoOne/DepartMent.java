package com.OneToManyMappingAndManytoOne;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class DepartMent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private  int id;

    @Column(nullable = false, length = 50)
    private  String departmentName;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    List<Employees> employeesList;

    public List<Employees> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(List<Employees> employeesList) {
        this.employeesList = employeesList;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
