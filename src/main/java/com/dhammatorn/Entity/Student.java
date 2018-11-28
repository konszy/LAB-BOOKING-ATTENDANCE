package com.dhammatorn.Entity;


//object in the database
public class Student {
    private int id;
    private String name;
    private String course;
    private String email;
    private String lastname;

    public Student(int id, String name, String course, String lastname, String email){
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.course = course;
        this.email = email;
    }

    //to automatically create getter and setter click command+N and generate (or Code -> Generate)

    public Student(){}

    public int getId() {
        return id;
    }

    public String getCourse() {
        return course;
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

    public void setCourse(String course) {
        this.course = course;
    }


}