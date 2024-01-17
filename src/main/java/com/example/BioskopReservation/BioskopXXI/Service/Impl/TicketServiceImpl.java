package com.example.BioskopReservation.BioskopXXI.Service.Impl;

import com.example.BioskopReservation.BioskopXXI.DTO.Request.TicketRequest;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.TicketResponse;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.TransactionResponse;
import com.example.BioskopReservation.BioskopXXI.Entity.Ticket;
import com.example.BioskopReservation.BioskopXXI.Repositori.TicketRepositori;
import com.example.BioskopReservation.BioskopXXI.Service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepositori ticketRepositori;

    @Override
    public TicketResponse addTicket(TicketRequest ticketRequest) {

        Ticket ticket = Ticket.builder()
                .price(ticketRequest.getPrice())
                .stock(ticketRequest.getStock())
                .build();

        Ticket add = ticketRepositori.saveAndFlush(ticket);
        return TicketResponse.builder()
                .id(add.getId())
                .price(add.getPrice())
                .stock(add.getStock())
                .build();
    }

    @Override
    public TicketResponse getTicketById(String id) {

       Ticket ticket = ticketRepositori.findById(id).orElse(null);

        System.out.println(ticket);
        return TicketResponse.builder()
                .id(ticket.getId())
                .price(ticket.getPrice())
                .stock(ticket.getStock())
                .build();
    }
}
