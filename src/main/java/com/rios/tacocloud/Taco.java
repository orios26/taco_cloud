package com.rios.tacocloud;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Taco {
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	private Long id;
	@NotNull
	@Size(min=5, message="Name must be at least 5 characters long")
	private String name;
	@Size(min=1, message="You must choose at least 1 ingredient")
	private List<Ingredient> ingredients;
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	private Date createdAt;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	

	@Override
	public String toString() {
		return "Taco [id=" + id + "name=" + name + ", ingredients=" + ingredients + "]";
	}
	public Taco(Long id, String name, List<Ingredient> ingredients) {
		super();
		this.id = id;
		this.name = name;
		this.ingredients = ingredients;
	}
	public Taco() {
		super();
		// TODO Auto-generated constructor stub
	}
}
