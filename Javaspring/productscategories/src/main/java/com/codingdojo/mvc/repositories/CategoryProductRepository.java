package com.codingdojo.mvc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.models.CategoryProduct;

//...
@Repository
public interface CategoryProductRepository extends CrudRepository<CategoryProduct, Long> {

	List<CategoryProduct> findAll();
	
	Integer countBy();

	Optional<CategoryProduct> findById(Long id);

}
