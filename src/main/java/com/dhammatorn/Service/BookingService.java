package com.dhammatorn.Service;

import com.dhammatorn.Dao.BookingRepository;
import com.dhammatorn.Entity.Booking;
import com.dhammatorn.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;



import java.util.Collection;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    public BookingRepository bookingRepository;

    public int saveBooking(Booking booking){
        //check if there is any booking on the same date
        List<Booking> bookings = new ArrayList<>();
        bookingRepository.findAll().forEach(bookings::add);
        Boolean booked = false;
        for(Booking temp: bookings){
            if(temp.getSeatNo().equals(booking.getSeatNo())
                    && temp.getDateAndTime().equals(booking.getDateAndTime())
                    && temp.getLength() == temp.getLength()){
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