package com.codingdojo.mvc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.models.Rating;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long>{
	@Query("SELECT AVG(r.rating) FROM Rating r WHERE r.show.id = :showId")
	List<Double> promedioRating( Long showId); //Se pide el promedio de los Rating
	
	@Query("SELECT u.name, r.rating FROM Rating r JOIN r.user u WHERE r.show.id = :showId ORDER BY r.rating ASC")
	List<Object[]> nombreRatingPorId(Long showId);
	//Obtiene los datos de la tabla para el rating
	
	
	
}
