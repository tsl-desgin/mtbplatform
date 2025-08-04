package com.omtpb.show.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omtpb.show.dto.ShowCreateRequestDTO;
import com.omtpb.show.dto.ShowResponseDTO;
import com.omtpb.show.dto.ShowSearchRequestDTO;
import com.omtpb.show.dto.ShowUpdateRequestDTO;
import com.omtpb.show.dto.TheatreShowDTO;
import com.omtpb.show.entity.Shows;
import com.omtpb.show.entity.Theatre;
import com.omtpb.show.mapper.ShowMapper;
import com.omtpb.show.repository.ShowRepository;
import com.omtpb.show.service.ShowService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ShowServiceImpl implements ShowService{

	@Autowired
	private final ShowRepository showRepository;
	@Autowired
	private ShowMapper showMapper;
	@Autowired
	private EntityManager entityManager;
	
	public ShowServiceImpl(ShowRepository showRepository,ShowMapper showMapper, EntityManager entityManager) {
	    this.showMapper = showMapper;
		this.showRepository = showRepository;
		this.entityManager = entityManager;
	}
	
	@Override
	public List<TheatreShowDTO> findTheatresByMovieAndCityDate(ShowSearchRequestDTO showSearchRequestDTO) {
		
		List<Shows> shows = showRepository.findByMovieCityAndDate(showSearchRequestDTO.getMovieId(),showSearchRequestDTO.getCity(),showSearchRequestDTO.getShowDate());
		Map<Long, TheatreShowDTO> grouped = new HashMap<>();
		
		for(Shows show: shows) {
			
			Theatre theatre = entityManager.find(Theatre.class, show.getTheatreId());		
			TheatreShowDTO theatreShowDTO = grouped.computeIfAbsent(theatre.getId(), id -> {
				TheatreShowDTO newTheatreShowDTO = new TheatreShowDTO();
				newTheatreShowDTO.setTheatreId(theatre.getId());
				newTheatreShowDTO.setTheatreName(theatre.getName());
				newTheatreShowDTO.setAddress(theatre.getAddress());
				newTheatreShowDTO.setShows(new ArrayList<>());
				return newTheatreShowDTO;
			});
			
			theatreShowDTO.getShows().add(showMapper.toShowDTO(show));
		}
		return new ArrayList<>(grouped.values());
	}

	
	@Override
	public ShowResponseDTO createShow(ShowCreateRequestDTO showCreateRequestDTO) {
		
		Shows shows = new Shows();
		shows.setTheatreId(showCreateRequestDTO.getTheatreId());
		shows.setMovieId(showCreateRequestDTO.getMovieId());
		shows.setScreenNumber(showCreateRequestDTO.getScreenNumber());
		shows.setShowDate(showCreateRequestDTO.getShowDate());
		shows.setStartTime(showCreateRequestDTO.getStartTime());
		shows.setEndTime(showCreateRequestDTO.getEndTime());
		shows.setCreatedAt(LocalDateTime.now());
		return showMapper.toResponseDTO(showRepository.save(shows));
	}

	@Override
	public ShowResponseDTO updateShow(ShowUpdateRequestDTO showUpdateRequestDTO) {
		
		Shows shows = showRepository.findById(showUpdateRequestDTO.getShowId()).orElseThrow(() -> new EntityNotFoundException("Show not found"));
		shows.setScreenNumber(showUpdateRequestDTO.getScreenNumber());
		shows.setStartTime(showUpdateRequestDTO.getStartTime());
		shows.setEndTime(showUpdateRequestDTO.getEndTime());
		shows.setPrice(showUpdateRequestDTO.getPrice());
		shows.setLanguage(showUpdateRequestDTO.getLanguage());
		shows.setGenres(showUpdateRequestDTO.getGenres());
		shows.setUpdatedAt(LocalDateTime.now());
		return showMapper.toResponseDTO(showRepository.save(shows));
	}

	@Override
	public void deleteShow(Long showId) {
		
		if(!showRepository.existsById(showId)) {
			throw new EntityNotFoundException("Show not found");
		}
		showRepository.deleteById(showId);
	}
}
