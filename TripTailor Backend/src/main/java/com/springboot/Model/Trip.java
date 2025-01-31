package com.springboot.Model;

import java.time.LocalDateTime;
import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class Trip {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tripId;
    private String tripName;
    @Lob 
    private byte[] tripPhoto;
    private String tripCategory;
    private int noOfDays;
    private double budget;
    private String startCity;
    private String endCity;
    private String transportType;
    private String stayType;
    private String state;
    private String country;
    private String Destinations;
    private String status; 
    private String popularity;
    @Column(nullable = false)
    private LocalDateTime lastUpdated;
    
    @PrePersist
    @PreUpdate
    public void updateTimestamp() {
        this.lastUpdated = LocalDateTime.now();
    }
    
	public int getTripId() {
		return tripId;
	}
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
	public String getTripName() {
		return tripName;
	}
	public void setTripName(String tripName) {
		this.tripName = tripName;
	}
	public byte[] getTripPhoto() {
		return tripPhoto;
	}
	public void setTripPhoto(byte[] tripPhoto) {
		this.tripPhoto = tripPhoto;
	}
	public String getTripCategory() {
		return tripCategory;
	}
	public void setTripCategory(String tripCategory) {
		this.tripCategory = tripCategory;
	}
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public String getStartCity() {
		return startCity;
	}
	public void setStartCity(String startCity) {
		this.startCity = startCity;
	}
	public String getEndCity() {
		return endCity;
	}
	public void setEndCity(String endCity) {
		this.endCity = endCity;
	}
	public String getTransportType() {
		return transportType;
	}
	public void setTransportType(String transportType) {
		this.transportType = transportType;
	}
	public String getStayType() {
		return stayType;
	}
	public void setStayType(String stayType) {
		this.stayType = stayType;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPopularity() {
		return popularity;
	}
	public void setPopularity(String popularity) {
		this.popularity = popularity;
	}
	public String getDestinations() {
		return Destinations;
	}
	public void setDestinations(String destinations) {
		Destinations = destinations;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Trip(int tripId, String tripName, byte[] tripPhoto, String tripCategory, int noOfDays, double budget,
			String startCity, String endCity, String transportType, String stayType, String state, String country,
			String destinations, String status, String popularity, LocalDateTime lastUpdated) {
		super();
		this.tripId = tripId;
		this.tripName = tripName;
		this.tripPhoto = tripPhoto;
		this.tripCategory = tripCategory;
		this.noOfDays = noOfDays;
		this.budget = budget;
		this.startCity = startCity;
		this.endCity = endCity;
		this.transportType = transportType;
		this.stayType = stayType;
		this.state = state;
		this.country = country;
		Destinations = destinations;
		this.status = status;
		this.popularity = popularity;
		this.lastUpdated = lastUpdated;
	}

	public Trip() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Trip [tripId=" + tripId + ", tripName=" + tripName + ", tripPhoto=" + Arrays.toString(tripPhoto)
				+ ", tripCategory=" + tripCategory + ", noOfDays=" + noOfDays + ", budget=" + budget + ", startCity="
				+ startCity + ", endCity=" + endCity + ", transportType=" + transportType + ", stayType=" + stayType
				+ ", state=" + state + ", country=" + country + ", Destinations=" + Destinations + ", status=" + status
				+ ", popularity=" + popularity + ", lastUpdated=" + lastUpdated + "]";
	}
	
}
