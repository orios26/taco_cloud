package com.rios.tacocloud;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rios.tacocloud.Ingredient.Type;

import lombok.extern.slf4j.Slf4j;

import com.rios.tacocloud.Ingredient;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

	@GetMapping
	public String showDesignForm(Model model) {
		List<Ingredient> ingredients = Arrays.asList(
				new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
				new Ingredient("COTO", "Corn Tortilla", Type.WRAP),				
				new Ingredient("FJTA", "Fajita", Type.PROTEIN),				
				new Ingredient("CARN", "Carnitas", Type.PROTEIN),				
				new Ingredient("ONIO", "Onion", Type.VEGGIES),				
				new Ingredient("CLTR", "Cilantro", Type.VEGGIES),				
				new Ingredient("QSFR", "Queso Fresco", Type.CHEESE),				
				new Ingredient("MTJK", "Monterrey Jack", Type.CHEESE),				
				new Ingredient("CRMA", "Crema", Type.SAUCE),
				new Ingredient("SLVR", "Salsa Verde", Type.SAUCE)
				);
		
		
		Type[] types = Ingredient.Type.values();
		for (Type type: types) {
			model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
		}
		
		model.addAttribute("design", new Taco());
		return "design";
		
	}
	
	@PostMapping
	public String processTaco(@Valid Taco design, Errors errors) {
		if (errors.hasErrors()) {
			return "design";
		}
		//save le taco
		return "redirect:/orders/current";
	}
	
	private List<Ingredient> filterByType(List <Ingredient> ingredients, Type type) {
		return ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
	}
}
