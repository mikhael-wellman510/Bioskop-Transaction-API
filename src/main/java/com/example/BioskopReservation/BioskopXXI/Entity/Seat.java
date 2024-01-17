package com.example.BioskopReservation.BioskopXXI.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "m_seat")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id ;

    @Column(nullable = false , length = 40)
    private Integer noSeat;


    @ManyToOne
    @JoinColumn(name = "transaction_detail_id")
    private TransactionDetail transactionDetail;

    @Override
    public String toString() {
        return "Seat{" +
                "id='" + id + '\'' +
                ", noSeat=" + noSeat +
                ", transactionDetail=" + transactionDetail +
                '}';
    }
}
