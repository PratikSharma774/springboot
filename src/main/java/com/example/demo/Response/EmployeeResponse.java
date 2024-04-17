package com.example.demo.Response;

import lombok.Data;

@Data
public class EmployeeResponse {
	
	String message;
	Boolean status;
	
   public EmployeeResponse(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

}
