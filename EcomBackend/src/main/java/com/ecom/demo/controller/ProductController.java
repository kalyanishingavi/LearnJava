package com.ecom.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.demo.dto.ProductDto;
import com.ecom.demo.model.Category;
import com.ecom.demo.model.Product;
import com.ecom.demo.model.Review;
import com.ecom.demo.repository.CategoryRepository;
import com.ecom.demo.repository.ProductRepository;
import com.ecom.demo.repository.ReviewRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:4200/"})
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@PostMapping("/product/{cid}")
	public Product postCategory(@RequestBody Product product, @PathVariable("cid") Long cid) {
		Category category =categoryRepository.getById(cid);
		product.setCategory(category);
		return productRepository.save(product);
	}
	
	@GetMapping("/product/{cid}")
	public List<ProductDto> getAllCategories(@PathVariable("cid") Long cid) {
		List<ProductDto> ListDto = new ArrayList<>();
		
		List<Product> list = productRepository.getByCategoryId(cid);
		for(Product p:list) {
			ProductDto dto = new ProductDto();
			dto.setId(p.getId());
			dto.setTitle(p.getTitle());
			dto.setPrice(p.getPrice());
			dto.setShortDescription(p.getShortDescription());
			dto.setCategoryId(p.getCategory().getId());
			dto.setCategoryName(p.getCategory().getName());
			dto.setReviewCount(reviewRepository.getReviewCount(p.getId()));
			ListDto.add(dto);
		}
		
		return ListDto;
	}
	
	@GetMapping("/product/review/{pid}")
	public Long getReviewCount(@PathVariable("pid") Long pid) {
		return reviewRepository.getReviewCount(pid);
	}
	
	@GetMapping("/review/product/{pid}")
	public List<Review> getAllReviews(@PathVariable("pid") Long pid) {
		return reviewRepository.findByProductId(pid);
	}
	
	@PostMapping("/review/{pid}")
	public Review postReview(@PathVariable("pid") Long pid, @RequestBody Review review) {
		Product product = productRepository.getById(pid);
		review.setProduct(product);
		return reviewRepository.save(review);
		
	}
	
}
