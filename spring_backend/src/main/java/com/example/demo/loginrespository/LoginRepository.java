package com.example.demo.loginrespository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public interface LoginRepository extends JpaRepository<Employee, String>{

}
