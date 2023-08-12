package com.maybank.app.repository;

import java.util.List;

import com.maybank.app.dto.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public List<Employee> findByName(String name);

    public List<Employee> findByDesignation(String designation);

    public List<Employee> findByNameAndDesignation(String name, String designation);

    public List<Employee> findByNameOrDesignation(String name, String designation);
}
