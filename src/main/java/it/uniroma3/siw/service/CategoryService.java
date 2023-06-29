package it.uniroma3.siw.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Category;
import jakarta.transaction.Transactional;

@Service
public class CategoryService {

	@Autowired CategoryRepository categoryRepository; 
	
	
	@Transactional
	public newCategoty(Category category) {
		//il validatore controlla
		this.categoryRepository.save(category); 
	}
	
	@Transactional
	public saveCategory(Category category) {
		//il validatore controlla
		return this.categoryRepository.save(category); 
	}
	
	@Transactional
	public List<Category> getAllCategories() {
		List<Category> categories = new LinkedList<>(); 
		for(Category cat : this.categoryRepository.findAll()) categories.add(cat); 
		return categories; 
	}
}
