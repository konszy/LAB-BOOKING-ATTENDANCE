package com.dhammatorn.Dao;

import com.dhammatorn.Entity.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Student_interface extends CrudRepository<Student,Integer>{

    //@Query("SELECT u FROM Student u WHERE u.id = :id")
    //public Student getStudentById(@Param("id") int id);

    //@Modifying(clearAutomatically = true, flushAutomatically = true)
    //@Query("UPDATE Student SET name = :name WHERE id = :id")
    //public Student updateStudentById(@Param("id") int id, @Param("name") String name);

    //@Query("DELETE Student u WHERE u.id = :id")
    //public Student deleteStudentById(@Param("id") int id);


}
