package com.example.BioskopReservation.BioskopXXI.Controller;

import com.example.BioskopReservation.BioskopXXI.Contsant.AppPath.AppPath;
import com.example.BioskopReservation.BioskopXXI.DTO.Request.FilmRequest;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.CommonResponse;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.CustomerResponse;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.FilmResponse;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.ScheduleResponse;
import com.example.BioskopReservation.BioskopXXI.Service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppPath.FILM)
public class FilmController {

    private final FilmService filmService;

    @PostMapping("/add")
    public ResponseEntity<?> addFilm(@RequestBody FilmRequest filmRequest){
FilmResponse filmResponse = filmService.addFilm(filmRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<FilmResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully crated new Film")
                        .data(filmResponse)
                        .build()) ;
    }
}
