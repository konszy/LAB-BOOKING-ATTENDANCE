package com.dhammatorn.Service;

import com.dhammatorn.Dao.BookingRepository;
import com.dhammatorn.Entity.Booking;
import com.dhammatorn.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.management.Notification;
import java.util.List;
import java.util.ArrayList;



import java.util.Collection;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    public BookingRepository bookingRepository;

    private JavaMailSender javaMailSender;

    @Autowired
    public BookingService(JavaMailSender javaMailSender){
                this.javaMailSender = javaMailSender;
    }

    public void sendNotification(Booking booking) throws MailException

    {
        //send email
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("ee.lab.system@gmail.com");
        mail.setFrom("ee.lab.system@gmail.com");
        mail.setSubject("Booking Success!");
        mail.setText("You currently booked on : " + booking.getDateAndTime() + ":00 with seats : " + booking.getSeatNo() +
        " __for " + booking.getLength() + " hr(s)." + " Please bring your UCARD " +
                        "and scan the system before using the lab. There will be penalities for not being present as " +
                        "in agreement and will result in your account being blacklisted."
        );

        javaMailSender.send(mail);

    }

    public int saveBooking(Booking booking){
        //check if there is any booking on the same date
        List<Booking> bookings = new ArrayList<>();
        bookingRepository.findAll().forEach(bookings::add);
        Boolean booked = false;
        for(Booking temp: bookings){
            if((temp.getSeatNo().equals(booking.getSeatNo())
                    && temp.getDateAndTime().equals(booking.getDateAndTime())
                    && temp.getLength() == booking.getLength()
                    ) || temp.getStudent() == booking.getStudent()){
                booked = true;
            }
        }

        if(booked == false) {
            bookingRepository.save(booking);
            return 1;
        }
        else {
            return 0;
        }
    }


    public List<Booking> getAllBookings(){
        List<Booking> bookings = new ArrayList<>();
        bookingRepository.findAll().forEach(bookings::add);
        return bookings;
    }


    // Delete a booking by using a given ID
    public void deleteBookingById(int id) {
        bookingRepository.deleteById(id);
    }



    //function to get Student by ID
    //copy this to service to connect them
    public Optional<Booking> getBookingById(int id){
        return bookingRepository.findById(id);
    }


}