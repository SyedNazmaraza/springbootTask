package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.model.StudentsRequest;
import com.example.demo.service.StudentsServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private StudentsServiceImp studentsService;

    @PostMapping("/save")
    public ResponseEntity<Student> save(@RequestBody @Valid StudentsRequest studentsRequest) {
        Student response = studentsService.saveStudent(studentsRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAll() {
        List<Student> response = studentsService.getStudents();
        return ResponseEntity.ok(response);
    }
}
