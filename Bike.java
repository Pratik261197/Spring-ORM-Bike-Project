package com.java.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bike")

public class Bike {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="bike_number")
	private Integer bikeNumber;
	
	@Column(name="bike_model")
	private String bikeModel;
	
	@Column(name="bike_company")
	private String bikeCompany;
	
	@Column(name="is_dual_abs")
	private Boolean isDualAbs;
	
	@Column(name="bike_price")
	private Double bikePrice;
	

	public Bike() {
		// TODO Auto-generated constructor stub
	}

	public Bike(Integer bikeNumber, String bikeModel, String bikeCompany, Boolean isDualAbs, Double bikePrice) {
		super();
		this.bikeNumber = bikeNumber;
		this.bikeModel = bikeModel;
		this.bikeCompany = bikeCompany;
		this.isDualAbs = isDualAbs;
		this.bikePrice = bikePrice;
	}

	public Bike(String bikeModel, String bikeCompany, Boolean isDualAbs, Double bikePrice) {
		super();
		this.bikeModel = bikeModel;
		this.bikeCompany = bikeCompany;
		this.isDualAbs = isDualAbs;
		this.bikePrice = bikePrice;
	}

	public Integer getBikeNumber() {
		return bikeNumber;
	}

	public void setBikeNumber(Integer bikeNumber) {
		this.bikeNumber = bikeNumber;
	}

	public String getBikeModel() {
		return bikeModel;
	}

	public void setBikeModel(String bikeModel) {
		this.bikeModel = bikeModel;
	}

	public String getBikeCompany() {
		return bikeCompany;
	}

	public void setBikeCompany(String bikeCompany) {
		this.bikeCompany = bikeCompany;
	}

	public Boolean getIsDualAbs() {
		return isDualAbs;
	}

	public void setIsDualAbs(Boolean isDualAbs) {
		this.isDualAbs = isDualAbs;
	}

	public Double getBikePrice() {
		return bikePrice;
	}

	public void setBikePrice(Double bikePrice) {
		this.bikePrice = bikePrice;
	}

	@Override
	public String toString() {
		return "Bike [bikeNumber=" + bikeNumber + ", bikeModel=" + bikeModel + ", bikeCompany=" + bikeCompany
				+ ", isDualAbs=" + isDualAbs + ", bikePrice=" + bikePrice + "]";
	}
	
	
	
}
