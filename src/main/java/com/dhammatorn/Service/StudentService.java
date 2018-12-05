package com.dhammatorn.Service;

import com.dhammatorn.Dao.StudentDao;
import com.dhammatorn.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
//this is where Buisness logic happens (where database meets web) -- middle ground/layer
public class StudentService {


    //we need a way to access the Dao
    //create an instance of the Dao
    @Autowired
    private StudentDao studentDao;

    public void addStudent(Student student){
        studentDao.addStudent(student);
    }

    //function to return all students
    public Collection<Student> getAllStudent(){
        return studentDao.getAllStudent();

    }

    public Student getStudentById(int id){
        return this.studentDao.getStudentById(id);
    }

    /*
    public void removeStudentById(int id){
        this.studentDao.removeStudentById(id);
    }

    public void updateStudent(Student student){

        this.studentDao.updateStudent(student);
    }
    */

}
