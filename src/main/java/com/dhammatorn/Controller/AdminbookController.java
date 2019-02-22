package com.dhammatorn.Controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.dhammatorn.Entity.Adminbooking;
import com.dhammatorn.Entity.Booking;
import com.dhammatorn.Entity.Tempbooking;
import com.dhammatorn.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class AdminbookController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/book")
    public String bookingForm(Model model){
        model.addAttribute("adminbookinfo", new Adminbooking());
        return "adminbooking";
    }

    @GetMapping("/length_error")
    public ModelAndView length_error(Adminbooking tempbooking){
        ModelAndView mav = new ModelAndView("admin/book");
        mav.addObject("error", "Start and End time error");
        return mav;
    }

    @PostMapping("/book")
//    @ResponseBody
    String bookingSubmit(@ModelAttribute @Valid Adminbooking tempbooking, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){

        int endTime = tempbooking.getEndTime();
        int length = endTime - tempbooking.getStartTime();

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.createAccountModel", bindingResult);
            redirectAttributes.addFlashAttribute("adminbookinfo", tempbooking);
            return "adminbooking";

//            return new RedirectView("/bookings/book");
        }
        else if(length <= 0){
            model.addAttribute("error","End time must be after Start time");
            return "adminbooking";
        }
        else {
//            Booking booking = new Booking();
            String day = tempbooking.getDay();
            String[] all_seats = tempbooking.getSeatNo();
//            ArrayList<String> all_seats = tempbooking.getSeatNum();
            for(String each_seats : all_seats) {
                Booking booking = new Booking();
                booking.setDay(day);
                booking.setEndTime(tempbooking.getEndTime());
                booking.setStartTime(tempbooking.getStartTime());
                booking.setLength(length);
                booking.setSeatNo(each_seats);
                booking.setStudent(0);
               int feedback = bookingService.saveBooking(booking);
               if(feedback == 0) return "bookingfailed";
            }

                return "booking_success";
            }

            //return "booking_success";
//        return new RedirectView("/bookings/all");


    }

    @GetMapping(value = "/error")
    public String error(){return "error"; }

    @GetMapping(value = "/bookingfailed")
    public String booking_failed(){return "bookingfailed";}

    @GetMapping(value = "/booking_success")
    public String booking_success(){return "booking_success"; }

}
