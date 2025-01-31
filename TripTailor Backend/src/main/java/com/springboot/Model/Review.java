package com.springboot.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int review_Id;
	private String user_name;
	private String trip_name;
	private String review;
	private int rating;
	
	public int getReview_Id() {
		return review_Id;
	}
	public void setReview_Id(int review_Id) {
		this.review_Id = review_Id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getTrip_name() {
		return trip_name;
	}
	public void setTrip_name(String trip_name) {
		this.trip_name = trip_name;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Review(int review_Id, String user_name, String trip_name, String review, int rating) {
		super();
		this.review_Id = review_Id;
		this.user_name = user_name;
		this.trip_name = trip_name;
		this.review = review;
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Review [review_Id=" + review_Id + ", user_name=" + user_name + ", trip_name=" + trip_name + ", review="
				+ review + ", rating=" + rating + "]";
	}
	

}
