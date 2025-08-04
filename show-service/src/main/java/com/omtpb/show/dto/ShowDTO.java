package com.omtpb.show.dto;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ShowDTO {

	private Long showId;
	private String screenNumber;
	private LocalTime startTime;
	private LocalTime endTime;
	private String language;
	private String generes;
	private double price;
	public Long getShowId() {
		return showId;
	}
	public void setShowId(Long showId) {
		this.showId = showId;
	}
	public String getScreenNumber() {
		return screenNumber;
	}
	public void setScreenNumber(String screenNumber) {
		this.screenNumber = screenNumber;
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
	public String getGeneres() {
		return generes;
	}
	public void setGeneres(String generes) {
		this.generes = generes;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
