package it.uniroma3.siw.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.uniroma3.siw.model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

	@Query(nativeQuery = true,
			value="select * from recipe where is_new = true")
	public Iterable<Recipe> findAllNewRecipes();
	
	@Query(nativeQuery = true, 
			value="select * from recipe where title like %:name%")
	public Iterable<Recipe> findAllRecipesThatContainInTheTitle(@Param("name") String name);
	

}
