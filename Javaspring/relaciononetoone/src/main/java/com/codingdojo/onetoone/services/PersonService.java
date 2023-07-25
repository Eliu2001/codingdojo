package com.codingdojo.onetoone.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.onetoone.models.Person;
import com.codingdojo.onetoone.repositories.PersonRepository;

@Service
public class PersonService {

	private final PersonRepository personRepository;
	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	public List<Person> allPerson(){
		return (List<Person>) personRepository.findAll();
	}
	
	public Person create(Person l) {
		return personRepository.save(l);
	}
	public Person findPerson(Long id) {
		Optional<Person> optionalPerson = personRepository.findById(id);
		if (optionalPerson.isPresent()) {
			return optionalPerson.get();
		}
		else {
			return null;
		}
	}
	public Person update(Long id, Person Person) {
	    Optional<Person> lang = personRepository.findById(id);
	    if (lang.isPresent()) {
	        Person leng = lang.get();
	        leng.setFirstName(Person.getFirstName());
	        leng.setLastName(Person.getLastName());
	        return personRepository.save(leng);
	    } else {
	        throw new IllegalArgumentException("No se encontró ningún lenguaje con el ID proporcionado.");
	    }
	}
	public void delete(Long id) {
		Optional<Person> optionalPerson = personRepository.findById(id);
		if (optionalPerson.isPresent()) {
			personRepository.delete(optionalPerson.get());
			}
		else {
			throw new IllegalArgumentException("El libro con ID " + id + " no existe.");
		}
		}
	public List<Person> personasSinLicencia(){
		return personRepository.findByLicenseIsNull();
	}
}


