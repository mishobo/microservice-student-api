package com.husseinabdallah.studentdataapi.controller;

import com.husseinabdallah.studentdataapi.model.College;
import com.husseinabdallah.studentdataapi.model.ResponseData;
import com.husseinabdallah.studentdataapi.model.Student;
import com.husseinabdallah.studentdataapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Student addStudent(@RequestBody Student student){

        ResponseData responseData = new ResponseData();
        student.setCollegeId(23L);

        Long collegeId = student.getCollegeId();
        RestTemplate restTemplate = new RestTemplate();
        String endpoint = "http://localhost:8082/student/getStudentById/{collegeId}";

        ResponseEntity<College> data = restTemplate.getForEntity(endpoint, College.class, collegeId);
        if(data.getStatusCodeValue() == 200){
            College c1 = data.getBody();
            responseData.setCollege(c1);
        }
    return studentService.addStudent(student);
    }

    @RequestMapping(value = "/getStudentById/{studentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData> getStudentById(@PathVariable("studentId") Long studentId){
        return studentService.getStudentById1(studentId);
    }

}
