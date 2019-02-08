package com.dhammatorn.Controller;

import com.dhammatorn.Entity.Student;
import com.dhammatorn.Service.StudentService;
import com.dhammatorn.Entity.Register;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Collection;
import java.util.Optional;
import java.util.List;
import javax.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

//Rest deals with HTTP requests and the web - to - database controller
@Controller
//request mapping means it is the end of URL (e.g. /smth)
@RequestMapping("/")
public class StudentController {

    //get all of student service
    @Autowired
    //Autowired means springboot will instantiate the injection automatically
    private StudentService studentService;

    // Login
    @RequestMapping(value={"/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }



    // Admin home
    /*
    @RequestMapping(value="/admin/home", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Student student = studentService.getStudentByUsername(auth.getName());
        modelAndView.addObject("userName", "Welcome " + student.getName() + " " + student.getLastname() + " (" + student.getUsername() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }
    */

    // Updated Registration
    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        Student student = new Student();
        modelAndView.addObject("student", student);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid Student student, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();

        /*
        studentService.saveStudent(student);
        modelAndView.addObject("successMessage", "Student has been registered successfully");
        modelAndView.addObject("student", new Student());
        modelAndView.setViewName("registration");
        */

        int studentExists = studentService.getMaybeStudentByUsername(student.getUsername());
        if (studentExists != 0) {
            bindingResult
                    .rejectValue("username", "error.student",
                            "There is already a user registered with the username provided");
        }

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            studentService.saveStudent(student);
            modelAndView.addObject("successMessage", "Student has been registered successfully");
            modelAndView.addObject("student", new Student());
            modelAndView.setViewName("registration");
        }

        return modelAndView;
    }

    //function to return all students
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public @ResponseBody List<Student> getAllStudent() {
        return studentService.getAllStudent();

    }

    //value /{id} means we are going to pass an id from the URL and this method is going to output
    // a student according to that id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    //Pathvariable means u actually want the id to be the one you send from the url
    public @ResponseBody Student getStudentById(@PathVariable("id") int id) {
        Optional<Student> maybeStudent = studentService.getStudentById(id);
        if (maybeStudent.isPresent()) {
            Student student = maybeStudent.get();
            return student;
        } else {
            //error
            Student student = new Student();
            return student;
        }
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public Student getStudentByUsername() {
        Student student = studentService.getStudentByUsername("jim");
        return student;
    }

    @GetMapping(value = "/{id}/edituser")
    public String edituserForm(Model model, @PathVariable("id") int id) {
        Optional<Student> maybeStudent = studentService.getStudentById(id);
        if (maybeStudent.isPresent()) {
            Student student = maybeStudent.get();
            model.addAttribute("student", student);
        } else {
            //error
        }
        return "edit_users";
    }

    @PutMapping(value = "/{id}/edituser")
    public String edituserSubmit(@ModelAttribute Student student) {
        studentService.updateStudent(student);
        return "editresult";
    }

    // Delete by Id
    @GetMapping(value = "/{id}/deleteuser")
    @ResponseBody
    public String deleteUser(@PathVariable("id") int id){
        studentService.deleteStudentById(id);
        return "Student Deleted";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        return "index";
    }


    // ADMIN PAGES

    @GetMapping(value = "/admin/booking")
    public String adminbooking(){
        return "adminbooking";
    }

    @GetMapping(value = "/admin/manageaccounts")
    public String manageaccounts(){
        return "manage_account";
    }

    //updated display function

    @RequestMapping("/display")
    public String display(Model model){
        model.addAttribute("display", getAllStudent());
        return "display";
    }



    @GetMapping(value = "/equipment")
    public String equipment(){ return "equipment"; }

    @GetMapping(value = "/booking")
    public String booking(){ return "booking"; }

    @GetMapping(value = "/manage_account")
    public String manage_account(){return "manage_account"; }

    @GetMapping(value = "/error")
    public String error(){return "error"; }


}
