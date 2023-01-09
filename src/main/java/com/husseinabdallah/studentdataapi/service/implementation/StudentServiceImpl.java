package com.husseinabdallah.studentdataapi.service.implementation;

import com.husseinabdallah.studentdataapi.model.College;
import com.husseinabdallah.studentdataapi.model.ResponseData;
import com.husseinabdallah.studentdataapi.model.Student;
import com.husseinabdallah.studentdataapi.repository.StudentRepository;
import com.husseinabdallah.studentdataapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private WebClient.Builder webClient;

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public ResponseEntity<ResponseData> getStudentById(Long studentId) {
        ResponseData response = new ResponseData();
        Student student = new Student();
        student.setStudentId(1L);
        student.setStudentName("HUSSEIN ABDALLAH MISHOBO");
        student.setAddress("NAIROBI, Kabiria");
        student.setCollegeId(1L);

        response.setStudent(student);

        Long collegeId = student.getCollegeId();

//        RestTemplate
        RestTemplate restTemplate = new RestTemplate();
        String endpoint = "http://localhost:8081/college/{collegeId}";

        ResponseEntity<College> data = restTemplate.getForEntity(endpoint, College.class, collegeId);
        if(data.getStatusCodeValue() == 200){
            College c1 = data.getBody();
            response.setCollege(c1);
        }
        return new ResponseEntity<ResponseData>(response, HttpStatus.OK);
    }


    @Override
    public ResponseEntity<ResponseData> getStudentById1(Long studentId) {
        ResponseData response = new ResponseData();
        Student s1 = studentRepository.findByIdNative(studentId);
        response.setStudent(s1);

        Long collegeId = s1.getCollegeId();

//      WebClient
        College c1 = webClient.build()
                .get()
                .uri("http://localhost:8081/college/"+collegeId)
                .retrieve()
                .bodyToMono(College.class)
                .block();


        response.setCollege(c1);

        return new ResponseEntity<ResponseData>(response, HttpStatus.OK);
    }
}
