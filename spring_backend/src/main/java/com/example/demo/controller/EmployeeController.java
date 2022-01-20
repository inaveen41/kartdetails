package com.example.demo.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

//import org.hibernate.annotations.common.util.impl.Log_.logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.example.demo.ImageModel.ImageModel;
import com.example.demo.ImageRepository.ImageRepository;
import com.example.demo.exception.ResourceNotFoundException;
//import com.example.demo.respository.LoginRepository;
import com.example.demo.model.Employee;
import com.example.demo.respository.EmployeeRepository;

@RestController
//@EnableAutoConfiguration(exclude = ErrorMvcAutoConfiguration.class)
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(path="/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	


	@GetMapping("/employees")
//	@RequestMapping(value="/employees")
	public List<Employee> getAllEmployees(){
//		String name= "hello";
		return employeeRepository.findAll();
//		return name;
	}
	
	@GetMapping("/login/{email}")
	public ResponseEntity<Employee> getEmployeeByEmailId(@PathVariable String email) {
		Employee employee = employeeRepository.findByEmailId (email)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + email));
		return ResponseEntity.ok(employee);
	}
	
//	 create employee rest api
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {

		return employeeRepository.save(employee);
	}
	
	//get employee by rest api
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee = employeeRepository.findById (id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(employee);
	}
	

	


	
	// update employee rest api
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());
		employee.setPassword(employeeDetails.getPassword()); 
		
		Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	 @RequestMapping("/employees")
	  public Map<String,Object> home() {
	    Map<String,Object> model = new HashMap<String,Object>();
	    model.put("email_id", UUID.randomUUID());
	    model.put("content", "Hello World");
	    return model;
	  }
	 
	 //login
		
		@Query(value="select * from register where email=?1 and password=?2",nativeQuery=true)
		Employee findByEmailPassword(String email, String password) {
			
			return null;
		}
//		@GetMapping("/login")
//		public User loginuser(@RequestBody User user) {
//			String tempEmailId = user.getName();
//			if(tempEmailId != null && !"".contentEquals(tempEmailId))
//			{
//				User userobj=service.fetchuserByEmailID(tempEmailId);
				
//			}
//		}
	    @RequestMapping("/")  
	    @ResponseBody  
	    public String index() {  
	        return "That's pretty basic!";  
	    } 
	    
	   

	 
}
