package com.springboot.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.Dao.TripRepository;
import com.springboot.Model.Trip;

@Service
public class TripService {

	@Autowired
	private TripRepository tripRepo;

	// Get All Trips
	public List<Trip> getAllTrips() {
		List<Trip> trips = this.tripRepo.findAll();
		return trips;
	}

	// Get one trip by ID
	public Optional<Trip> getByID(int id) {
		Optional<Trip> trip = this.tripRepo.findById(id);
		return trip;
	}

	// Get one trip by Name
	public Optional<Trip> getByName(String name) {
		Optional<Trip> trip = this.tripRepo.findByTripName(name);
		return trip;
	}

	// Add a new trip
	public String addNewTrip(Trip trip) {
		this.tripRepo.save(trip);
		return "Trip Added";
	}

	// Delete All Trips
	public void deleteAllTrips() {
		this.tripRepo.deleteAll();
	}

	// Delete trip by ID
	public void deleteTripByID(int id) {
		this.tripRepo.deleteById(id);
	}

	// Update trip by ID
	public Optional<Trip> updateTripByID(Trip newtrip) {
		Optional<Trip> oldtrip = this.tripRepo.findById(newtrip.getTripId());
		if (oldtrip.isPresent()) {
			Trip trip1 = oldtrip.get();
			trip1.setTripName(newtrip.getTripName());
			trip1.setTripPhoto(newtrip.getTripPhoto());
			trip1.setTripCategory(newtrip.getTripCategory());
			trip1.setNoOfDays(newtrip.getNoOfDays());
			trip1.setBudget(newtrip.getBudget());
			trip1.setStartCity(newtrip.getStartCity());
			trip1.setEndCity(newtrip.getEndCity());
			trip1.setTransportType(newtrip.getTransportType());
			trip1.setStayType(newtrip.getStayType());
			trip1.setState(newtrip.getState());
			trip1.setCountry(newtrip.getCountry());
			trip1.setStatus(newtrip.getStatus());
			trip1.setPopularity(newtrip.getPopularity());

			this.tripRepo.save(trip1);
			return Optional.of(trip1);
		}
		return Optional.empty();
	}

	// Get Popular Trips
	public List<Trip> popularTrips() {
		List<Trip> populartrips = this.tripRepo.getPopularTrips();
		return populartrips;
	}

	// Get Inactive Trips
	public List<Trip> inactiveTrips() {
		List<Trip> inactivetrips = this.tripRepo.getInactiveTrips();
		return inactivetrips;
	}

	// Get Active Trips
	public List<Trip> activeTrips() {
		List<Trip> activetrips = this.tripRepo.getActiveTrips();
		return activetrips;
	}

}
