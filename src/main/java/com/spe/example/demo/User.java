package com.spe.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;


@Entity @Table(name = "user")
public class User {
    @Id @GeneratedValue @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

}
