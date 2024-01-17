package com.example.BioskopReservation.BioskopXXI.DTO.Request;

import com.example.BioskopReservation.BioskopXXI.Contsant.Gender;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CustomerRequest {

    private String id;
    private String name;
    private String email;
    private String address;
    private Gender gender;
    private String contactNumber;

    @Override
    public String toString() {
        return "CustomerRequest{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
