package com.ecom.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	List<Product> getByCategoryId(Long cid);

}
