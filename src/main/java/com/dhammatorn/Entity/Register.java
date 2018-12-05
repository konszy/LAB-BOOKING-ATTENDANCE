package com.dhammatorn.Entity;

public class Register {

    private String name;
    private String lastname;
    private String course;
    private String email;

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getLastname(){
        return this.lastname;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public String getCourse(){
        return this.course;
    }

    public void setCourse(String course){
        this.course = course;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

}
