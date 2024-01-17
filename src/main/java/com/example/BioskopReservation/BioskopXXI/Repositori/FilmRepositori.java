package com.example.BioskopReservation.BioskopXXI.Repositori;

import com.example.BioskopReservation.BioskopXXI.Entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepositori extends JpaRepository<Film,String> {
}
