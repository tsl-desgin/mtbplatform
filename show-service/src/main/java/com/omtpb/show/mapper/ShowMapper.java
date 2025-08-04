package com.omtpb.show.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

import com.omtpb.show.dto.ShowDTO;
import com.omtpb.show.dto.ShowResponseDTO;
import com.omtpb.show.entity.Shows;

@Mapper(componentModel = "spring")
public abstract class ShowMapper {
	
	@Mapping(source="id",target="showId")
	public abstract ShowDTO toShowDTO(Shows shows);
	
	public abstract ShowResponseDTO toResponseDTO(Shows shows);
	
}
