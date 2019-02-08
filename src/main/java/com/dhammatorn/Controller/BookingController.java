package com.dhammatorn.Controller;
import com.dhammatorn.Entity.Booking;
import com.dhammatorn.Entity.Student;
import com.dhammatorn.Entity.Tempbooking;
import com.dhammatorn.Service.BookingService;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;


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
        if (feedback == 1){
//            try {
//                bookingService.sendNotification(booking);
//            }
//            catch (MailException e){
//
//            }
            return new RedirectView("/");
        }
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

    @RequestMapping("/admin_all_booking")
    public String display(Model model){
        model.addAttribute("admin_all_booking", viewAllBookings());
        return "admin_all_booking";
    }


    //value /{id} means we are going to pass an id from the URL and this method is going to output
    // a student according to that id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    //Pathvariable means u actually want the id to be the one you send from the url
    public @ResponseBody Booking getBookingById(@PathVariable("id") int id) {
        Optional<Booking> maybeBooking = bookingService.getBookingById(id);
        if (maybeBooking.isPresent()) {
            Booking student = maybeBooking.get();
            return student;
        } else {
            //error
            Booking student = new Booking();
            return student;
        }
    }

    // Delete by Id
    @GetMapping(value = "/{id}/dlt")
    @ResponseBody
    public String deleteUser(@PathVariable("id") int id){
//        List<Booking> all_bookings = viewAllBookings();
//        int id;
//        for(Booking temp:all_bookings){
//            if(student == temp.getStudent()) id = temp.getID();
//        }
        bookingService.deleteBookingById(id);
        return "Booking Deleted";
    }



}
