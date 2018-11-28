package com.dhammatorn.Entity;


//object in the database
public class Student {
    private int id;
    private String name;
    private String course;
    private String email;
    private String lastname;
    private String seatNo;
    private String dateAndTime;

    /*
    public Student(int id, String name, String lastname, String course,
                String email, String seatNo, String dateAndTime){
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.course = course;
        this.email = email;
        this.seatNo = seatNo;
        this.dateAndTime = dateAndTime;
    }
    */

    //to automatically create getter and setter click command+N and generate (or Code -> Generate)

    public Student(){}

    public int getId() {
        return this.id;
    }

    public String getCourse() {
        return this.course;
    }

    public void setId(int id) {
        this.id = id;
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
