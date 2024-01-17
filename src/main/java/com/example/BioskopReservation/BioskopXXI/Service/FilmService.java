package com.example.BioskopReservation.BioskopXXI.Service;

import com.example.BioskopReservation.BioskopXXI.DTO.Request.FilmRequest;
import com.example.BioskopReservation.BioskopXXI.DTO.Request.ScheduleRequest;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.FilmResponse;

public interface FilmService {
    FilmResponse addFilm(FilmRequest filmRequest);
    FilmResponse getFilmById(String id);
}
