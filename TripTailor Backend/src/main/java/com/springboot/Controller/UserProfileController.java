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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Model.UserProfile;
import com.springboot.Service.UserProfileService;

@RestController
@RequestMapping("/api/user")
public class UserProfileController {

	@Autowired
	private UserProfileService userProfileService;

	// User Side APIs

	// Save updated User Profile Details
	@PostMapping("/{userid}/saveUserDetails")
	public ResponseEntity<String> saveUserProfile(@RequestBody UserProfile userProfile) {
		String result = this.userProfileService.saveDetails(userProfile);
		if (result.equals("Profile Saved!")) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving user details");
		}
	}

	// To get details in edit profile form
	@GetMapping("/{userid}/getUserDetails")
	public ResponseEntity<UserProfile> getUserDetails(@PathVariable("userid") int ID) {
		Optional<UserProfile> user = this.userProfileService.getDetails(ID);
		if (user.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.ok(user.get());
	}

	// Delete My Account
	@DeleteMapping("/{userid}/deleteProfile")
	public ResponseEntity<String> deleteProfile(@PathVariable("userid") int ID) {
		String result = this.userProfileService.deleteProfile(ID);
		if (result == "Profile Deleted!") {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error in Deleting");
	}

	// Admin Side APIs

	// Get All Users List
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<UserProfile>> getAllUsers() {
		List<UserProfile> users = this.userProfileService.getAllUsers();
		if (users.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.ok(users);
	}

	// Find User by name
	@GetMapping("/getUserByName/{name}")
	public ResponseEntity<UserProfile> getUserByName(@PathVariable("name") String Name) {
		UserProfile user = this.userProfileService.getUserName(Name);
		if (user == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.ok(user);
	}

	// Delete User by name
	@DeleteMapping("/deleteUserByName/{name}")
	public ResponseEntity<String> deleteUserByName(@PathVariable("name") String Name) {
		String result = this.userProfileService.deleteUserName(Name);
		if (result == "User Deleted") {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
	}

}
