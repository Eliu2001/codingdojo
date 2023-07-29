package com.codingdojo.mvc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.models.Country;
@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>{

	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.language = 'Slovene' ORDER BY l.percentage DESC")
	List<Object[]> findCountriesWithSloveneLanguageOrderByPercentageDesc();
	
	@Query("SELECT c.name, COUNT(ci.id) AS cities_total FROM Country c JOIN c.cities ci GROUP BY c.name ORDER BY cities_total DESC")
	List<Object[]> findCountryNamesWithCitiesCountOrderByCitiesTotalDesc();
	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.percentage > 89 ORDER BY l.percentage DESC")
	List<Object[]> findCountriesWithLanguagesPercentageGreaterThan89OrderByPercentageDesc();
	@Query("SELECT c.name, c.surfaceArea, c.population FROM Country c WHERE c.surfaceArea < 501 AND c.population > 100000")
	List<Object[]> findCountriesWithSurfaceAreaLessThan501AndPopulationGreaterThan100000();
	@Query("SELECT c.name, c.governmentForm, c.capital, c.lifeExpectancy FROM Country c WHERE c.governmentForm = 'Constitutional Monarchy' AND c.capital > 200 AND c.lifeExpectancy > 75")
	List<Object[]> findCountriesWithGovernmentFormAndCapitalAndLifeExpectancy();
	@Query("SELECT c.name, ct.name, ct.district, ct.population FROM Country c JOIN c.cities ct WHERE c.name = 'Argentina' AND ct.district = 'Buenos Aires' AND ct.population > 500000")
	List<Object[]> findCitiesInBuenosAires();
	@Query("SELECT c.region, COUNT(c.name) as countries FROM Country c GROUP BY c.region ORDER BY COUNT(c.name) DESC")
	List<Object[]> countCountriesByRegion();






}
