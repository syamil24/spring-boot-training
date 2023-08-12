package com.maybank.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.maybank.app.dto.Employee;
import com.maybank.app.repository.EmployeeRepository;

@RequestMapping("/employee")
@RestController
public class EmployeeController {

	@Autowired // spring will create the object for this class
	EmployeeRepository repository;

	@PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody Employee employee) {
		repository.save(employee);
		System.out.println("Employee details" + employee.toString());
	}

	@GetMapping("/list")
	public Iterable<Employee> list() {
		return repository.findAll();
	}

	@GetMapping("/find")
	public Employee find(@RequestParam("id") int id) {
		Optional<Employee> emp = repository.findById(id); // Optional is more like a wrapper
		return emp.get();
	}

	// if the id doesnt match, it will create a new one instead of update it
	@PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE) // for update purpose
	public void update(@RequestBody Employee employee) {
		repository.save(employee);
	}

	@DeleteMapping("/delete")
	public void delelte(@RequestParam("id") int id) {
		repository.deleteById(id);
	}

	@GetMapping("/customfind")
	public List<Employee> findByNameOrDesignation(@RequestParam Map<String, String> params) throws Exception {
		String name = params.get("name");
		String designation = params.get("designation");
		List<Employee> emp = repository.findByNameOrDesignation(name, designation); // Optional is more like a wrapper
																					// and bucket
		return emp;
	}

	@GetMapping("find/id/{id}") // custom url for id
	public Employee findbyId(@PathVariable("id") int id) {
		Optional<Employee> emp = repository.findById(id);
		return emp.get();
	}

}
