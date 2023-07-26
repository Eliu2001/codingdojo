package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Ninja;
import com.codingdojo.mvc.repositories.NinjaRepository;

@Service
public class NinjaService {

	private final NinjaRepository ninjaRepository;
	
	@Autowired
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	public List<Ninja> allNinja() {
		return ninjaRepository.findAll();
	}
	public Ninja create(Ninja d) {
		return ninjaRepository.save(d);
	}
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		if (optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}

	public Ninja update(Long id, Ninja Ninja) {
		Optional<Ninja> ninja = ninjaRepository.findById(id);
		if (ninja.isPresent()) {
			Ninja doj = ninja.get();
			doj.setFirstName(Ninja.getFirstName());
			doj.setLastName(Ninja.getLastName());
			doj.setAge(Ninja.getAge());
			return ninjaRepository.save(doj);
		} else {
			throw new IllegalArgumentException("No se encontró ningún lenguaje con el ID proporcionado.");
		}
	}

	public void delete(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		if (optionalNinja.isPresent()) {
			ninjaRepository.delete(optionalNinja.get());
		} else {
			throw new IllegalArgumentException("El libro con ID " + id + " no existe.");
		}
	}
	public Ninja save(Ninja Ninja) {
		return ninjaRepository.save(Ninja);
	}
}

