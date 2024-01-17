package com.example.BioskopReservation.BioskopXXI.Repositori;

import com.example.BioskopReservation.BioskopXXI.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepositori extends JpaRepository<Transaction,String> {
}
