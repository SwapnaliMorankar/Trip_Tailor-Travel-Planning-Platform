package com.springboot.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.Dao.LoginRepository;
import com.springboot.Dao.UserProfileRepository;
import com.springboot.Model.UserProfile;

@Service
public class UserProfileService {

	@Autowired
	private UserProfileRepository userProfileRepo;

	@Autowired
	private LoginRepository loginRepo;

	// User Side
	// Save User profile details
	public String saveDetails(UserProfile user) {
		this.userProfileRepo.save(user);
		return "Profile Saved!";
	}

	// To get all details in profile form
	public Optional<UserProfile> getDetails(int id) {
		Optional<UserProfile> user = this.userProfileRepo.findById(id);
		return user;
	}

	// Delete my account
	public String deleteProfile(int id) {
		this.userProfileRepo.deleteById(id);
		this.loginRepo.deleteById(id);
		return "Profile Deleted!";
	}

	// Admin Side
	// Get All Users
	public List<UserProfile> getAllUsers() {
		List<UserProfile> users = this.userProfileRepo.findAll();
		return users;
	}

	// Find User by Name
	public UserProfile getUserName(String name) {
		UserProfile user = this.userProfileRepo.findByFirstName(name);
		return user;
	}

	// Delete User by Name
	public String deleteUserName(String name) {
		this.userProfileRepo.deleteByFirstName(name);
		return "User Deleted";
	}

}
