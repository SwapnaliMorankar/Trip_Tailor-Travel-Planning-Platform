package com.springboot.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Model.Review;
import com.springboot.Service.ReviewService;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	// Save New Review
	@PostMapping("/saveReview")
	public ResponseEntity<String> saveReview(@RequestBody Review review) {
		String result = this.reviewService.saveReview(review);
		if (result.equals("Review Saved Successfully")) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding review");
		}
	}

	// Get All Reviews
	@GetMapping("/getAllReviews")
	public ResponseEntity<List<Review>> getAllReviews() {
		List<Review> reviews = this.reviewService.getAllReviews();
		if (reviews.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(reviews);
		}
		return ResponseEntity.ok(reviews);
	}

	// Delete Review by ID
	@DeleteMapping("/deleteReviewByID/{id}")
	public ResponseEntity<String> deleteReviewByID(@PathVariable int id) {
		String result = this.reviewService.deleteReview(id);
		if (result.equals("Review Deleted Successfully")) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Deleting review");
		}
	}

	// To get details in edit review form
	@GetMapping("/getReviewDetails/{id}")
	public ResponseEntity<Review> getReviewDetails(@PathVariable("id") int ID) {
		Optional<Review> review = this.reviewService.getReview(ID);
		if (review.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.ok(review.get());
	}

	// Save updated User review
	@PutMapping("/saveUpdatedReview")
	public ResponseEntity<Optional<Review>> saveUpdatedReview(@RequestBody Review review) {
		Optional<Review> result = this.reviewService.updateReview(review);
		if (result.isPresent()) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	

}
