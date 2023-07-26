package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Dojo;
import com.codingdojo.mvc.repositories.DojoRepository;


@Service
public class DojoService {
	private final DojoRepository dojoRepository;
	
	@Autowired
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	public List<Dojo> allDojo() {
		return dojoRepository.findAll();
	}
	public Dojo create(Dojo d) {
		return dojoRepository.save(d);
	}
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}

	public Dojo update(Long id, Dojo Dojo) {
		Optional<Dojo> dojo = dojoRepository.findById(id);
		if (dojo.isPresent()) {
			Dojo doj = dojo.get();
			return dojoRepository.save(doj);
		} else {
			throw new IllegalArgumentException("No se encontró ningún lenguaje con el ID proporcionado.");
		}
	}

	public void delete(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if (optionalDojo.isPresent()) {
			dojoRepository.delete(optionalDojo.get());
		} else {
			throw new IllegalArgumentException("El libro con ID " + id + " no existe.");
		}
	}
	public Dojo save(Dojo Dojo) {
		return dojoRepository.save(Dojo);
	}
}
