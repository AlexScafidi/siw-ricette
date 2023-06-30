package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.model.Recipe;
import it.uniroma3.siw.service.RecipeService;
import it.uniroma3.siw.service.UserService;
import jakarta.validation.Valid;

@Controller
public class RecipeController {
	
	@Autowired
	private RecipeService recipeService;
	@Autowired 
	private UserService userService; 
	
	@GetMapping(value="/recipes")
	public String getAllRecipes(Model model) {
		model.addAttribute("recipes", this.recipeService.getAllRecipe());
		return "all/recipes.html";
	}
	
	@GetMapping(value="/newRecipes")
	public String getAllNewRecipes(Model model) {
		model.addAttribute("newRecipes", this.recipeService.getAllNewRecipe()); 
		return "all/newRecipes.html";
	}
	
	@GetMapping(value="/formNewRecipe")
	public String showFormNewRecipe(Model model) {
		model.addAttribute("recipe", new Recipe()); 
		return "user/formNewRecipe.html"; 
	}
	
	@PostMapping(value="/formNewRecipe")
	public String newRecipe(@Valid @ModelAttribute("recipe") Recipe recipe, 
			@RequestParam("userDetails") UserDetails userDetails, 
			BindingResult RecipeBindingResult, Model model) {
		
		//controllo di validazione
		if(RecipeBindingResult.hasErrors()) {return "user/formNewRecipe.html";}
		
		//altrimenti salvo,associo all'utente e la mostro la ricetta nella sua pagina
		
		model.addAttribute("recipe", this.recipeService.createNewRecipe(recipe,userDetails)); 
		return "all/recipe.html"; 
	}

}
