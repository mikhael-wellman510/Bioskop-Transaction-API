package com.example.BioskopReservation.BioskopXXI.DTO.Request;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class TicketRequest {

    private String id;
    private Double price;
    private Integer stock;
}
