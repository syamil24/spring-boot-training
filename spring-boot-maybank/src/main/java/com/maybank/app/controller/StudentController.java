package com.maybank.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import javax.print.attribute.standard.Media;

import com.maybank.app.dto.Student;
import com.maybank.app.repository.StudentRepository;

@RequestMapping("/student") // automatically added /student for path in all function
@RestController
public class StudentController {

    @Autowired
    StudentRepository repository;

    @GetMapping(path = "/list")
    public Iterable<Student> display() {
        // Student student = new Student();
        // student.setId(1);
        // student.setFirstName("Syamil");
        // student.setLastName("Ahmad");
        // student.setAge("20");

        Iterable<Student> students = repository.findAll();
        return students;
    }

    // spring boot parses the json string
    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Student save(@RequestBody Student student) { // take body parameters
        // json string will be converted to an object
        repository.save(student);
        System.out.println(student);
        return student;
    }
}
