package com.example.BioskopReservation.BioskopXXI.Controller;

import com.example.BioskopReservation.BioskopXXI.Contsant.AppPath.AppPath;
import com.example.BioskopReservation.BioskopXXI.DTO.Request.TicketRequest;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.CommonResponse;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.ScheduleResponse;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.TicketResponse;
import com.example.BioskopReservation.BioskopXXI.Service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppPath.TICKET)
public class TicketController {

    private final TicketService ticketService;

    @PostMapping("/add")
    public ResponseEntity<?> addTicket(@RequestBody TicketRequest ticketRequest){
        TicketResponse ticketResponse = ticketService.addTicket(ticketRequest);

        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<TicketResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully crated Ticket")
                        .data(ticketResponse)
                        .build()) ;
    }
}
