package com.example.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.example.demo.respository.EmployeeRepository;

@Service
public class LoginService {
	
	@Autowired 
	private EmployeeRepository repo;
	
	
	
//	public User fetchuserByEmail(String email)
//	{
//		return repo.findByEmailId(email);
//	}
}
