package com.omtpb.show.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omtpb.show.dto.ShowCreateRequestDTO;
import com.omtpb.show.dto.ShowResponseDTO;
import com.omtpb.show.dto.ShowSearchRequestDTO;
import com.omtpb.show.dto.ShowUpdateRequestDTO;
import com.omtpb.show.service.ShowService;
import com.omtpb.show.dto.TheatreShowDTO;

@RestController
@RequestMapping("/shows/")
public class ShowController {

	@Autowired
	private ShowService showService;
	
	@PostMapping
	public ResponseEntity<List<TheatreShowDTO>> findShows(@RequestBody ShowSearchRequestDTO searchRequestDTO){
		
		return ResponseEntity.ok(showService.findTheatresByMovieAndCityDate(searchRequestDTO));
	}
	
	@PostMapping("create")
	public ResponseEntity<ShowResponseDTO> createShow(@RequestBody ShowCreateRequestDTO showCreateRequestDTO){
		return ResponseEntity.status(HttpStatus.CREATED).body(showService.createShow(showCreateRequestDTO));
	}
	
	@PutMapping("update")
	public ResponseEntity<ShowResponseDTO> updateShow(@RequestBody ShowUpdateRequestDTO showUpdateRequestDTO){
		return ResponseEntity.ok(showService.updateShow(showUpdateRequestDTO));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteShow(@PathVariable("id") Long showId){
		showService.deleteShow(showId);
		return ResponseEntity.noContent().build();
	}
	
}
