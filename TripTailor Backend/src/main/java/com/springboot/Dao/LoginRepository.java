package com.springboot.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.Model.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {
	
	public Login findByUseremail(String useremail);

}
