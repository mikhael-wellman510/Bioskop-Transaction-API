package com.example.BioskopReservation.BioskopXXI.DTO.Request;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class TrxRequest {

    private String customerId;
}
