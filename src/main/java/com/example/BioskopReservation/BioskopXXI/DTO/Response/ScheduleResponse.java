package com.example.BioskopReservation.BioskopXXI.DTO.Response;


import com.example.BioskopReservation.BioskopXXI.Entity.Film;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ScheduleResponse {

    private String id;
    private LocalDate date;
    private LocalTime startFilm;
    private LocalTime finishFilm;
    private FilmResponse filmResponse;

    @Override
    public String toString() {
        return "ScheduleResponse{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", startFilm=" + startFilm +
                ", finishFilm=" + finishFilm +
                ", filmResponse=" + filmResponse +
                '}';
    }
}
