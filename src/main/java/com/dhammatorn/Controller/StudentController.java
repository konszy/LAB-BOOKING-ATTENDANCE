package com.dhammatorn.Controller;

import com.dhammatorn.Entity.Student;
import com.dhammatorn.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Collection;

//Rest deals with HTTP requests and the web - to - database controller
@RestController
//request mapping means it is the end of URL (e.g. /smth)
@RequestMapping("/students")
public class StudentController {

    //get all of student service
    @Autowired
    //Autowired means springboot will instantiate the injection automatically
    private StudentService studentService;

    //define the HTTP that this is a GET method
    @RequestMapping(method = RequestMethod.GET)
    //function to return all students
    public Collection<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    //value /{id} means we are going to pass an id from the URL and this method is going to output
    // a student according to that id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    //Pathvariable means u actually want the id to be the one you send from the url
    public Student getStudentById(@PathVariable("id") int id) {
        return studentService.getStudentById(id);
    }


    //delete student function
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteStudentById(@PathVariable("id") int id) {
        studentService.removeStudentById(id);
    }


    //handle student update function
    //consumes tells the springboot to consume a JSON value sent by the function
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    //Request Body is requesting the student parameter
    public void updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
    }



}
