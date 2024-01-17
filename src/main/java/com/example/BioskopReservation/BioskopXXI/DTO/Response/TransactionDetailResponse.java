package com.example.BioskopReservation.BioskopXXI.DTO.Response;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class TransactionDetailResponse {
    private String id;
    private Double totalPrice;
    private Integer totalQty;
    private ScheduleResponse scheduleResponse;
    private TicketResponse ticketResponse;
    private TransactionResponse transactionResponse;
}
