package com.codingdojo.mvc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.models.Category;
import com.codingdojo.mvc.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	// Este método recupera todos los libros de la base de datos
	List<Category> findAll();
	
	Optional<Category> findById(Long id);
	
	List<Category> findByProductsNotContains(Product Product);

	CategoryRepository save(CategoryRepository b);
	
	
}