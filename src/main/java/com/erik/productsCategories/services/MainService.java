package com.erik.productsCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.erik.productsCategories.models.Category;
import com.erik.productsCategories.models.Product;
import com.erik.productsCategories.repo.CategoryRepo;
import com.erik.productsCategories.repo.ProductRepo;

@Service
public class MainService {
	private final CategoryRepo catRepo;
	private final ProductRepo prodRepo;
	MainService(CategoryRepo cr, ProductRepo pr){
		this.catRepo = cr;
		this.prodRepo = pr;
	}
	public List<Category> allCategories(){
		return (List<Category>) catRepo.findAll();
	}
	public List<Product> allProducts(){
		return (List<Product>) prodRepo.findAll();
	}
	public Category createCategory(Category c) {
		return catRepo.save(c);
	}
	public Product createProduct(Product p) {
		return prodRepo.save(p);
	}
	public Category findCategory(Long id) {
		Optional<Category> output = catRepo.findById(id);
		if (output.isPresent()) {
			return output.get();
		}
		else {
			return null;
		}
	}
	public Product findProduct(Long id) {
		Optional<Product> output = prodRepo.findById(id);
		if (output.isPresent()) {
			return output.get();
		}
		else {
			return null;
		}
	}
	
}
