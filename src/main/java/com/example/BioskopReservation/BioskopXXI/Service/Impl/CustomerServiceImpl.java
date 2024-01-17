package com.example.BioskopReservation.BioskopXXI.Service.Impl;

import com.example.BioskopReservation.BioskopXXI.Contsant.Gender;
import com.example.BioskopReservation.BioskopXXI.DTO.Request.CustomerRequest;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.CustomerResponse;
import com.example.BioskopReservation.BioskopXXI.Entity.Customer;
import com.example.BioskopReservation.BioskopXXI.Repositori.CustomerRepositori;
import com.example.BioskopReservation.BioskopXXI.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepositori customerRepositori;
    @Override
    public CustomerResponse addCustomer(CustomerRequest customerRequest) {



        Customer addCs = Customer.builder()
                .name(customerRequest.getName())
                .email(customerRequest.getEmail())
                .address(customerRequest.getAddress())
                .gender(customerRequest.getGender())
                .contactNumber(customerRequest.getContactNumber())
                .build();

        Customer add = customerRepositori.saveAndFlush(addCs);


        return CustomerResponse.builder()
                .id(add.getId())
                .name(add.getName())
                .email(add.getEmail())
                .address(add.getAddress())
                .gender(add.getGender())
                .contactNumber(add.getContactNumber())
                .build();
    }

    @Override
    public CustomerResponse getCustomerById(String id) {
        System.out.println("custoreee id : " + id);
        Customer customer = customerRepositori.findById(id).orElse(null);

        System.out.println("hasil : id : " +customer);

        return CustomerResponse.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .address(customer.getAddress())
                .gender(customer.getGender())
                .contactNumber(customer.getContactNumber())
                .build();
    }
}
