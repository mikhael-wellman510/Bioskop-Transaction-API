package com.example.BioskopReservation.BioskopXXI.Service.Impl;

import com.example.BioskopReservation.BioskopXXI.DTO.Request.FilmRequest;
import com.example.BioskopReservation.BioskopXXI.DTO.Request.ScheduleRequest;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.FilmResponse;
import com.example.BioskopReservation.BioskopXXI.Entity.Film;
import com.example.BioskopReservation.BioskopXXI.Repositori.FilmRepositori;
import com.example.BioskopReservation.BioskopXXI.Service.FilmService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {

    private final FilmRepositori filmRepositori;

    @Override
    public FilmResponse addFilm(FilmRequest filmRequest) {


        Film film = Film.builder()
                .title(filmRequest.getTitle())
                .build();

        Film add = filmRepositori.saveAndFlush(film);
        return FilmResponse.builder()
                .id(add.getId())
                .title(add.getTitle())

                .build();
    }

    @Override
    public FilmResponse getFilmById(String id) {
        return null;
    }
}
