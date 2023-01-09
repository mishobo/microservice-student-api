package com.husseinabdallah.studentdataapi.service;

import com.husseinabdallah.studentdataapi.model.ResponseData;
import com.husseinabdallah.studentdataapi.model.Student;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface StudentService {

    public Student addStudent(Student student);
    public ResponseEntity<ResponseData> getStudentById(Long studentId);
    public ResponseEntity<ResponseData> getStudentById1(Long studentId);
}
