package com.example.demo.studentRegistry;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dep_seq" )
    @SequenceGenerator(sequenceName =  "dep_seq", name = "dep_seq", allocationSize = 1)
    private Integer id;

    private String depname;

    @OneToMany(mappedBy = "department")
    @JsonBackReference
    private List<Student> student;

    Department(){

    }

    public Department(Integer id, String depname){
        this.id = id;
        this.depname = depname;
    }

    public Department(String depname){ 
        this.depname = depname;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getDepname(){
        return depname;
    }

    public void setDepname(String depname){
        this.depname= depname;
    }

    public String toString(){
        return " Department [  Id = " + id + ", depname = " + depname +" ]";
    }




}
