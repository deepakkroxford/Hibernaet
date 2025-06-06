package com.ManayToManyMapping;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Project {

    @Id
    private int pid;
    @Column(name = "project_name", length = 50)
    private String projectName;

    @ManyToMany(mappedBy = "project")
    private List<Emp> emp = new ArrayList<>();

    public Project(int pid, String projectName, List<Emp> emp) {
        super();
        this.pid = pid;
        this.projectName = projectName;
        this.emp = emp;   
    }


    public Project() {
        //TODO Auto-generated constructor stub
    }


    public List<Emp> getEmp() {
        return emp;
    }
    public void setEmp(List<Emp> emp) {
        this.emp = emp;
    }

    public int getPid() {
        return pid;
    }
    public void setPid(int pid) {
        this.pid = pid;
    }
    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


}
