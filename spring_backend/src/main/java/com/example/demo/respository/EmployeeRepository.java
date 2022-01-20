package com.example.demo.respository;

import java.util.Optional;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

//public User findByEmailId(String emailId);
Optional<Employee> findByEmailId(String emailId);


}

