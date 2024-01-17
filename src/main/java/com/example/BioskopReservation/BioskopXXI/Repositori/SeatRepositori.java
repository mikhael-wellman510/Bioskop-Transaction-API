package com.example.BioskopReservation.BioskopXXI.Repositori;

import com.example.BioskopReservation.BioskopXXI.Entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepositori extends JpaRepository<Seat,String> {
}
