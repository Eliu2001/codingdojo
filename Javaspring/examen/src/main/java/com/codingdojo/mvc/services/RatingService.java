package com.codingdojo.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Rating;
import com.codingdojo.mvc.repositories.RatingRepository;

@Service
public class RatingService {

	@Autowired
	private RatingRepository ratingRepository;
	
	public List<Object[]> getRatingByID(Long showId) {
	    List<Object[]> calificaciones = ratingRepository.nombreRatingPorId(showId);
	    return calificaciones;
	}
	
	public Rating createRating(Rating rating) {
		return ratingRepository.save(rating);
	}
	public List<Double> averageByRating(Long showId){
		List<Double> promedio = ratingRepository.promedioRating(showId);
		return promedio;
	}
	
	
}
