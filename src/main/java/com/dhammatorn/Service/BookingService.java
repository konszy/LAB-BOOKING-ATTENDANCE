package com.dhammatorn.Service;

import com.dhammatorn.Dao.BookingRepository;
import com.dhammatorn.Entity.Booking;
import com.dhammatorn.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;



import java.util.Collection;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

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

    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();
        int id = 1;
        students.add(bookingRepository.getStudentById(id));
        return students;
    }

    public List<Booking> getAllBookings(){
        List<Booking> bookings = new ArrayList<>();
        bookingRepository.findAll().forEach(bookings::add);
        return bookings;
    }

}
