package com.dhammatorn.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;


//object in the database
@Entity @Table(name = "student")
public class Student {
    @Id @GeneratedValue @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="lastname")
    private String lastname;

    @Column(name="course")
    private String course;

    @Column(name="email")
    private String email;

    @Column(name="booking")
    private int booking;

    /*
    public Student(String name, String lastname, String course,
                String email, String seatNo, String dateAndTime){
        this.name = name;
        this.lastname = lastname;
        this.course = course;
        this.email = email;
        this.seatNo = seatNo;
        this.dateAndTime = dateAndTime;
    }
    */

    //to automatically create getter and setter click command+N and generate (or Code -> Generate)

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

    public void setBooking(int booking){
        this.booking = booking;
    }

    public int getBooking(){
        return this.booking;
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
