package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.uniroma3.siw.service.RecipeService;

@Controller
public class RecipeController {
	
	@Autowired
	private RecipeService recipeService;
	
	@GetMapping("/recipes")
	public String getAllRecipes(Model model) {
		model.addAttribute("recipes", this.recipeService.findAll());
		return "recipes.html";
	}
	
}
