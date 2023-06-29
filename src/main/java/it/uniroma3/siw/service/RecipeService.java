package it.uniroma3.siw.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Category;
import it.uniroma3.siw.model.Recipe;
import jakarta.transaction.Transactional;

@Service
public class RecipeService {

	@Autowired RecipeRepository categoryRepository; 
	
	
	@Transactional
	public newRecipe(Recipe recipe) {
		//il validatore controlla
		this.recipeRepository.save(recipe); 
	}
	
	@Transactional
	public saveRecipe(Recipe recipe) {
		//il validatore controlla
		return this.recipeRepository.save(recipe); 
	}
	
	@Transactional
	public List<Recipe> getAllRecipe() {
		List<Recipe> recipes = new LinkedList<>(); 
		for(Recipe rec : this.recipeRepository.findAll())  recipes.add(rec); 
		return recipes; 
	}
	
	@Transational
	public List<Recipe> getAllNewRecipe() {
		List<Recipe> recipes = new LinkedList<>(); 
		for(Recipe rec : this.recipeRepository.findAllNewRecipes())  recipes.add(rec); 
		return recipes; 
	}
}
