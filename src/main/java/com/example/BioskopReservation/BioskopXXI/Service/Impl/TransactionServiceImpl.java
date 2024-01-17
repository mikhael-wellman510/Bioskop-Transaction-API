package com.example.BioskopReservation.BioskopXXI.Service.Impl;

import com.example.BioskopReservation.BioskopXXI.DTO.Request.TransactionDetailRequest;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.*;
import com.example.BioskopReservation.BioskopXXI.Entity.*;
import com.example.BioskopReservation.BioskopXXI.Repositori.*;
import com.example.BioskopReservation.BioskopXXI.Service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionDetailService {

    private final TransactionDetailRepositori transactionDetailRepositori;
    private final ScheduleService scheduleService;
    private final CustomerService customerService;
    private final TrxService trxService;
    private final TicketService ticketService;
    private final TransactionRepositori transactionRepositori;
    private final TicketRepositori ticketRepositori ;
    private final ScheduleRepositori scheduleRepositori;
    private final SeatRepositori seatRepositori;
    @Override
    public TransactionDetailResponse createTransaction(TransactionDetailRequest transactionDetailRequest) {
        System.out.println(transactionDetailRequest);
        // Todo -> Schedule id
        ScheduleResponse scheduleResponse = scheduleService.getScheduleById(transactionDetailRequest.getScheduleId());
        Schedule schedule = scheduleRepositori.findById(transactionDetailRequest.getScheduleId()).orElse(null);
        //        System.out.println("hasil : " + scheduleResponse);

        // todo -> Customer Id
        CustomerResponse customerResponse = customerService.getCustomerById(transactionDetailRequest.getCustomerId());
//        System.out.println(customerResponse);
        // todo -> Transaction Id
        TransactionResponse transactionResponse = trxService.getTrxById(transactionDetailRequest.getTransactionId());
        Transaction transaction = transactionRepositori.findById(transactionDetailRequest.getTransactionId()).orElse(null);

        // Todo -> Ticket id
        TicketResponse ticketResponse = ticketService.getTicketById(transactionDetailRequest.getTicketId());
        Ticket ticket = ticketRepositori.findById(transactionDetailRequest.getTicketId()).orElse(null);

        // Todo -> Mengurangi Stok Ticket
        Integer stock = ticket.getStock() - transactionDetailRequest.getSeat().size();
        System.out.println("stock : " + stock);
        ticket.setStock(stock);
        ticketRepositori.save(ticket);

        // Todo detail Transaction
        Integer quantity = transactionDetailRequest.getSeat().size();
        Double totalPrice = ticketResponse.getPrice() * quantity;

        TransactionDetail transactionDetail = TransactionDetail.builder()
                .totalPrice(totalPrice )
                .totalQty(transactionDetailRequest.getSeat().size())
                .transaction(transaction)
                .ticket(ticket)
                .schedule(schedule)
                .build();
        TransactionDetail td = transactionDetailRepositori.saveAndFlush(transactionDetail);

        // Todo -> M seat
        List<Seat> seats =  transactionDetailRequest.getSeat().stream().map(tdr->
                         Seat.builder()
                    .noSeat(tdr.getNoSeat())
                    .transactionDetail(transactionDetail)
                    .build()
        ).toList();

       List<Seat> addSeat= seatRepositori.saveAllAndFlush(seats);

        return TransactionDetailResponse.builder()
                .id(transactionDetail.getId())
                .totalPrice(totalPrice)
                .totalQty(quantity)
                .scheduleResponse(scheduleResponse)
                .ticketResponse(ticketResponse)
                .transactionResponse(transactionResponse)
                .build();
    }
}
