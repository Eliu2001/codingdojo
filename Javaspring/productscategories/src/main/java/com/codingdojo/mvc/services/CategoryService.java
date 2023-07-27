package com.codingdojo.mvc.services;

import java.util.List;
//...
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Category;
import com.codingdojo.mvc.models.Product;
import com.codingdojo.mvc.repositories.CategoryRepository;

import jakarta.validation.Valid;

@Service
public class CategoryService {
	// Agregando el book al repositorio como una dependencia
	private final CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public List<Category> allCategories() {
		return categoryRepository.findAll();
	}

	public List<Category> categoriasnulas(Product product) {
		return categoryRepository.findByProductsNotContains(product);
	}
	

	public @Valid Category createCategory(@Valid Category category) {
		return categoryRepository.save(category);
	}

	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}

	public Category encontrarcategoriaPorId(Long id) {
		return categoryRepository.findById(id).get();
	}

}
