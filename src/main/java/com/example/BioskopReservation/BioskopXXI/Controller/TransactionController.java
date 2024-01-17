package com.example.BioskopReservation.BioskopXXI.Controller;

import com.example.BioskopReservation.BioskopXXI.Contsant.AppPath.AppPath;
import com.example.BioskopReservation.BioskopXXI.DTO.Request.TransactionDetailRequest;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.CommonResponse;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.TicketResponse;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.TransactionDetailResponse;
import com.example.BioskopReservation.BioskopXXI.Service.TransactionDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppPath.TRANSACTION)
public class TransactionController {

    private final TransactionDetailService transactionDetailService;

    @PostMapping("/add")
    public ResponseEntity<?> createTransaction(@RequestBody TransactionDetailRequest transactionDetailRequest){
        TransactionDetailResponse transactionDetailResponse = transactionDetailService.createTransaction(transactionDetailRequest);

        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<TransactionDetailResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully crated Ticket")
                        .data(transactionDetailResponse)
                        .build()) ;
    }

}
