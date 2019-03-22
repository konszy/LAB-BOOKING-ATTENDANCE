package com.dhammatorn.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dhammatorn.Dao.BookingRepository;
import com.dhammatorn.Dao.StudentRepository;
import com.dhammatorn.Entity.Student;
import com.dhammatorn.Service.BookingService;
import com.dhammatorn.Service.StudentService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.dhammatorn.Entity.Booking;
import java.util.Optional;


@SpringBootTest
//@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentRepository studentRepository;

    @Test
    public void getAllStudents(){
        List<Student> test_student = new ArrayList<>();
        Student stu1 = new Student();
        stu1.setName("A");
        stu1.setCourse("CS");
        stu1.setActive(1);
        stu1.setBooking(1);
        stu1.setLastname("D");
        stu1.setPassword("abc123");
        stu1.setEmail("a@my.bristol.ac.uk");
        stu1.setUcard("12345");
        stu1.setUsername("abc");

        Student stu2 = new Student();
        stu2.setName("G");
        stu2.setCourse("CS");
        stu2.setActive(1);
        stu2.setBooking(1);
        stu2.setLastname("O");
        stu2.setPassword("bcd345");
        stu2.setEmail("b@my.bristol.ac.uk");
        stu2.setUcard("124455");
        stu2.setUsername("bac");

        test_student.add(stu1);
        test_student.add(stu2);

        Mockito.when(studentRepository.findAll()).thenReturn(test_student);
//        bookingService.saveBooking(temp);
//        List<Booking> bookings = new ArrayList<>();
//        bookingRepository.findAll().forEach(bookings::add);
        assertThat(studentService.getAllStudent()).isEqualTo(test_student);

    }

    @Test
    public void studentGetbyID(){
        Student stu1 = new Student();
        stu1.setName("A");
        stu1.setCourse("CS");
        stu1.setActive(1);
        stu1.setBooking(1);
        stu1.setLastname("D");
        stu1.setPassword("abc123");
        stu1.setEmail("a@my.bristol.ac.uk");
        stu1.setUcard("12345");
        stu1.setUsername("abc");

        Optional<Student> opt_book = Optional.of(stu1);

        Mockito.when(studentRepository.findById(1)).thenReturn(opt_book);
        assertThat(studentService.getStudentById(1)).isEqualTo(opt_book);
    }

    /** if you change saveStudent function to return Student instead of void, this test will work **/
//    @Test
//    public void createStudent(){
//        Student stu1 = new Student();
//        stu1.setName("A");
//        stu1.setCourse("CS");
//        stu1.setActive(1);
//        stu1.setBooking(1);
//        stu1.setLastname("D");
//        stu1.setPassword("abc123");
//        stu1.setEmail("a@my.bristol.ac.uk");
//        stu1.setUcard("12345");
//        stu1.setUsername("abc");
//
//        Optional<Student> opt_book = Optional.of(stu1);
//
//        Mockito.when(studentRepository.save(stu1)).thenReturn(stu1);
//        assertThat(studentService.saveStudent(stu1)).isEqualTo(stu1);
//
//
//    }

    @Test
    public void getStudentbyUsername(){
        List<Student> list_all = new ArrayList<>();

        Student stu1 = new Student();
        stu1.setName("A");
        stu1.setCourse("CS");
        stu1.setActive(1);
        stu1.setBooking(1);
        stu1.setLastname("D");
        stu1.setPassword("abc123");
        stu1.setEmail("a@my.bristol.ac.uk");
        stu1.setUcard("12345");
        stu1.setUsername("abc");
        list_all.add(stu1);
        Optional<Student> opt_book = Optional.of(stu1);
        Mockito.when(studentRepository.findByUsername(stu1.getUsername())).thenReturn(list_all);
        assertThat(studentService.getStudentByUsername(stu1.getUsername())).isEqualTo(stu1);
    }

    @Test
    public void getStudentSizebyUsername(){
        List<Student> list_all = new ArrayList<>();

        Student stu1 = new Student();
        stu1.setName("A");
        stu1.setCourse("CS");
        stu1.setActive(1);
        stu1.setBooking(1);
        stu1.setLastname("D");
        stu1.setPassword("abc123");
        stu1.setEmail("a@my.bristol.ac.uk");
        stu1.setUcard("12345");
        stu1.setUsername("abc");
        list_all.add(stu1);
        Optional<Student> opt_book = Optional.of(stu1);
        Mockito.when(studentRepository.findByUsername(stu1.getUsername())).thenReturn(list_all);
        assertThat(studentService.getMaybeStudentByUsername(stu1.getUsername())).isEqualTo(1);
    }

    @Test
    public void getStudentbyUCARDtest(){
        List<Student> list_all = new ArrayList<>();

        Student stu1 = new Student();
        stu1.setName("A");
        stu1.setCourse("CS");
        stu1.setActive(1);
        stu1.setBooking(1);
        stu1.setLastname("D");
        stu1.setPassword("abc123");
        stu1.setEmail("a@my.bristol.ac.uk");
        stu1.setUcard("12345");
        stu1.setUsername("abc");
        list_all.add(stu1);
        Optional<Student> opt_book = Optional.of(stu1);
        Mockito.when(studentRepository.findByUcard(stu1.getUcard())).thenReturn(list_all);
        assertThat(studentService.getStudentByUcard(stu1.getUcard())).isEqualTo(stu1);
    }
}
