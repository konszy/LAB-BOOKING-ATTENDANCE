package com.dhammatorn.Controller;
import com.dhammatorn.Entity.Booking;
import com.dhammatorn.Entity.Student;
import com.dhammatorn.Entity.Tempbooking;
import com.dhammatorn.Service.BookingService;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@Controller
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/book")
    public String bookingForm(Model model){
        model.addAttribute("tempbooking", new Tempbooking());
        return "booking";
    }

    @PostMapping("/book")
    @ResponseBody
    public RedirectView bookingSubmit(@ModelAttribute Tempbooking tempbooking){
        Booking booking = new Booking();
        String day = tempbooking.getDay();
        booking.setDateAndTime(day + ":" + tempbooking.getStartTime());
        int endTime = Integer.parseInt(tempbooking.getEndTime());
        int length = endTime - Integer.parseInt(tempbooking.getStartTime());
        booking.setLength(length);
        booking.setSeatNo(tempbooking.getSeatNo());
        booking.setStudent(tempbooking.getStudent());
        int feedback = bookingService.saveBooking(booking);
        if (feedback == 1) return new RedirectView("/");
        else return new RedirectView("/bookings/bookingfailed");
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Booking> viewAllBookings(){
        return bookingService.getAllBookings();
    }

    @GetMapping(value = "/error")
    public String error(){return "error"; }

    @GetMapping(value = "/bookingfailed")
    public String booking_failed(){return "bookingfailed";}



}
