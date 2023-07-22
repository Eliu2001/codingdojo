package com.codingdojo.language.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.language.models.Language;
import com.codingdojo.language.repositories.LanguageRepository;
@Service
public class LanguageService {

	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	public List<Language> allLanguage(){
		return languageRepository.findAll();
	}
	public Language create(Language l) {
		return languageRepository.save(l);
	}
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if (optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		}
		else {
			return null;
		}
	}
	public Language update(Long id, Language language) {
	    Optional<Language> lang = languageRepository.findById(id);
	    if (lang.isPresent()) {
	        Language leng = lang.get();
	        leng.setName(language.getName());
	        leng.setCreator(language.getCreator());
	        leng.setCurrentVersion(language.getCurrentVersion());
	        return languageRepository.save(leng);
	    } else {
	        throw new IllegalArgumentException("No se encontró ningún lenguaje con el ID proporcionado.");
	    }
	}
	public void delete(Long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if (optionalLanguage.isPresent()) {
			languageRepository.delete(optionalLanguage.get());
			}
		else {
			throw new IllegalArgumentException("El libro con ID " + id + " no existe.");
		}
		}
	
}
