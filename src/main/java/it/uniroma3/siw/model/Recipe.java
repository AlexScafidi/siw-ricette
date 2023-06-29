package it.uniroma3.siw.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	
	@Column(nullable = false, unique = true)
	@NotBlank
	private String title;
	@Column(nullable = false)
	@NotBlank
	private String text; 
	@Column(nullable = false)
	private boolean isNew; 
	@ManyToOne
	private User author; 
	@ManyToOne
	private Category category; 
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<IngredientQuantity> quantityIngredients; 
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Comment> comments;
	
	public Recipe() {
		this.isNew = true; 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	public User getAutor() {
		return author;
	}

	public void setAutor(User autor) {
		this.author = autor;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<IngredientQuantity> getQuantityIngredients() {
		return quantityIngredients;
	}

	public void setQuantityIngredients(List<IngredientQuantity> quantityIngredients) {
		this.quantityIngredients = quantityIngredients;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	public float getVote() {
		float vote = 0.0f;
		
		for(Comment comment : this.getComments()) vote+=comment.getVote();
		return vote/this.getComments().size(); 
	}

	@Override
	public int hashCode() {
		return Objects.hash(title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recipe other = (Recipe) obj;
		return Objects.equals(title, other.title);
	}
	
	
	
	
}
