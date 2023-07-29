package com.codingdojo.mvc.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.mvc.repositories.CityRepository;
import com.codingdojo.mvc.repositories.CountryRepository;
import com.codingdojo.mvc.repositories.LanguageRepository;

@Service
public class ApiService {

	 private final CountryRepository countryR;
	 private final CityRepository cityR;
	 private final LanguageRepository langR;
	 
	 public ApiService(CountryRepository countryR, CityRepository cityR, LanguageRepository langR) {
		 this.countryR = countryR;
		 this.cityR = cityR;
		 this.langR = langR;
	 }
	 //Aqui se llama a los paises que hablan Esloveno para enviarlos al homecontrolller
	 public List<Object[]> countriesSlovene(){
		 List<Object[]> table = countryR.findCountriesWithSloveneLanguageOrderByPercentageDesc();
		 return table;
	 }
	 public List<Object[]> countryAndCities(){
		 List<Object[]> table = countryR.findCountryNamesWithCitiesCountOrderByCitiesTotalDesc();
		 return table;
	 }
	 public List<Object[]> citiesInMexico(){
		 List<Object[]> table = cityR.findCitiesInMexicoWithPopulationGreaterThan500000OrderByPopulationDesc();
		 return table;
	 }
	 public List<Object[]> findCountriesWithLanguagesPercentageGreaterThan89OrderByPercentageDesc(){
		 List<Object[]> table = countryR.findCountriesWithLanguagesPercentageGreaterThan89OrderByPercentageDesc();
		 return table;
	 }
	 public List<Object[]> findCountriesWithSurfaceAreaLessThan501AndPopulationGreaterThan100000(){
		 List<Object[]> table = countryR.findCountriesWithSurfaceAreaLessThan501AndPopulationGreaterThan100000();
		 return table;
	 }
	 public List<Object[]> findCountriesWithGovernmentFormAndCapitalAndLifeExpectancy(){
		 List<Object[]> table = countryR.findCountriesWithGovernmentFormAndCapitalAndLifeExpectancy();
		 return table;
	 }
	 public List<Object[]> findCitiesInBuenosAires(){
		 List<Object[]> table = countryR.findCitiesInBuenosAires();
		 return table;
	 }
	 public List<Object[]> countCountriesByRegion(){
		 List<Object[]> table = countryR.countCountriesByRegion();
		 return table;
	 }
}
 