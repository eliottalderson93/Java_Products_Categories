package com.erik.productsCategories.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.assertj.core.util.Sets;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erik.productsCategories.models.Category;
import com.erik.productsCategories.models.Product;
import com.erik.productsCategories.services.MainService;

@Controller
public class MainController {
	private final MainService service;
	public MainController(MainService s) {
		this.service = s;
	}
	@RequestMapping("/")
	public String redirect() {
		return "redirect:/new";
	}
	@RequestMapping("/new")
	public String renderNew() {
		System.out.println("route");
		return "project/new";
	}
	@PostMapping("/new/products")
	public String postProducts(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			
		}
		else {
			service.createProduct(product);
		}
		return "project/new.jsp";
	}
	@PostMapping("/new/categories")
	public String postCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			
		}
		else {
			service.createCategory(category);
		}
		return "project/new.jsp";
	}
	@GetMapping("/products/{product_id}")
	public String showProduct(Model model, @PathVariable("product_id") Long id, @ModelAttribute("product") Product product) {
		Product this_product = service.findProduct(id);
		if (this_product == null) {
			return "redirect:/new";
		}
		else {
			//try {
			List<Category> myCategories = this_product.getCategories();
			//catch() {
				
			//}
			List<Category> allCategories = service.allCategories();
			Set<Category> full = new HashSet<Category>(allCategories);
			Set<Category> less = new HashSet<Category>(myCategories);
			full.removeAll(less);
			List<Category> otherCategories = (List<Category>)full;
			model.addAttribute("categories_for_products", myCategories);
			model.addAttribute("product", this_product);
			model.addAttribute("form_categories", otherCategories);
			return "/product.jsp";
		}
		
	}
	@PostMapping("/products/{product_id}")
	public String addProduct(Model model, @PathVariable("product_id") Long id, @ModelAttribute("product") Product product, @ModelAttribute("category") Category category) {
		Product this_product = service.findProduct(id);
		if (this_product == null) {
			return "redirect:/new";
		}
		else { //manage post here
			this_product.addCategory(category);
			return "redirect:/products/"+id;
		}
	}
	@GetMapping("/categories/{category_id}")
	public String showCategory(Model model, @PathVariable("category_id") Long id, @ModelAttribute("category") Category category) {
		Category this_category = service.findCategory(id);
		if (this_category == null) {
			return "redirect:/new";
		}
		else {
			List<Product> myProducts = this_category.getProducts();
			List<Product> allProducts = service.allProducts();
			Set<Product> full = new HashSet<Product>(allProducts);
			Set<Product> less = new HashSet<Product>(myProducts);
			full.removeAll(less);
			List<Product> otherProducts = (List<Product>)full;
			model.addAttribute("products_in_category", myProducts);
			model.addAttribute("category", this_category);
			model.addAttribute("form_products",otherProducts);
			return "/category.jsp";
		}
	}
	@PostMapping("/categories/{category_id}")
	public String addCategory(Model model, @PathVariable("category_id") Long id, @ModelAttribute("category") Category category, @ModelAttribute("product") Product product) {
		Category this_category = service.findCategory(id);
		if (this_category == null) {
			return "redirect:/new";
		}
		else { //manage post here
			this_category.addProduct(product);
			return "redirect:/categories/"+id;
		}
	}	
}