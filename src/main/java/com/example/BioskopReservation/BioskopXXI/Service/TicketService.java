package com.example.BioskopReservation.BioskopXXI.Service;

import com.example.BioskopReservation.BioskopXXI.DTO.Request.TicketRequest;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.TicketResponse;

public interface TicketService {
    TicketResponse addTicket(TicketRequest ticketRequest);
    TicketResponse getTicketById(String id);
}
