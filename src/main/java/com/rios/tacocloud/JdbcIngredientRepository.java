package com.rios.tacocloud;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {
	
	private JdbcTemplate jdbc;
	
	@Override
	public Iterable<Ingredient> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ingredient findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ingredient save(Ingredient ingredient) {
		// TODO Auto-generated method stub
		return null;
	}

}
