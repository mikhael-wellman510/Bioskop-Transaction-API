package com.example.BioskopReservation.BioskopXXI.Service.Impl;

import com.example.BioskopReservation.BioskopXXI.DTO.Request.FilmRequest;
import com.example.BioskopReservation.BioskopXXI.DTO.Request.ScheduleRequest;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.FilmResponse;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.ScheduleResponse;
import com.example.BioskopReservation.BioskopXXI.Entity.Film;
import com.example.BioskopReservation.BioskopXXI.Entity.Schedule;
import com.example.BioskopReservation.BioskopXXI.Repositori.FilmRepositori;
import com.example.BioskopReservation.BioskopXXI.Repositori.ScheduleRepositori;
import com.example.BioskopReservation.BioskopXXI.Service.FilmService;
import com.example.BioskopReservation.BioskopXXI.Service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepositori scheduleRepositori;
    private final FilmRepositori filmRepositori;


    @Override
    public ScheduleResponse addSchedule(ScheduleRequest scheduleRequest) {

        // Todo get Film By Id
        Film idFilm = filmRepositori.findById(scheduleRequest.getIdFilm()).orElse(null);
        System.out.println(idFilm);


        // Todo -> Translate Date
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate parseDate = LocalDate.parse(scheduleRequest.getDate(), dateFormat);

        // Todo -> Transalate Start Film
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime parseStartFilm = LocalTime.parse(scheduleRequest.getStartFilm(),timeFormatter);

        // Todo -> Transalate Finish Film

       LocalTime parseFinishFilm = LocalTime.parse(scheduleRequest.getFinishFilm(),timeFormatter);

        // Todo -> Add Schedule
        Schedule schedule = Schedule.builder()
                .date(parseDate)
                .startFilm(parseStartFilm)
                .finsihFilm(parseFinishFilm)
                .film(Film.builder()
                        .id(idFilm.getId())
                        .title(idFilm.getTitle())
                        .build())
                .build();

        Schedule addSchedule = scheduleRepositori.saveAndFlush(schedule);




        return ScheduleResponse.builder()
                .id(addSchedule.getId())
                .date(addSchedule.getDate())
                .startFilm(addSchedule.getStartFilm())
                .finishFilm(addSchedule.getFinsihFilm())
                .filmResponse(FilmResponse.builder()
                        .id(addSchedule.getFilm().getId())
                        .title(addSchedule.getFilm().getTitle())
                        .build())
                .build();
    }

    @Override
    public ScheduleResponse getScheduleById(String id) {
        System.out.println("id: " + id);
        Schedule schedule = scheduleRepositori.findById(id).orElse(null);

        System.out.println("schedules : " + schedule);
//        // Todo -> Translate Date
//        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        LocalDate parseDate = LocalDate.parse(schedule.getDate(), dateFormat);
//
//        // Todo -> Transalate Start Film
//        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
//        LocalTime parseStartFilm = LocalTime.parse(scheduleRequest.getStartFilm(),timeFormatter);
//
//        // Todo -> Transalate Finish Film
//
//        LocalTime parseFinishFilm = LocalTime.parse(scheduleRequest.getFinishFilm(),timeFormatter);
        return ScheduleResponse.builder()
                .id(schedule.getId())
                .date(schedule.getDate())
                .startFilm(schedule.getStartFilm())
                .finishFilm(schedule.getFinsihFilm())
                .filmResponse(FilmResponse.builder()
                        .id(schedule.getFilm().getId())
                        .title(schedule.getFilm().getTitle())
                        .build())
                .build();
    }
}
