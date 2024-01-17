package com.example.BioskopReservation.BioskopXXI.DTO.Request;

import com.example.BioskopReservation.BioskopXXI.Entity.Film;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ScheduleRequest {

    private String id;
    private String date ;
    private String startFilm;
    private String finishFilm;

    // Todo -> Film
    private String idFilm;


}
