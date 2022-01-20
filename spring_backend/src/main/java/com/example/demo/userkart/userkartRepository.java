package com.example.demo.userkart;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.kart.kartModel;
import com.example.demo.kart.kartRepository;
import com.example.demo.model.Employee;
@Repository
@EnableJpaRepositories 
public interface userkartRepository extends JpaRepository<userkartModel, Long>{
//	public static final kartRepository kartRepository = null;
//	Optional<userkartModel> findByEmailId(String emailId);
	Optional<userkartModel> findByProductidAndEmailid(Long id,String emailid);

	List<userkartModel> findByProductidAndEmailid(int id, String emailid);

	List<userkartModel> findByEmailid(String emailid);

	List<userkartModel> deleteByProductidAndEmailid(int productid, String emailid);

//	void delete(List<userkartModel> uk);

//	Optional<userkartModel> findByProductidAndEmailid(Long id, String email);

//	Employee save(userkartModel ukm);
	@Transactional
	@Modifying 
    @Query(value = "DELETE FROM userkart WHERE productid =? and emailid = ?",nativeQuery = true) // if want to write nativequery then mask nativeQuery  as true
    void deleteforuserkart(int productid, String emailid);
	
//	getSession().createSQLQuery(sql).addScalar("myId", Hibernate.LONG)
	@Query(value = "select title,description,image,productid,kart.price,userkart.quantity from userkart inner join kart where userkart.productid=kart.kid and emailid=?",nativeQuery = true)
//	@Query(value = "select * from userkart inner join kart where userkart.productid=kart.kid",nativeQuery = true)
	List<userkartdetails> kartdetails(@Param("emailid") String emailid);
	
//	@Transactional
//	@Modifying 
//    @Query(value = "select price from userkart inner join kart where userkart.productid=kart.id and emailid=?",nativeQuery = true) // if want to write nativequery then mask nativeQuery  as true
//	List<userkartModel> getforuserkart(String emailid);
	
}
