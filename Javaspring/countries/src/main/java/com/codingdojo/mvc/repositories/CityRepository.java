package com.codingdojo.mvc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.models.City;

@Repository
public interface CityRepository extends CrudRepository<City, Integer>{

	@Query("SELECT ci.name, ci.population, ci.country.id FROM City ci WHERE ci.country.name = 'Mexico' AND ci.population > 500000 ORDER BY ci.population DESC")
	List<Object[]> findCitiesInMexicoWithPopulationGreaterThan500000OrderByPopulationDesc();

}
