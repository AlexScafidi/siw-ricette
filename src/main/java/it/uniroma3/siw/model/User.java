package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	
	@Column(nullable = false)
	@NotBlank
	private String name;
	
	@Column(nullable = false)
	@NotBlank
	private String surname;
	
	@Column(nullable = false, unique = true)
	@NotBlank
	@Email
	private String email;

	
	@Column(nullable = false)
	@PastOrPresent
	private LocalDate dateOfBirth; 
	
	@Column(nullable = false)
	@PastOrPresent
	private LocalDateTime dateOfregistration;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	private Address address;
	
	@OneToMany(mappedBy = "author")
	private List<Recipe> recipes;

	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSurname() {
		return surname;
	}



	public void setSurname(String surname) {
		this.surname = surname;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	public LocalDateTime getDateOfregistration() {
		return dateOfregistration;
	}



	public void setDateOfregistration(LocalDateTime dateOfregistration) {
		this.dateOfregistration = dateOfregistration;
	}



	public List<Recipe> getRecipes() {
		return recipes;
	}



	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email);
	} 
	
	

}
