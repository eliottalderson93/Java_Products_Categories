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
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "products")
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Size(min = 1, max = 20)
	String name;
	@Size(min = 5, max = 100)
	String desc;
	@Min(0)
	Integer price;
	@Column(updatable=false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "categories_products", 
        joinColumns = @JoinColumn(name = "product_id"), 
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;
    public Product() {}
    public void setId(Long id) {
    	this.id = id;
    }
    public void setName(String Name) {
    	this.name = Name;
    }
    public void setDesc(String desc) {
    	this.desc = desc;
    }
    public void setPrice(Integer price) {
    	this.price = price;
    }
    public void addCategory(Category cat) {
    	this.categories.add(cat);
    }
    public Long getId() {
    	return this.id;
    }
    public String getName() {
    	return this.name;
    }
    public String getDesc() {
    	return this.desc;
    }
    public Integer getPrice() {
    	return this.price;
    }
    public List<Category> getCategories(){
    	return this.categories;
    }
}
