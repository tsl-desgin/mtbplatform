package com.omtpb.show.repository;

import java.util.List;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.omtpb.show.entity.Shows;

@Repository
public interface ShowRepository extends JpaRepository<Shows, Long> {
	
	@Query("SELECT s FROM Shows s JOIN Theatre t ON s.theatreId = t.id WHERE s.movieId=:movieId AND t.city=:city AND s.showDate=:showDate")
	List<Shows> findByMovieCityAndDate(Long movieId, String city, LocalDate showDate);
		
}
