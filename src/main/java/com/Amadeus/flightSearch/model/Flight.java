package com.Amadeus.flightSearch.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name = "flight")
@Getter
@Setter
public class Flight {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "from_airport_id", nullable = false)
    private Airport fromAirport;

    @ManyToOne
    @JoinColumn(name = "to_airport_id", nullable = false)
    private Airport toAirport;

    @Column(name = "departure_time", nullable = false)
    private LocalDateTime departureTime;

    @Column(name = "return_time")
    private LocalDateTime returnTime;

    @Column(name = "price")
    private Double price;

    @CreatedDate
    @Column(name="created_at")
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDateTime updateDate;

    @Column(name="deleted_at")
    private LocalDateTime deleteDate;
}
