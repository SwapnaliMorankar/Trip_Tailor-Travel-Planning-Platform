package com.springboot.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Login {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	private String firstname;
	private String lastname;
	private String useremail;
	private String pasword;
	private String confirmpassword;
	private String role = "user";
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getPasword() {
		return pasword;
	}
	public void setPasword(String pasword) {
		this.pasword = pasword;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Login(int user_id, String firstname, String lastname, String useremail, String pasword,
			String confirmpassword, String role) {
		super();
		this.user_id = user_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.useremail = useremail;
		this.pasword = pasword;
		this.confirmpassword = confirmpassword;
		this.role = role;
	}
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Login [user_id=" + user_id + ", firstname=" + firstname + ", lastname=" + lastname + ", useremail="
				+ useremail + ", pasword=" + pasword + ", confirmpassword=" + confirmpassword + ", role=" + role + "]";
	}
	
	

}
