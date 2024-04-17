package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.Entity.Add;
import com.example.demo.Entity.Employee;
import com.example.demo.Response.EmployeeResponse;
import com.example.demo.Response.LoginResponse;
import com.example.demo.service.EmployeeService;


@RestController
@CrossOrigin(origins = "http://localhost:3000/", allowCredentials = "true")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/getName")
	public List<Add> getEmployeeByName(@RequestBody Add add) {
		return service.getEmployeeByName(add.getName());
	}
	
	@GetMapping("/getSalary")
	public List<Add> getEmployeeBySalary(@RequestBody Add add) {
		return service.getEmployeeBySalary(add.getSalary());
	}
	
	@CrossOrigin(origins = "http://localhost:3000/" , allowCredentials = "true")
	@PostMapping("/login")
	public ResponseEntity<LoginResponse>  get(@RequestBody LoginDTO login) {
		
		return ResponseEntity.ok(service.loginCheck(login));
	}
	
	@PostMapping("/addEmployee")
	public ResponseEntity<?> addEmployee(@RequestBody Add add) {
		EmployeeResponse esp = service.saveEmployee(add);
		return ResponseEntity.ok(esp);
	}
	
	@PostMapping("/saveAdmin")
	public ResponseEntity<EmployeeResponse> saveAdmin(@RequestBody Employee employee) {
		EmployeeResponse esp = service.saveAdmin(employee);
		return ResponseEntity.ok(esp);
	}
	

}
