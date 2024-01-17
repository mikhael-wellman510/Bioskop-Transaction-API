package com.example.BioskopReservation.BioskopXXI.Service.Impl;

import com.example.BioskopReservation.BioskopXXI.DTO.Request.TrxRequest;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.CustomerResponse;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.TransactionResponse;
import com.example.BioskopReservation.BioskopXXI.Entity.Customer;
import com.example.BioskopReservation.BioskopXXI.Entity.Transaction;
import com.example.BioskopReservation.BioskopXXI.Repositori.CustomerRepositori;
import com.example.BioskopReservation.BioskopXXI.Repositori.TransactionRepositori;
import com.example.BioskopReservation.BioskopXXI.Service.CustomerService;
import com.example.BioskopReservation.BioskopXXI.Service.TrxService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class TrxServiceImpl implements TrxService {
    private final TransactionRepositori transactionRepositori ;
    private final CustomerRepositori customerRepositori;
    private final CustomerService customerService;
    @Override
    public TransactionResponse addTrx(TrxRequest trxRequest) {
        Customer customer = customerRepositori.findById(trxRequest.getCustomerId()).orElse(null);

        Transaction transaction = Transaction.builder()
                        .dateOrder(LocalDate.now())
                        .customer(customer).build();

            Transaction tr = transactionRepositori.saveAndFlush(transaction);
        CustomerResponse cust = customerService.getCustomerById(trxRequest.getCustomerId());

        return TransactionResponse.builder()
                .id(tr.getId())
                .dateOrder(tr.getDateOrder())
                .customerResponse(cust)
                .build();
    }

    @Override
    public TransactionResponse getTrxById(String id) {
        Transaction transaction = transactionRepositori.findById(id).orElse(null);



    CustomerResponse customerResponse = customerService.getCustomerById(transaction.getCustomer().getId());

        return TransactionResponse.builder()
                .id(transaction.getId())
                .dateOrder(LocalDate.now())
                .customerResponse(customerResponse)
                .build();
    }
}
