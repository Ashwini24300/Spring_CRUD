package com.example.demo.Service;

import com.example.demo.entity.Student;

public interface StudentService {
    Student getStudentDetails(Long id) throws Exception;
    String registerStudentDetails(Student student);
    String updateStudentDetails(Student student);
    String deleteStudentEntry(Long studentId);
}
