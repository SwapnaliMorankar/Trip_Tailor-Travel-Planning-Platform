package com.springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Model.Login;
import com.springboot.Service.LoginService;

@RestController
@RequestMapping("/api/public")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	//Register user
	@PostMapping("/register")
	public ResponseEntity<String> Register(@RequestBody Login login) {
		String result =  this.loginService.Register(login);
		return ResponseEntity.ok(result);
	}
	
	//Login User
	@PostMapping("/login")
	public ResponseEntity<String> Login(@RequestBody Login loginRequest) {
		String result = this.loginService.Login(loginRequest.getUseremail(), loginRequest.getPasword());
		if(result.equals("User Login Successfull")) {
			return ResponseEntity.ok(result);
		}else {
            return ResponseEntity.status(401).body(result);
        }
	}

}
