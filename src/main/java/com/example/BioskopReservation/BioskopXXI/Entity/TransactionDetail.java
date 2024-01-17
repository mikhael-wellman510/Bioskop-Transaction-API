package com.example.BioskopReservation.BioskopXXI.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "t_detail_transaction")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class TransactionDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "total_price" , nullable = false, length = 100)
    private Double totalPrice;

    @Column(name = "total_qty")
    private Integer totalQty;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;


    @ManyToOne
    @JoinColumn(name = "schedule")
    private Schedule schedule;

    @OneToMany(mappedBy = "transactionDetail")
    private List<Seat> seat ;


}
