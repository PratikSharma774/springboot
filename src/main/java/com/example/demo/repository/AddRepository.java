package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Add;
import com.example.demo.Entity.Employee;

public interface AddRepository extends JpaRepository<Add, Integer> {
	
	List<Add> findByName(String Name);
	List<Add> findBySalary(Double salary);


}