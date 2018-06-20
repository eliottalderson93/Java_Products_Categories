package com.erik.productsCategories.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "categories")
public class Category {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Size(min = 1, max = 20)
    private String name;
    @Column(updatable=false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "categories_products", 
        joinColumns = @JoinColumn(name = "category_id"), 
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;
    
    public Category() {}
    public void setId(Long id) {
    	this.id = id;
    }
    public void setName(String Name) {
    	this.name = Name;
    }
    public Long getId() {
    	return this.id;
    }
    public String getName() {
    	return this.name;
    }
    public List<Product> getProducts(){
    	return this.products;
    }
    public void addProduct(Product toAdd) {
    	this.products.add(toAdd);
    }
}
