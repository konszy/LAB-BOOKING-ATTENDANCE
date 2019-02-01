package com.dhammatorn.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity @Table(name = "booking")
public class Booking {
    @Id @GeneratedValue @Column(name="id")
    private int id;

    @Column(name="seatNo")
    private String seatNo;

    @Column(name="dateAndTime")
    private String dateAndTime;

    @Column(name="length")
    private int length;

    @Column(name="student")
    private int student;

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

    public void setLength(int length){
        this.length = length;
    }

    public int getLength(){
        return this.length;
    }

    public void setStudent(int student){
        this.student = student;
    }

    public int getStudent(){
        return this.student;
    }

    public int getId() {
        return id;
    }

}
