package com.example.demo.DTO;

import lombok.Data;

@Data
public class LoginDTO {
	
	String email;
	String password;
	
	public String getEmail() {
		return this.email;
	}
	
	public String getPassword() {
		return this.password;
	}


}
