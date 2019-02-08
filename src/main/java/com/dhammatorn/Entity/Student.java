package com.dhammatorn.Entity;

import lombok.Data;

import javax.persistence.*;
import org.hibernate.validator.constraints.Length;
import java.util.Set;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


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

    @Column(name="username") @NotNull @NotEmpty @Size(min=2, max=30)
    private String username;

    @Column(name="password") @NotNull @NotEmpty @Size(min=2, max=30)
    private String password;

    @Column(name = "active")
    private int active;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @Column(name="booking")
    private int booking;


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

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }


}
