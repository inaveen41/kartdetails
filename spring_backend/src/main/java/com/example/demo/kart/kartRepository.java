package com.example.demo.kart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

//import com.example.demo.ImageModel.ImageModel;
@Repository
@EnableJpaRepositories 
public interface kartRepository extends JpaRepository<kartModel, Long>{
	
//	@Query(value = "SELECT  FROM kart c WHERE c.id=:email AND c.pass=:pass")
//	public boolean login(String email, String pass);
}
