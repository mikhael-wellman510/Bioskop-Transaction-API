package com.example.BioskopReservation.BioskopXXI.DTO.Response;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class TicketResponse {

    private String id;
    private Double price;
    private Integer stock;

    @Override
    public String toString() {
        return "TicketResponse{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
