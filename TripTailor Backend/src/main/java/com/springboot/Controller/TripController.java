package com.springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springboot.Model.Trip;
import com.springboot.Service.TripService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/trip")
public class TripController {

	@Autowired
	private TripService tripService;

	// Add New Trip
	@PostMapping("/addNewTrip")
	public ResponseEntity<String> addNewTrip(@RequestBody Trip trip) {
		String result = this.tripService.addNewTrip(trip);
		if (result.equals("Trip Added")) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating trip");
		}
	}

	// Get All Trips
	@GetMapping("/getAllTrips")
	public ResponseEntity<List<Trip>> getAllTrips() {
		List<Trip> trips = this.tripService.getAllTrips();
		if (trips.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(trips);
		}
		return ResponseEntity.ok(trips);
	}

	// Get Trip by ID
	@GetMapping("/getTripByID/{id}")
	public ResponseEntity<Trip> getByID(@PathVariable int id) {
		Optional<Trip> trip = this.tripService.getByID(id);
		if (trip.isPresent()) {
			return ResponseEntity.ok(trip.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	// Get Trip by Name
	@GetMapping("/getTripByName/{name}")
	public ResponseEntity<Trip> getByName(@PathVariable String name) {
		Optional<Trip> trip = this.tripService.getByName(name);
		if (trip.isPresent()) {
			return ResponseEntity.ok(trip.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	// Delete All Trips
	@DeleteMapping("/deleteAllTrips")
	public ResponseEntity<String> deleteAllTrips() {
		this.tripService.deleteAllTrips();
		return ResponseEntity.ok("All trips deleted successfully");
	}

	// Delete Trip by ID
	@DeleteMapping("/deleteTripByID/{id}")
	public ResponseEntity<String> deleteTripByID(@PathVariable int id) {
		this.tripService.deleteTripByID(id);
		return ResponseEntity.ok("Trip deleted successfully");
	}

	// Get Trip Details on update form
	@GetMapping("/getTripOnUpdateForm/{id}")
	public ResponseEntity<Trip> getTripOnUpdateForm(@PathVariable int id) {
		Optional<Trip> ExistingTrip = this.tripService.getByID(id);
		if (ExistingTrip.isPresent()) {
			return ResponseEntity.ok(ExistingTrip.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	// Update Trip by ID
	@PutMapping("/updateTripByID")
	public ResponseEntity<Trip> updateTripByID(@RequestBody Trip trip) {
		Optional<Trip> updatedTrip = this.tripService.updateTripByID(trip);
		if (updatedTrip.isPresent()) {
			return ResponseEntity.ok(updatedTrip.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	// Get Popular Trips
	@GetMapping("/popularTrips")
	public ResponseEntity<List<Trip>> popularTrips() {
		List<Trip> popularTrips = this.tripService.popularTrips();
		if (popularTrips.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(popularTrips);
		}
		return ResponseEntity.ok(popularTrips);
	}

	// Get Inactive Trips
	@GetMapping("/inactiveTrips")
	public ResponseEntity<List<Trip>> inactiveTrips() {
		List<Trip> inactiveTrips = this.tripService.inactiveTrips();
		if (inactiveTrips.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(inactiveTrips);
		}
		return ResponseEntity.ok(inactiveTrips);
	}

	// Get Active Trips
	@GetMapping("/activeTrips")
	public ResponseEntity<List<Trip>> activeTrips() {
		List<Trip> activeTrips = this.tripService.activeTrips();
		if (activeTrips.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(activeTrips);
		}
		return ResponseEntity.ok(activeTrips);
	}
}
