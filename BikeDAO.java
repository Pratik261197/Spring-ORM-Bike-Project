package com.java.dao;

import java.util.List;

import com.java.entities.Bike;

public interface BikeDAO {

	public int insertBike(Bike bike);
	
	public List<Bike> getAll();
	
	public Bike getByNumber(int bikeNumber);
	
	public void updateBikeByNumber(Bike bike);
	
	public void deleteBikeByNumber(int bikeNumber);
	
}
