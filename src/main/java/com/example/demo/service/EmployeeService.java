package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.Entity.Add;
import com.example.demo.Entity.Employee;
import com.example.demo.Response.EmployeeResponse;
import com.example.demo.Response.LoginResponse;
import com.example.demo.repository.AddRepository;
import com.example.demo.repository.EmployeeRepository;


@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private AddRepository addrepository;
	
	public EmployeeResponse saveAdmin(Employee employee) {
		repository.save(employee);
		return new EmployeeResponse("New Employee Added Successfully", true);
	}
	
	
	public EmployeeResponse saveEmployee(Add add) {
		System.out.print(add);
		addrepository.save(add);
		return new EmployeeResponse("New Employee Added Successfully", true);
	}
	
	public LoginResponse loginCheck(LoginDTO login) {
		Employee emp = repository.findByEmail(login.getEmail());
		System.out.println(emp);
		if(emp.getPassword().equals(login.getPassword())) {
		return new LoginResponse("Login Success", true);
		}
		else {
			return new LoginResponse("Login failed", true);
		}
	}
	
	public List<Add> getEmployeeByName(String name) {
		List<Add> empList = addrepository.findByName(name);
		return empList;
	}
	public List<Add> getEmployeeBySalary(double salary) {
		List<Add> empList = addrepository.findBySalary(salary);
		return empList;
	}
	
	
//	public String getEmployeeBySalary(String name) {
//		System.out.print(name);
//		addrepository.save(add);
//		return " Check Employee added..";
//	}
//	

}
