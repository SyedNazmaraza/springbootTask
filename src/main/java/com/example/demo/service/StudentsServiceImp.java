package com.example.demo.service;

import com.example.demo.entity.Guardian;
import com.example.demo.entity.Student;
import com.example.demo.model.StudentsRequest;
import com.example.demo.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsServiceImp implements StudentsService {

    @Autowired
    private StudentsRepository studentsRepository;

    public Student saveStudent(StudentsRequest request) {
        Student students = Student.build(
                1L,
                request.getFirstName(),
                request.getLastName(),
                request.getEmailId(),
                Guardian.builder()
                        .name(request.getGuardian().getName())
                        .email(request.getGuardian().getEmail())
                        .mobile(request.getGuardian().getMobile())
                        .build()
        );
        return studentsRepository.save(students);
    }

    @Override
    public List<Student> getStudents() {
        return studentsRepository.findAll();
    }
}
