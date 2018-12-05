package com.dhammatorn.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;


//object in the database
@Entity @Table(name = "student")
public class Student {

    @Id @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="lastname")
    private String lastname;

    @Column(name="course")
    private String course;

    @Column(name="email")
    private String email;

    @Column(name="seatNo")
    private String seatNo;

    @Column(name="dateAndTime")
    private String dateAndTime;


    // Getters and Setters
    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public String getCourse() {
        return this.course;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setSeatNo(String seatNo){
        this.seatNo = seatNo;
    }

    public String getSeatNo(){
        return this.seatNo;
    }

    public void setDateAndTime(String dateAndTime){
        this.dateAndTime = dateAndTime;
    }

    public String getDateAndTime(){
        return this.dateAndTime;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public String getLastname(){
        return this.lastname;
    }


}
