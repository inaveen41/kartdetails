package com.example.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.model.Employee;
import com.example.demo.respository.EmployeeRepository;

@SpringBootApplication
//@ComponentScan(basePackages="controller")
public class SpringBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBackendApplication.class, args);
	}
//	private EmployeeRepository employeeRespository;
	


}
