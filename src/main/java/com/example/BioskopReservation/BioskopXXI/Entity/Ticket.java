package com.example.BioskopReservation.BioskopXXI.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "m_ticket")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false,length = 30)
    private Double price;
    @Column(nullable = false, length = 30)
    private Integer stock;

    @OneToMany(mappedBy = "ticket")
    private List<TransactionDetail> transactionDetails;

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", transactionDetails=" + transactionDetails +
                '}';
    }
}
