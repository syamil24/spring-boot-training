package com.example.demo.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// This is Data Access Layer
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // SELECT * FROM student WHERE email =?
    @Query("SELECT s FROM Student s WHERE s.email = ?1") // Student here from student class, not from db
    Optional<Student> findStudentByEmail(String email);

}
