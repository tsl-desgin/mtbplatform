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
public class ShowUpdateRequestDTO {

	private Long theatreId;
	private Long showId;
	private String screenNumber;
	private LocalTime startTime;
	private LocalTime endTime;
	private double price;
	private String language;
	private String genres;
}
