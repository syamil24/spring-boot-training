package com.maybank.app.repository;

import com.maybank.app.dto.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    // integer indicates the primary key data type }
}