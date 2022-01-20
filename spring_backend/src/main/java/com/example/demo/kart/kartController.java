package com.example.demo.kart;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.ImageModel.ImageModel;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.respository.EmployeeRepository;

@RestController
//@EnableAutoConfiguration(exclude = ErrorMvcAutoConfiguration.class)
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(path="/setkart")
public class kartController {
	@Autowired
	private kartRepository kartRepository;
	
	@PostMapping("/kart")
	public kartModel createkartModel( @RequestParam("imageFile") MultipartFile file, @RequestParam("title") String title, @RequestParam("description") String description, @RequestParam("quantity") int quantity, @RequestParam("price") int price, @RequestParam("rating") float rating, @RequestParam("no_of_ratings") int no_of_ratings) throws IOException {
		kartModel ka = new kartModel(title,description,price,quantity,rating,no_of_ratings,file.getBytes());
//System.out.println(kart.getImage());
		return kartRepository.save(ka);
//		repo.save(img);
//		return ResponseEntity.status(HttpStatus.OK);
	}
	
	@GetMapping("/kart")
	public List<kartModel> getAllkartModel(){

		return kartRepository.findAll();

	}
	
	@GetMapping("/kart/{id}")
	public kartModel getEmployeeById(@PathVariable Long id) {
//		kartModel kart = kartRepository.findById (id)
//				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
//		return ResponseEntity.ok(kart);
				final Optional<kartModel> retrievedImage = kartRepository.findById(id);
		kartModel kart = new kartModel(retrievedImage.get().getTitle(), retrievedImage.get().getDescription(),retrievedImage.get().getPrice(),retrievedImage.get().getQuantity(),retrievedImage.get().getRating(),retrievedImage.get().getNo_of_ratings(),
				retrievedImage.get().getImage());
		return kart;
	}
	
}
