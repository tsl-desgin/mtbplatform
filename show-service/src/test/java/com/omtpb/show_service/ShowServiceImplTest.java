package com.omtpb.show_service;

import com.omtpb.show.dto.ShowSearchRequestDTO;
import com.omtpb.show.dto.ShowCreateRequestDTO;
import com.omtpb.show.dto.ShowDTO;
import com.omtpb.show.dto.ShowResponseDTO;
import com.omtpb.show.dto.TheatreShowDTO;
import com.omtpb.show.entity.Shows;
import com.omtpb.show.entity.Theatre;
import com.omtpb.show.mapper.ShowMapper;
import com.omtpb.show.repository.ShowRepository;
import com.omtpb.show.service.ShowService;
import com.omtpb.show.service.impl.ShowServiceImpl;

import jakarta.persistence.EntityManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ShowServiceImplTest {

    @Mock
    private ShowRepository showRepository;

    @Mock
    private EntityManager entityManager;

    @Mock
    private ShowMapper showMapper;

    @InjectMocks
    private ShowServiceImpl showService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindTheatresByMovieAndCityAndDate() {
        // Given
        Long movieId = 101L;
        String city = "Bangalore";
        LocalDate showDate = LocalDate.of(2025, 8, 3);

        ShowSearchRequestDTO requestDTO = new ShowSearchRequestDTO();
        requestDTO.setMovieId(movieId);
        requestDTO.setCity(city);
        requestDTO.setShowDate(showDate);

        Shows show1 = new Shows();
        show1.setId(1L);
        show1.setMovieId(movieId);
        show1.setTheatreId(1L);
        show1.setShowDate(showDate);
        show1.setStartTime(LocalTime.of(14, 0));
        show1.setEndTime(LocalTime.of(16, 0));
        show1.setScreenNumber("1");
        show1.setLanguage("English");
        show1.setPrice(300);

        Theatre theatre = new Theatre();
        theatre.setId(1L);
        theatre.setName("PVR Koramangala");
        theatre.setAddress("Koramangala");
        theatre.setCity(city);

        ShowDTO timingDTO = new ShowDTO();
        timingDTO.setShowId(1L);
        timingDTO.setStartTime(LocalTime.of(14, 0));
        timingDTO.setEndTime(LocalTime.of(16, 0));
        timingDTO.setScreenNumber("1");
        timingDTO.setLanguage("English");
        timingDTO.setPrice(300);

        when(showRepository.findByMovieCityAndDate(movieId, city, showDate))
                .thenReturn(List.of(show1));
        when(entityManager.find(Theatre.class, 1L)).thenReturn(theatre);
        when(showMapper.toShowDTO(show1)).thenReturn(timingDTO);

        // When
        List<TheatreShowDTO> results = showService.findTheatresByMovieAndCityDate(requestDTO);

        // Then
        assertThat(results).hasSize(1);
        TheatreShowDTO dto = results.get(0);
        assertThat(dto.getTheatreId()).isEqualTo(1L);
        assertThat(dto.getTheatreName()).isEqualTo("PVR Koramangala");
        assertThat(dto.getShows()).hasSize(1);
        assertThat(dto.getShows().get(0).getPrice()).isEqualTo(300.0);

        verify(showRepository).findByMovieCityAndDate(movieId, city, showDate);
        verify(entityManager).find(Theatre.class, 1L);
        verify(showMapper).toShowDTO(show1);
    }
    
    @Test
    void testCreateShow() {
        ShowCreateRequestDTO dto = new ShowCreateRequestDTO();
        dto.setMovieId(1L);
        dto.setScreenNumber("1");
        dto.setShowDate(LocalDate.now());
        dto.setStartTime(LocalTime.of(14, 0));
        dto.setEndTime(LocalTime.of(16, 0));
        dto.setLanguage("English");
        dto.setPrice(250.0);

        Shows saved = new Shows();
        saved.setId(1L);
        saved.setTheatreId(101L);

        when(showRepository.save(any())).thenReturn(saved);
        when(showMapper.toResponseDTO(any())).thenReturn(new ShowResponseDTO());

        ShowResponseDTO result = showService.createShow(dto);
        org.junit.jupiter.api.Assertions.assertNotNull(result);
    }
}

