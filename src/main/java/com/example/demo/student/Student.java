package com.example.demo.student;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table
public class Student {

    @Id

    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "studentsequence",
        allocationSize = 1
    )

    @GeneratedValue( 
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"

        )
    private Long Id;
    private String name; 
    private String email;
    private LocalDate Dob;
    @Transient
    private int age;


    public Student(){

    }

    public Student(Long Id, String name, String email, LocalDate Dob ){
        this.Id = Id;
        this.name = name;
        this.email = email;
        this.Dob = Dob;
    }

    public Student(String name, String email, LocalDate Dob){
        
        this.name = name;
        this.email = email;
        this.Dob = Dob;
    }

    public Long getId(){
        return Id;
    }

    public void setId(Long Id){
        this.Id = Id;
    }

    public String getName(){ 
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return Dob;
    }
  
    public void setDob(LocalDate dob) {
        Dob = dob;
    }

    public int getAge() {
        return Period.between(this.Dob,LocalDate.now()).getYears();
    }

    // public void setAge(int age) {
    //     this.age = age;
    // }

    @Override
    public String toString() {
        return "Student [Id=" + Id + ", name=" + name + ", email=" + email + ", Dob=" + Dob + ", age=" + age + "]";
    }

   

    }



