package com.springboot.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.Model.Trip;

public interface TripRepository extends JpaRepository<Trip, Integer>{
	
	public Optional<Trip> findByTripName(String tripName);
	
	@Query("SELECT t FROM Trip t WHERE t.popularity = 'Popular'")
	public List<Trip> getPopularTrips();
	
	@Query("SELECT t FROM Trip t WHERE t.status = 'Inactive'")
	public List<Trip> getInactiveTrips();
	
	@Query("SELECT t FROM Trip t WHERE t.status = 'Active'")
	public List<Trip> getActiveTrips();
	
	//To get latest updated trip to add iternary
	Trip findTopByOrderByLastUpdatedDesc();

}
