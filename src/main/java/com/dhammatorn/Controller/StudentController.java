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

//Rest deals with HTTP requests and the web - to - database controller
@Controller
//request mapping means it is the end of URL (e.g. /smth)
@RequestMapping("/")
public class StudentController {

    //get all of student service
    @Autowired
    //Autowired means springboot will instantiate the injection automatically
    private StudentService studentService;

    // Registering
    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("student", new Student());
        return "register";
    }

    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute Student student) {
        studentService.addStudent(student);
        return "result";
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
