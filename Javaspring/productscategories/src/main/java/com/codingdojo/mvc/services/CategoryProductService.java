package com.codingdojo.mvc.services;

import java.util.List;

//...
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.CategoryProduct;
import com.codingdojo.mvc.repositories.CategoryProductRepository;

@Service
public class CategoryProductService {
	// Agregando el licencia al repositorio como una dependencia
	private final CategoryProductRepository categoryProductRepository;

	public CategoryProductService(CategoryProductRepository categoryProductRepository) {
		this.categoryProductRepository = categoryProductRepository;
	}


	public List<CategoryProduct> allCategoryProduct() {
		return categoryProductRepository.findAll();
	}


	public CategoryProduct createCategoryProduct(CategoryProduct b) {
		return categoryProductRepository.save(b);
	}

}
