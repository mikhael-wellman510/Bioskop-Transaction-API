package com.example.BioskopReservation.BioskopXXI.Service;

import com.example.BioskopReservation.BioskopXXI.DTO.Request.CustomerRequest;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.CustomerResponse;

public interface CustomerService {

    CustomerResponse addCustomer(CustomerRequest customerRequest);
    CustomerResponse getCustomerById(String id);
}
