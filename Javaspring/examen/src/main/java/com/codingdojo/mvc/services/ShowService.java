package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Show;
import com.codingdojo.mvc.repositories.ShowRepository;



@Service
public class ShowService {
	@Autowired
	private final ShowRepository showRepository;

	public ShowService(ShowRepository showRepository) {
		this.showRepository = showRepository;
	}

	
	public List<Show> getAll(){
		return showRepository.findAll();
	}

	public Show createShow(Show show) {
		return showRepository.save(show);
	}

	public Show findShow(Long id) {
		Optional<Show> optionalShow = showRepository.findById(id);
		if (optionalShow.isPresent()) {
			return optionalShow.get();
		} else {
			return null;
		}
	}

	public Show updateShow(Show show) {
		Optional<Show> optionalShow = showRepository.findById(show.getId());
		if (optionalShow.isPresent()) {
			Show s = optionalShow.get();
			s.setName(show.getName());
			s.setNetwork(show.getNetwork());
			return showRepository.save(s);
		} else {
			return null;
		}
	}

	public void deleteShow(Long id) {
		showRepository.deleteById(id);
	}
	
	public boolean showExists(String showTitle) {
	    return showRepository.existsByName(showTitle);
	}
}
