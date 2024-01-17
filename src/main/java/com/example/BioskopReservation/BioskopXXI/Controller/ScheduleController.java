package com.example.BioskopReservation.BioskopXXI.Controller;

import com.example.BioskopReservation.BioskopXXI.Contsant.AppPath.AppPath;
import com.example.BioskopReservation.BioskopXXI.DTO.Request.ScheduleRequest;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.CommonResponse;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.CustomerResponse;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.ScheduleResponse;
import com.example.BioskopReservation.BioskopXXI.Service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppPath.SCHEDULE)
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/add")
    public ResponseEntity<?> addSchedule(@RequestBody ScheduleRequest scheduleRequest){

        ScheduleResponse scheduleResponse = scheduleService.addSchedule(scheduleRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<ScheduleResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully crated new Product")
                        .data(scheduleResponse)
                        .build()) ;
    }

}
