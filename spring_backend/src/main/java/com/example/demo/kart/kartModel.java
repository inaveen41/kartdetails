package com.example.demo.kart;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.userkart.userkartModel;

@Entity
@Table(name = "kart")
public class kartModel {
	@Id
	@Column(name = "kid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int kid;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "rating")
	private float rating;
	
	@Column(name = "no_of_ratings")
	private int no_of_ratings;
	
	@Column(name = "image", length = 1000)
	private byte[] image;
	
	@OneToMany(targetEntity = userkartModel.class, mappedBy = "kartModel", fetch = FetchType.EAGER)
	private List<userkartModel> userkartModel;
	
	public kartModel() {
		super();
	}
	
	public kartModel(String title, String description, int price, int quantity, float rating,int no_of_ratings,  byte[] image) {
		this.title = title;
		this.description = description;
		this.price=price;
		this.quantity=quantity;
		this.no_of_ratings=no_of_ratings;
		this.rating=rating;
		this.image=image;
	}
	
	

	public int getId() {
		return kid;
	}

	public void setId(int id) {
		this.kid = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public int getNo_of_ratings() {
		return no_of_ratings;
	}

	public void setNo_of_ratings(int no_of_ratings) {
		this.no_of_ratings = no_of_ratings;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}


	public List<userkartModel> getUserkartModel() {
		return userkartModel;
	}

	public void setUserkartModel(List<userkartModel> userkartModel) {
		this.userkartModel = userkartModel;
	}
	
	
	

}
