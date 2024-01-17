package com.example.BioskopReservation.BioskopXXI.Repositori;

import com.example.BioskopReservation.BioskopXXI.Entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepositori extends JpaRepository<Schedule,String> {
}
