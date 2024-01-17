package com.example.BioskopReservation.BioskopXXI.Service;

import com.example.BioskopReservation.BioskopXXI.DTO.Request.SeatRequest;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.SeatResponse;

public interface SeatService {
    SeatResponse addSeat(SeatRequest seatRequest);
    SeatResponse getSeatById(SeatRequest seatRequest);
}
