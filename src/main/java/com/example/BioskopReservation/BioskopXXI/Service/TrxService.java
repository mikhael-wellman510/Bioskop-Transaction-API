package com.example.BioskopReservation.BioskopXXI.Service;

import com.example.BioskopReservation.BioskopXXI.DTO.Request.TrxRequest;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.TransactionResponse;

public interface TrxService {
    TransactionResponse addTrx (TrxRequest trxRequest);
    TransactionResponse getTrxById(String id);
}
