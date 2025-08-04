package com.omtpb.show.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Getter
//@Setter
public class ShowCreateRequestDTO {
	private Long theatreId;
	private Long movieId;
	private String screenNumber;
	private LocalDate showDate;
	private LocalTime startTime;
	private LocalTime endTime;
	private String language;
	private String genres;
	private double price;
	public Long getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(Long theatreId) {
		this.theatreId = theatreId;
	}
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	public String getScreenNumber() {
		return screenNumber;
	}
	public void setScreenNumber(String screenNumber) {
		this.screenNumber = screenNumber;
	}
	public LocalDate getShowDate() {
		return showDate;
	}
	public void setShowDate(LocalDate showDate) {
		this.showDate = showDate;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getGenres() {
		return genres;
	}
	public void setGenres(String genres) {
		this.genres = genres;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
