package com.example.demo.userkart;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ImageModel.ImageModel;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.kart.kartModel;
import com.example.demo.model.Employee;
import com.example.demo.respository.EmployeeRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(path="/userkart")
public class userkartController {
	
	@Autowired
	private userkartRepository userkartRepository;
	
	@PostMapping("/inkart")
	public userkartModel createEmployee(@RequestBody userkartModel ukm) {

		return userkartRepository.save(ukm);
	}
	@GetMapping("/inkart/{productid}/{emailid}")
	public ResponseEntity<List<userkartModel>> getuserkartByProductIdAndEmailId(@PathVariable int productid,@PathVariable String emailid)  {
//		System.out.printf("id and email values are "+id,emailid);
		
//		System.out.println("id and email values are "+productid+emailid);s
		return new ResponseEntity<>(userkartRepository.findByProductidAndEmailid(productid, emailid),HttpStatus.OK);

	}
	@GetMapping("/inkart/{emailid}")
//	public List<userkartModel> fetchAllCustomers() {
//		List<userkartModel> customerList=userkartRepository.findAll();
//		return customerList;
//	}
	public ResponseEntity<List<userkartdetails>> getuserkartByEmailId(@PathVariable String emailid)  {
//		System.out.printf("id and email values are "+id,emailid);
		
		System.out.println(" email values are "+emailid);
		
//		return new ResponseEntity<>(userkartRepository.findByEmailid(emailid),HttpStatus.OK);
		return new ResponseEntity<>(userkartRepository.kartdetails(emailid),HttpStatus.OK);
//		System.out.println("details "+ResponseEntity);
//		userkartRepository.kartdetails(emailid);
//		return new ResponseEntity<>(userkartRepository.getforuserkart(emailid),HttpStatus.OK);
//		return null;
	}
//	@GetMapping("/inkar/{kid}")
//	public List<userkartModel> fetchAllCustomerOrders(@PathVariable int kid) {
//		userkartModel c=userkartRepository.;
//		return (List<userkartModel>) c.getKartModel();
//	}
	
	
	@PutMapping("/inkart/{id}")
	public ResponseEntity<userkartModel> updateEmployee(@PathVariable Long id, @RequestBody userkartModel userkart){
		userkartModel  uk= userkartRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		uk.setEmailid(userkart.getEmailid());
		uk.setPrice(userkart.getPrice());
		uk.setProductid(userkart.getProductid());
		uk.setQuantity(userkart.getQuantity());

		
		userkartModel updateduserkart = userkartRepository.save(uk);
		return ResponseEntity.ok(updateduserkart);
	}
	
//	@GetMapping("/userinkart/{email}/{productid}")
	
	
	@GetMapping("/inkart")
	public List<userkartModel> getAlluserkart(){
//		String name= "hello";
		return userkartRepository.findAll();
//		return name;
	}
	
	@DeleteMapping("/inkart/{productid}/{emailid}")
	public void deleteEmployee(@PathVariable int productid, @PathVariable String emailid)throws IOException{
		System.out.println("product id = "+productid+" emailid = "+emailid+" for deletion");
//		 List<userkartModel> img = userkartRepository.findByProductidAndEmailid(productid,emailid);
////					.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with email :" + imageName));
//		   userkartRepository.delete((userkartModel) img);
//			return img;
		userkartRepository.deleteforuserkart(productid,emailid);
	}
	
	
}
