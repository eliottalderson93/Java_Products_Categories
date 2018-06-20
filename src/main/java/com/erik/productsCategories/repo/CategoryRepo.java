package com.erik.productsCategories.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.erik.productsCategories.models.Category;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long> {
	//public List<Category> allCategories();
}
