package com.rios.tacocloud;

public interface IngredientRepository {
	
	Iterable<Ingredient> findAll();
	
	Ingredient findById(String id);
	
	Ingredient save(Ingredient ingredient);

}
