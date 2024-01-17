package com.example.BioskopReservation.BioskopXXI.DTO.Response;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CommonResponse<T>{

    private Integer statusCode;
    private String message;
    private T data;

}
