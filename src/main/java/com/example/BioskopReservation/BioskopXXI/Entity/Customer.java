package com.example.BioskopReservation.BioskopXXI.Entity;


import com.example.BioskopReservation.BioskopXXI.Contsant.Gender;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "m_customer")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id ;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false , length = 50)
    private String email;

    @Column(nullable = false , length = 50)
    private String address;

    @Column(name = "gender", nullable = false , length = 50)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "contact_number" , nullable = false  , length = 50)
    private String contactNumber;


    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
