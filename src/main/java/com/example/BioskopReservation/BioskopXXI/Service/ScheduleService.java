package com.example.BioskopReservation.BioskopXXI.Service;

import com.example.BioskopReservation.BioskopXXI.DTO.Request.ScheduleRequest;
import com.example.BioskopReservation.BioskopXXI.DTO.Response.ScheduleResponse;

public interface ScheduleService {
    ScheduleResponse addSchedule(ScheduleRequest scheduleRequest);
    ScheduleResponse getScheduleById(String id);
}
