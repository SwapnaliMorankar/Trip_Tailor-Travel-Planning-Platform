package com.springboot.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.Model.Iternary;

public interface IternaryRepository extends JpaRepository<Iternary, Integer>{
	
	public List<Iternary> findByTripTripId(int tripId);

}
