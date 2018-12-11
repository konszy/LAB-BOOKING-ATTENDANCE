package com.dhammatorn.Service;

import com.dhammatorn.Dao.StudentDao;
import com.dhammatorn.Entity.Student;
import com.dhammatorn.Dao.Student_interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import com.dhammatorn.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Service
//this is where Buisness logic happens (where database meets web) -- middle ground/layer
public class StudentService {


    //we need a way to access the Dao
    //create an instance of the Dao
    @Autowired
    public Student_interface studentRepository;
    public void addStudent(Student student){
       studentRepository.save(student);
    }

    //function to return all students
    public List<Student> getAllStudent(){
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    //function to get Student by ID
    //copy this to service to connect them
    public Optional<Student> getStudentById(int id){
        return studentRepository.findById(id);
    }

    public void updateStudent(Student student){
        studentRepository.save(student);
    }

    // Delete a student by using a given ID
    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }


}
