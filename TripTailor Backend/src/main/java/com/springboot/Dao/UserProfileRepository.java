package com.springboot.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.Model.UserProfile;

import jakarta.transaction.Transactional;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer>{

	public UserProfile findByFirstName(String name);
	@Transactional
	public String deleteByFirstName(String name);
}
