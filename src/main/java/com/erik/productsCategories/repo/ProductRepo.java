package com.erik.productsCategories.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.erik.productsCategories.models.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {
	//public List<Product> allProducts();
}
