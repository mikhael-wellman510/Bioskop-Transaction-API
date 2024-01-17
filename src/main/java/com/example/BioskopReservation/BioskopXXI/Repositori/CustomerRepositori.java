package com.example.BioskopReservation.BioskopXXI.Repositori;

import com.example.BioskopReservation.BioskopXXI.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepositori extends JpaRepository<Customer,String> {


}
