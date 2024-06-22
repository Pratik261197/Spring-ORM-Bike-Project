package com.java.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.java.entities.Bike;


public class BikeDAOImpl implements BikeDAO{

	private HibernateTemplate hibernateTemplate;
	
  
	public BikeDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public BikeDAOImpl(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}



	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		System.out.println("Setting HibernateTemplate in BikeDAOImpl..");
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	@Override
	public int insertBike(Bike bike) {
		
		Integer rowAffected=(Integer) this.getHibernateTemplate().save(bike);
		return rowAffected;
	}


	@Transactional
	@Override
	public List<Bike> getAll() {
		
		return this.getHibernateTemplate().loadAll(Bike.class);
	}
 
	@Override
	public Bike getByNumber(int bikeNumber) {
		
		return this.getHibernateTemplate().get(Bike.class,bikeNumber);
	}

	@Transactional
	@Override
	public void updateBikeByNumber(Bike updatedbike) {
		
		this.getHibernateTemplate().update(updatedbike);	
	}


	@Transactional
	@Override
	public void deleteBikeByNumber(int bikeNumber) {
		
		this.getHibernateTemplate().delete(getByNumber(bikeNumber));
		
	}


}
