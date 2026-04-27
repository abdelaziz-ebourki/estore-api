package com.estore.review.service;

import com.estore.review.entity.Review;
import com.estore.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    public List<Review> getReviewsByProduct(Long productId) {
        return reviewRepository.findByProductId(productId);
    }

    public Review createReview(Review review) {
        review.setDate(LocalDateTime.now());
        return reviewRepository.save(review);
    }
}
