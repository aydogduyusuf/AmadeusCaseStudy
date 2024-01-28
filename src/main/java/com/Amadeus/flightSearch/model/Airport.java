package com.Amadeus.flightSearch.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "airport")
@Getter
@Setter
public class Airport {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Size(min = 3, max = 3, message = "airport code must be 3 characters long")
    @Column(name = "airport_code", nullable = false, unique = true)
    private String code;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @CreatedDate
    @Column(name="created_at")
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDateTime updateDate;

    @Column(name="deleted_at")
    private LocalDateTime deleteDate;
}
