package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class StudentsRepositoryTest {
    @Autowired
    private StudentsRepository studentsRepository;

    @Test
    public void saveStudents() {
        Students students = Students.build(1, "arjun", "syed", "syed.n@gmail.com", "gopal","gopal.n@gmail.com","9565326584514");
        studentsRepository.save(students);


    }

}