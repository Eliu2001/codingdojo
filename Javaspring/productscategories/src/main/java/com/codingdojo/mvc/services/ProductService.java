package com.codingdojo.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Category;
import com.codingdojo.mvc.models.Product;
import com.codingdojo.mvc.repositories.ProductRepository;

@Service
public class ProductService {
	// Agregando el persona al repositorio como una dependencia
	private final ProductRepository productRepository;
	
	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	// Devolviendo todos los personas.
	public List<Product> allProduct() {
		return productRepository.findAll();
	}
	public Product encontrarProductPorId(Long id) {
		return productRepository.findById(id).get();
	}

	// Creando un persona.
	public Product createProduct(Product b) {
		return productRepository.save(b);
	}
	
	public List<Product> categoriasnulas(Category category) {
		return productRepository.findByCategoriesNotContains(category);
	}


}