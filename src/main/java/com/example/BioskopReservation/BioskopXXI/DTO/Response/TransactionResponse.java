package com.example.BioskopReservation.BioskopXXI.DTO.Response;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class TransactionResponse {
    private String id;
    private LocalDate dateOrder ;
    private CustomerResponse customerResponse;

    @Override
    public String toString() {
        return "TransactionResponse{" +
                "id='" + id + '\'' +
                ", dateOrder=" + dateOrder +
                ", customerResponse=" + customerResponse +
                '}';
    }
}
