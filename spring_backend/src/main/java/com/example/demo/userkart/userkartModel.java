package com.example.demo.userkart;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;

import com.example.demo.kart.kartModel;

@Entity
@Table(name = "userkart")
public class userkartModel {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "emailid")
	private String emailid;
	
	@Column(name = "productid")
	private int productid;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL, targetEntity = kartModel.class)
	@JoinColumn(name = "kid")
	private kartModel kartModel;
//	private int productid;
//	@Fetch(FetchMode.JOIN)
//	@ManyToOne(targetEntity = kartModel.class, optional = false)
//	@JoinColumn(name = "productid")
//	private kartModel kartModel;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "price")
	private int price;
	
	
	
	public kartModel getKartModel() {
		return kartModel;
	}

	public void setKartModel(kartModel kartModel) {
		this.kartModel = kartModel;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public userkartModel() {
		super();
	}
	
	public userkartModel(String emailid, int productid, int quantity, int price)
	{
		this.emailid=emailid;
		this.productid=productid;
		this.quantity=quantity;
		this.price=price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

//	public int getProductid() {
//		return productid;
//	}
//
//	public void setProductid(int productid) {
//		this.productid = productid;
//	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "dept_id", insertable = false, updatable = false)
//	@Fetch(FetchMode.JOIN)
//	private kartModel kartModel;
//	@ManyToOne(targetEntity = kartModel.class, optional = false)
//	@JoinColumn(name = "kid")
//	private kartModel kartModel;
//
//
//
//	public kartModel getKartModel() {
//		return kartModel;
//	}
//
//	public void setKartModel(kartModel kartModel) {
//		this.kartModel = kartModel;
//	}
}
