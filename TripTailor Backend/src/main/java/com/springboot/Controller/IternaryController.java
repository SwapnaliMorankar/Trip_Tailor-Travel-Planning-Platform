package com.springboot.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Model.Iternary;
import com.springboot.Model.Review;
import com.springboot.Service.IternaryService;

@RestController
@RequestMapping("/api/iternary")
public class IternaryController {

	@Autowired
	private IternaryService iternaryService;

	// Save New Iternary under Trip
	@PostMapping("/saveIternary")
	public ResponseEntity<String> saveIternary(@RequestBody List<Iternary> iternary) {
		String result = this.iternaryService.addIternary(iternary);
		if (result.equals("Iternaries Added!")) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
		}
	}

	// Get All Iternary for Trip Id
	@GetMapping("/getAllIternary/{tripId}")
	public ResponseEntity<List<Iternary>> getAllIternary(@PathVariable("tripId") int ID) {
		List<Iternary> iternaries = this.iternaryService.getIternary(ID);
		if (iternaries.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		} else {
			return ResponseEntity.ok(iternaries);
		}
	}

	// Get Iternary by Id
	@GetMapping("/getIternary/{iterId}")
	public ResponseEntity<Optional<Iternary>> getIternary(@PathVariable("iterId") int ID) {
		Optional<Iternary> iternary = this.iternaryService.getIternaryByID(ID);
		if (iternary.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		} else {
			return ResponseEntity.ok(iternary);
		}
	}

	// Delete Iternary by Id
	@DeleteMapping("/deleteIternary/{iterId}")
	public ResponseEntity<String> deleteIternary(@PathVariable("iterId") int ID) {
		String result = this.iternaryService.deleteIternary(ID);
		if (result == "Iternary Deleted") {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
		}
	}

	// Update Iternary by Id
	@PutMapping("/updateIternary")
	public ResponseEntity<Optional<Iternary>> updateIternary(@RequestBody Iternary iter) {
		Optional<Iternary> iternary = this.iternaryService.updateIternary(iter);
		if (iternary.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		} else {
			return ResponseEntity.ok(iternary);
		}
	}

}
