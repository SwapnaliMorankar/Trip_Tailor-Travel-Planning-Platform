package com.springboot.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.Dao.ReviewRepository;
import com.springboot.Model.Review;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepo;

	// Save one review
	public String saveReview(Review review) {
		this.reviewRepo.save(review);
		return "Review Saved Successfully";
	}

	// Get All reviews
	public List<Review> getAllReviews() {
		List<Review> reviews = this.reviewRepo.findAll();
		return reviews;
	}

	// Get One review by ID
	public Optional<Review> getReview(int id) {
		Optional<Review> review = this.reviewRepo.findById(id);
		return review;
	}

	// Update Review by ID
	public Optional<Review> updateReview(Review newreview) {
		Optional<Review> oldreview = this.reviewRepo.findById(newreview.getReview_Id());
		if(oldreview.isPresent()) {
			Review review = oldreview.get();
			review.setUser_name(newreview.getUser_name());
			review.setRating(newreview.getRating());
			review.setReview(newreview.getReview());
			review.setTrip_name(newreview.getTrip_name());
			this.reviewRepo.save(review);
			return Optional.of(review);
		}
		return Optional.empty();
	}

	// Delete review by ID
	public String deleteReview(int id) {
		this.reviewRepo.deleteById(id);
		return "Review Deleted Successfully";
	}

}
