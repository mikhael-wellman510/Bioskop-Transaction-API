package com.example.BioskopReservation.BioskopXXI.Controller;


import com.example.BioskopReservation.BioskopXXI.Contsant.AppPath.AppPath;
import com.example.BioskopReservation.BioskopXXI.DTO.Request.CustomerRequest;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.CommonResponse;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.CustomerResponse;
import com.example.BioskopReservation.BioskopXXI.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppPath.CUSTOMER)
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<?> createCustomer(@RequestBody CustomerRequest customerRequest){
        CustomerResponse customerResponse = customerService.addCustomer(customerRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<CustomerResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully crated Customer")
                        .data(customerResponse)
                        .build()) ;
    }
}
