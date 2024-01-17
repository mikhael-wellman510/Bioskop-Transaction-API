package com.example.BioskopReservation.BioskopXXI.Controller;


import com.example.BioskopReservation.BioskopXXI.Contsant.AppPath.AppPath;
import com.example.BioskopReservation.BioskopXXI.DTO.Request.TrxRequest;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.CommonResponse;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.TicketResponse;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.TransactionResponse;
import com.example.BioskopReservation.BioskopXXI.Service.TrxService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppPath.TRX)
public class TrxController {

    private final TrxService trxService ;

    @PostMapping(value = "/add")
    public ResponseEntity<?> addTrx(@RequestBody TrxRequest trxRequest){
        TransactionResponse transactionResponse = trxService.addTrx(trxRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<TransactionResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully crated Transaction")
                        .data(transactionResponse)
                        .build()) ;
    }

//    public ResponseEntity<?> getTrxById()

}
