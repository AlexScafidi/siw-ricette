package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.uniroma3.siw.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/categories")
	public String getAllCategories(Model model) {
		 model.addAttribute("categories", this.categoryService.findAll());
		 return "categories.html";
	}

}
