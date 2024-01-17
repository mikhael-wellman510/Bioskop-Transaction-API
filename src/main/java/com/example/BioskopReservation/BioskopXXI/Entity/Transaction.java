package com.example.BioskopReservation.BioskopXXI.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "m_transaction")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Transaction {



    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id ;

    @Column(name = "date_order" , nullable = false)
    private LocalDate dateOrder;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private  Customer customer;



    @OneToMany(mappedBy = "transaction" , cascade = CascadeType.ALL)
    private List<TransactionDetail> transactionDetails;

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", dateOrder=" + dateOrder +
                ", customer=" + customer +
                ", transactionDetails=" + transactionDetails +
                '}';
    }
}
