package com.ManayToManyMapping;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Emp {
    @Id
    private int eid;
    @Column(name = "emp_name", length = 50)
    private String name;

    @ManyToMany
    @JoinTable(name="emp_learn",
            joinColumns = @JoinColumn(name="emp_id"), // using this we can change the name of the column in the emp_learn table
            inverseJoinColumns = @JoinColumn(name="p_id"))
    private List<Project> project = new ArrayList<>();
    

    public Emp(int id, String name , List<Project> project) {
        super();
        this.eid = id;
        this.name = name;
        this.project = project;
    }



    public Emp() {
        //TODO Auto-generated constructor stub
    }



    public List<Project> getProject() {
        return project;
    }
    public void setProject(List<Project> project) {
        this.project = project;
    }

    public int getEid() {
        return eid;
    }
    public void setEid(int eid) {
        this.eid = eid;
    }
    public String getEmp_name() {
        return name;
    }
    public void setEmp_name(String name) {
        this.name = name;
    }
}
