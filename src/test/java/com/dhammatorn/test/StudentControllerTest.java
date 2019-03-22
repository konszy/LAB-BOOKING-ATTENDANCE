package com.dhammatorn.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dhammatorn.Controller.StudentController;
import com.dhammatorn.Entity.Student;
import com.dhammatorn.Service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value=StudentController.class,secure = false)

public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    StudentService studentService;

    @Test
    public void testshowAllstudent() throws Exception {
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
        Mockito.when(studentService.getAllStudent()).thenReturn(test_student);
        String URI = "/students";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                URI).accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expectedJson = this.mapToJson(test_student);
        String outputInJson = result.getResponse().getContentAsString();
        assertThat(outputInJson).isEqualTo(expectedJson);
    }

    @Test
    public void testCgetStudentbyID() throws Exception{

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

        Mockito.when(studentService.getStudentById(Mockito.anyInt())).thenReturn(opt_book);
        String URI = "/1";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                URI).accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expectedJson = this.mapToJson(stu1);
        String outputInJson = result.getResponse().getContentAsString();
        assertThat(outputInJson).isEqualTo(expectedJson);
    }
    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }

}
