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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.security.auth.login.LoginException;
import javax.validation.Valid;
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

    @GetMapping("/length_error")
    public ModelAndView length_error(Tempbooking tempbooking){
        ModelAndView mav = new ModelAndView("bookings/book");
        mav.addObject("error", "Start and End time error");
        return mav;
    }

    @PostMapping("/book")
//    @ResponseBody
    String bookingSubmit(@ModelAttribute @Valid Tempbooking tempbooking,BindingResult bindingResult,RedirectAttributes redirectAttributes,Model model){

        int endTime = tempbooking.getEndTime();
        int length = endTime - tempbooking.getStartTime();

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.createAccountModel", bindingResult);
            redirectAttributes.addFlashAttribute("tempbooking", tempbooking);
            return "booking";

//            return new RedirectView("/bookings/book");
        }
        else if(length <= 0){
            model.addAttribute("error","End time must be after Start time");
            return "booking";
        }
        else {
            Booking booking = new Booking();
            String day = tempbooking.getDay();

            booking.setDay(day);
            booking.setStartTime(tempbooking.getStartTime());
            booking.setEndTime(tempbooking.getEndTime());
            booking.setLength(length);
            booking.setSeatNo(tempbooking.getSeatNo());
            booking.setStudent(tempbooking.getStudent());

            //equipments
            if (tempbooking.getCapacitors() == null) booking.setCapacitors(0);
            else booking.setCapacitors(tempbooking.getCapacitors());

            if (tempbooking.getBnc_Tpiece() == null) booking.setBnc_Tpiece(0);
            else booking.setBnc_Tpiece(tempbooking.getBnc_Tpiece());

            if (tempbooking.getPrototyping_board() == null) booking.setPrototyping_board(0);
            else booking.setPrototyping_board(tempbooking.getPrototyping_board());

            if (tempbooking.getSolidCoreWire() == null) booking.setSolidCoreWire(0);
            else booking.setSolidCoreWire(tempbooking.getSolidCoreWire());

            if (tempbooking.getResistors() == null) booking.setResistors(0);
            else booking.setResistors(tempbooking.getResistors());

            if (tempbooking.getLcr400_bridge() == null) booking.setLcr400_bridge(0);
            else booking.setLcr400_bridge(tempbooking.getLcr400_bridge());

            if (tempbooking.getWire_strippers() == null) booking.setWire_strippers(0);
            else booking.setWire_strippers(tempbooking.getWire_strippers());

            if (tempbooking.getActive8() == null) booking.setActive8(0);
            else booking.setActive8(tempbooking.getActive8());

            if (tempbooking.getOscilloscope_trim() == null) booking.setOscilloscope_trim(0);
            else booking.setOscilloscope_trim(tempbooking.getOscilloscope_trim());

            if (tempbooking.getRsop() == null) booking.setRsop(0);
            else booking.setRsop(tempbooking.getRsop());

            if (tempbooking.getPower_supp() == null) booking.setPower_supp(0);
            else booking.setPower_supp(tempbooking.getPower_supp());

            if (tempbooking.getBnc_croclead() == null) booking.setBnc_croclead(0);
            else booking.setBnc_croclead(tempbooking.getBnc_croclead());

            if (tempbooking.getBnc_lead() == null) booking.setBnc_lead(0);
            else booking.setBnc_lead(tempbooking.getBnc_lead());

            if (tempbooking.getRsop() == null) booking.setRsop(0);
            else booking.setRsop(tempbooking.getRsop());

            int feedback =   bookingService.saveBooking(booking);
            if(feedback == 1) {

                bookingService.sendNotification(booking);
                return "booking_success";
            }
            else{
                return "bookingfailed";
            }

            //return "booking_success";
//        return new RedirectView("/bookings/all");

        }
        }
//        else {
//            return new RedirectView("/bookings/bookingfailed");
//        }
//    }


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

//    @RequestMapping("/user_booking")
//    public String user_booking(Model model){
//        model.addAttribute("admin_all_booking", viewAllBookings());
//        return "admin_all_booking";
//    }

    @GetMapping(value = "/booking_success")
    public String booking_success(){return "booking_success"; }


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
    public RedirectView deleteUser(@PathVariable("id") int id){
//        List<Booking> all_bookings = viewAllBookings();
//        int id;
//        for(Booking temp:all_bookings){
//            if(student == temp.getStudent()) id = temp.getID();
//        }
        bookingService.deleteBookingById(id);
        return new RedirectView("/bookings/admin_all_booking");
    }



}
