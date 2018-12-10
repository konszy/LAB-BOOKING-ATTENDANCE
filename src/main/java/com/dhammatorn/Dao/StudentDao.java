package com.dhammatorn.Dao;

import com.dhammatorn.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//telling spring that this is a repository for us
//spring instantiates spring beans for us without us telling it manually

@Repository
//Dao is database - the backend code
public class StudentDao {

    //key is the student id
    //and the actual student object
    private Map<Integer, Student> students = new HashMap<Integer, Student>();

    @Autowired
    public Student_interface student_interface;

    public void addStudent(Student student){
       student_interface.save(student);
    }

    //function to return all students
    public Collection<Student> getAllStudent(){
        return student_interface.findAll();
    }

    //function to get Student by ID
    //copy this to service to connect them
    public Student getStudentById(int id){
        return student_interface.getStudentById(id);
    }

    /*
    // Delete a student by using a given ID
    public void deleteStudentById(int id) {
        student_interface.deleteStudentById(id);
    }

    /*
    //update student
    public void updateStudent(int id){
        Student s = getStudentById();
        s.setCourse(student.getCourse());
        s.setName(s.getName());
        student_interface.save(student);
    }

    */

}
