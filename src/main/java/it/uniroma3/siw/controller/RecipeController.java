package it.uniroma3.siw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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