package com.example.BioskopReservation.BioskopXXI.DTO.Request;

import com.example.BioskopReservation.BioskopXXI.Entity.Seat;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class TransactionDetailRequest {

    private String id;
    private String customerId ;
    private String scheduleId ;

    private String ticketId;
    private String transactionId;

    private List<Seat> seat;

    @Override
    public String toString() {
        return "TransactionDetailRequest{" +
                "id='" + id + '\'' +
                ", customerId='" + customerId + '\'' +
                ", scheduleId='" + scheduleId + '\'' +
                ", ticketId='" + ticketId + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", seat=" + seat +
                '}';
    }
}
