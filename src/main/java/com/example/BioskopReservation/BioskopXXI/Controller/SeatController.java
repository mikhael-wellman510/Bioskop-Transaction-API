package com.example.BioskopReservation.BioskopXXI.Controller;

import com.example.BioskopReservation.BioskopXXI.Contsant.AppPath.AppPath;
import com.example.BioskopReservation.BioskopXXI.DTO.Request.SeatRequest;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.CommonResponse;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.ScheduleResponse;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.SeatResponse;
import com.example.BioskopReservation.BioskopXXI.Service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppPath.SEAT)
public class SeatController {

    private final SeatService seatService;

    @PostMapping("/add")
    public ResponseEntity<?> addSeat(@RequestBody SeatRequest seatRequest){
        SeatResponse seatResponse = seatService.addSeat(seatRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<SeatResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully crated Controller")
                        .data(seatResponse)
                        .build()) ;
    }
}
