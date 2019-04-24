package com.dhammatorn;

import com.dhammatorn.Entity.Booking;
import com.dhammatorn.Entity.Student;
import com.dhammatorn.Service.BookingService;
import com.dhammatorn.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TimerTask;
import java.time.LocalDateTime;

public class AutoAttendance extends TimerTask {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private StudentService studentService;

    public void run() {
        List<Booking> all_bookings = bookingService.getAllBookings();
        List<Booking> not_attended = new ArrayList<>();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime now = LocalDateTime.now(zone);

        for(Booking temp : all_bookings){
            if(temp.getAttendance() != Boolean.TRUE && temp.getStartTime().isAfter(now)){
                not_attended.add(temp);
            }
        }
        for(Booking temp : not_attended){
            Optional<Student> opt = studentService.getStudentById(temp.getStudent());
            Student striked = opt.get();
            int strikes = striked.getStrikes() + 1;
            striked.setStrikes(strikes);
            studentService.updateStudentStrikesByID(striked);

            Booking update = temp;
            update.setAuto_checked(true);
            bookingService.updateBookingwithAttendance(update);

        }
    }
}
