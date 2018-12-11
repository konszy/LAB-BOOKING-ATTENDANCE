package com.dhammatorn.Dao;

import com.dhammatorn.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

//telling spring that this is a repository for us
//spring instantiates spring beans for us without us telling it manually

@Repository
//Dao is database - the backend code
public class StudentDao {

    //key is the student id
    //and the actual student object
    @Autowired
    public Student_interface student_interface;

    public void addStudent(Student student){
       student_interface.save(student);
    }

    //function to return all students
    public List<Student> getAllStudent(){
        List<Student> students = new ArrayList<>();
        student_interface.findAll().forEach(students::add);
        return students;
    }

    //function to get Student by ID
    //copy this to service to connect them
    public Optional<Student> getStudentById(int id){
        return student_interface.findById(id);
    }

    public void updateStudent(Student student){
        student_interface.save(student);
    }


    // Delete a student by using a given ID
    public void deleteStudentById(int id) {
        student_interface.deleteById(id);
    }



}
