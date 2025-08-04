package com.omtpb.show.dto;

import java.util.List;

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
public class TheatreShowDTO {
	
	private Long theatreId;
	private String theatreName;
	private String address;
	private List<ShowDTO> shows;
	public Long getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(Long theatreId) {
		this.theatreId = theatreId;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<ShowDTO> getShows() {
		return shows;
	}
	public void setShows(List<ShowDTO> shows) {
		this.shows = shows;
	}
	
	
}
