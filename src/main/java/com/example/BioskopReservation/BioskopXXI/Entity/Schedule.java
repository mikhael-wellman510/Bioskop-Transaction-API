package com.example.BioskopReservation.BioskopXXI.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "m_schedule")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id ;


    @Column(nullable = false , length = 40)
    private LocalDate date;

    @Column(name = "start_film" , nullable = false , length = 50)
    private LocalTime startFilm;

    @Column(name = "finish_film" , nullable = false , length = 30)
    private LocalTime finsihFilm;

    // Todo -> Film itu 1 hari ada beberapa tayang

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @OneToMany(mappedBy = "schedule")
    private List<TransactionDetail> transactionDetails;

//
//    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
//
//    LocalDate parsedDate = LocalDate.parse(jadwalRequest.getDate(), dateFormatter);
//    LocalTime parsedStartFilm = LocalTime.parse(jadwalRequest.getStartFilm(), timeFormatter);
//    LocalTime parsedFinishFilm = LocalTime.parse(jadwalRequest.getFinishFilm(), timeFormatter);


    @Override
    public String toString() {
        return "Schedule{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", startFilm=" + startFilm +
                ", finsihFilm=" + finsihFilm +
                ", film=" + film +
                ", transactionDetails=" + transactionDetails +
                '}';
    }
}
