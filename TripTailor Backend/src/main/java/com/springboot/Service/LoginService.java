package com.springboot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.Dao.LoginRepository;
import com.springboot.Dao.UserProfileRepository;
import com.springboot.Model.Login;
import com.springboot.Model.UserProfile;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepo;
	
	@Autowired
	private UserProfileRepository userProfileRepo;
	
	//Register User to Database
	public String Register(Login login) {
		this.loginRepo.save(login);
		UserProfile user = new UserProfile();
		user.setFirstName(login.getFirstname());
		user.setLastName(login.getLastname());
		user.setEmail(login.getUseremail());
		user.setUserId(login.getUser_id());;
		this.userProfileRepo.save(user);
		return "Successfull!";
	}
	
	//Login User Authentication
	public String Login(String email, String password) {
		Login result = this.loginRepo.findByUseremail(email);
		//No User
		if(result==null) {
			return "User Not Found";
		}
		//Validate Password
		if(result.getPasword().equals(password)) {
			return "User Login Successfull";
		}
		else {
			return "Invalid credentials";
		}
		
	}

}
