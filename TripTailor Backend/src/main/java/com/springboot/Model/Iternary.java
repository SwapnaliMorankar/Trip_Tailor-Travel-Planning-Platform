package com.springboot.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Iternary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iternary_id;
	@ManyToOne
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;
	private int day;
	private String dayPlan;
	private String transport;
	
	public int getIternary_id() {
		return iternary_id;
	}
	public void setIternary_id(int iternary_id) {
		this.iternary_id = iternary_id;
	}
	public Trip getTrip() {
		return trip;
	}
	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getDayPlan() {
		return dayPlan;
	}
	public void setDayPlan(String dayPlan) {
		this.dayPlan = dayPlan;
	}
	public String getTransport() {
		return transport;
	}
	public void setTransport(String transport) {
		this.transport = transport;
	}
	public Iternary(int iternary_id, Trip trip, int day, String dayPlan, String transport) {
		super();
		this.iternary_id = iternary_id;
		this.trip = trip;
		this.day = day;
		this.dayPlan = dayPlan;
		this.transport = transport;
	}
	public Iternary() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Iternary [iternary_id=" + iternary_id + ", trip=" + trip + ", day=" + day + ", dayPlan=" + dayPlan
				+ ", transport=" + transport + "]";
	}
	
	

}
