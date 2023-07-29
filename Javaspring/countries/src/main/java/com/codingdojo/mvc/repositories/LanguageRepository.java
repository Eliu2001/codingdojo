package com.codingdojo.mvc.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.mvc.models.Language;

public interface LanguageRepository extends CrudRepository<Language, Integer>{

}
