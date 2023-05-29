package com.alemeza.licencia.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import  com.alemeza.licencia.models.License;


public interface LicenseRepo extends CrudRepository<License, Long> {
	
	public List<License> findAll();
	
	public License findTopByOrderByNumeroDesc();
	

}