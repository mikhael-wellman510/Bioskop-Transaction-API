package com.example.BioskopReservation.BioskopXXI.DTO.Request;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class SeatRequest {
    private String id;
    private Integer noSeat;
}
