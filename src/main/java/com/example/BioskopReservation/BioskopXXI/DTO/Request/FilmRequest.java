package com.example.BioskopReservation.BioskopXXI.DTO.Request;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class FilmRequest {

    private String id;
    private String title;

    @Override
    public String toString() {
        return "FilmRequest{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
