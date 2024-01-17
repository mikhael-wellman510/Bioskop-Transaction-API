package com.example.BioskopReservation.BioskopXXI.Service.Impl;

import com.example.BioskopReservation.BioskopXXI.DTO.Request.SeatRequest;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.SeatResponse;
import com.example.BioskopReservation.BioskopXXI.Entity.Seat;
import com.example.BioskopReservation.BioskopXXI.Repositori.SeatRepositori;
import com.example.BioskopReservation.BioskopXXI.Service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class SeatServiceImpl implements SeatService {
        private final SeatRepositori seatRepositori;

    @Override
    public SeatResponse addSeat(SeatRequest seatRequest) {

        Seat seat = Seat.builder()
                .noSeat(seatRequest.getNoSeat())
                .build();

            Seat add = seatRepositori.saveAndFlush(seat);
        return SeatResponse.builder()
                .id(add.getId())
                .noSeat(add.getNoSeat())
                .build();
    }

    @Override
    public SeatResponse getSeatById(SeatRequest seatRequest) {
        return null;
    }
}
