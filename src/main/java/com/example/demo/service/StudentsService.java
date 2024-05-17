package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.model.StudentsRequest;

import java.util.List;

public interface StudentsService {
    Student saveStudent(StudentsRequest request);
    List<Student> getStudents();
}
