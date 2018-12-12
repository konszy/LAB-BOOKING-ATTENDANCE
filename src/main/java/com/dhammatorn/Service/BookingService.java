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

    public void saveBooking(Booking booking){
        bookingRepository.save(booking);
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
