package com.example.BioskopReservation.BioskopXXI.DTO.Response;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class FilmResponse {
    private String id;
    private String title;

    @Override
    public String toString() {
        return "FilmResponse{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
