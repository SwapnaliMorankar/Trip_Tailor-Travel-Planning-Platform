package com.springboot.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.Model.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
