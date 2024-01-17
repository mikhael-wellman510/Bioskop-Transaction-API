package com.example.BioskopReservation.BioskopXXI.DTO.Response;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class SeatResponse {
    private String id;
    private Integer noSeat;

}
