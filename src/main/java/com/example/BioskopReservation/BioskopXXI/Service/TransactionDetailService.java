package com.example.BioskopReservation.BioskopXXI.Service;

import com.example.BioskopReservation.BioskopXXI.DTO.Request.TransactionDetailRequest;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.TransactionDetailResponse;

public interface TransactionDetailService {

    TransactionDetailResponse createTransaction(TransactionDetailRequest transactionDetailRequest);
}
