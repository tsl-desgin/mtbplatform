package com.omtpb.show.service;

import com.omtpb.show.dto.TheatreShowDTO;

import java.util.List;

import com.omtpb.show.dto.ShowCreateRequestDTO;
import com.omtpb.show.dto.ShowResponseDTO;
import com.omtpb.show.dto.ShowSearchRequestDTO;
import com.omtpb.show.dto.ShowUpdateRequestDTO;

public interface ShowService {
	
	List<TheatreShowDTO> findTheatresByMovieAndCityDate(ShowSearchRequestDTO showSearchRequestDTO);
	ShowResponseDTO createShow(ShowCreateRequestDTO showCreateRequestDTO);
	ShowResponseDTO updateShow(ShowUpdateRequestDTO showUpdateRequestDTO);
	void deleteShow(Long showId);
}
