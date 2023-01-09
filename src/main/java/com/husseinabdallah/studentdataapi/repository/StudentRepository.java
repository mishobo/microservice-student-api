package com.husseinabdallah.studentdataapi.repository;

import com.husseinabdallah.studentdataapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "SELECT * FROM students s where s.student_id = :studentId", nativeQuery = true)
    Student findByIdNative (Long studentId);

}
