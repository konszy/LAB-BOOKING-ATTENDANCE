package com.dhammatorn.Dao;

import com.dhammatorn.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Student_interface extends JpaRepository<Student,Integer>{

    @Query("SELECT u FROM Student u WHERE u.id = :id")
    public Student getStudentById(@Param("id") int id);


}
