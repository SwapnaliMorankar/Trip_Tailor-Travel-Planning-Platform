package com.springboot.Model;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class UserProfile {
	
	@Id
    private int userId; 
	private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String dob;
    private int age;
    private String gender;
    private String address;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    @Lob
    private byte[] profilePhoto;
    
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public byte[] getProfilePhoto() {
		return profilePhoto;
	}
	public void setProfilePhoto(byte[] profilePhoto) {
		this.profilePhoto = profilePhoto;
	}
	public UserProfile(int userId, String firstName, String lastName, String email, String phoneNumber, String dob,
			int age, String gender, String address, String city, String state, String country, String zipCode,
			byte[] profilePhoto) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dob = dob;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
		this.profilePhoto = profilePhoto;
	}
	public UserProfile() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserProfile [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", dob=" + dob + ", age=" + age + ", gender=" + gender
				+ ", address=" + address + ", city=" + city + ", state=" + state + ", country=" + country + ", zipCode="
				+ zipCode + ", profilePhoto=" + Arrays.toString(profilePhoto) + "]";
	}
    
    
    
    
}
