package com.husseinabdallah.studentdataapi.dto;

import lombok.Data;

@Data
public class StudentDTO {
    private Long studentId;
    private String studentName;
    private String address;
    private Long collegeId;
}
