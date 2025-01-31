package com.springboot.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.Dao.IternaryRepository;
import com.springboot.Dao.TripRepository;
import com.springboot.Model.Iternary;
import com.springboot.Model.Trip;

@Service
public class IternaryService {
	
	@Autowired
	private IternaryRepository iternaryRepo;
	
	@Autowired
	private TripRepository tripRepo;
	
	//Add Multiple Iternary under trip ID
	public String addIternary(List<Iternary> iternary) {
		Trip latestTrip = this.tripRepo.findTopByOrderByLastUpdatedDesc();
		if(latestTrip==null) {
			return "No trips found. Please create a trip first.";
		}
		for (Iternary iter : iternary) {
            iter.setTrip(latestTrip);
        }
		this.iternaryRepo.saveAll(iternary);
		return "Iternaries Added!";
	}
	
	//Get All Iternary
	public List<Iternary> getIternary(int tripId){
		List<Iternary> iternaries = this.iternaryRepo.findByTripTripId(tripId);
		return iternaries;
	}
	
	//Delete Iternary by ID
	public String deleteIternary(int ID) {
		this.iternaryRepo.deleteById(ID);
		return "Iternary Deleted";
	}
	
	//Get Iternary by ID on update form
	public Optional<Iternary> getIternaryByID(int ID) {
		Optional<Iternary> iter = this.iternaryRepo.findById(ID);
		return iter;
	}
	
	//Update Iternary By ID
	public Optional<Iternary> updateIternary(Iternary newIternary) {
		Optional<Iternary> oldIternary = this.iternaryRepo.findById(newIternary.getIternary_id());
		if(oldIternary.isPresent()) {
			Iternary iter = oldIternary.get();
			iter.setDay(newIternary.getDay());
			iter.setDayPlan(newIternary.getDayPlan());
			iter.setTransport(newIternary.getTransport());
			this.iternaryRepo.save(iter);
			return Optional.of(iter);
		}
		return Optional.empty();
	}
	

}
