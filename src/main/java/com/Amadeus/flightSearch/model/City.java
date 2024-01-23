package com.Amadeus.flightSearch.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "city")
@Getter
@Setter
public class City {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @NotBlank(message = "city name can't be empty")
    @Column(name = "name", nullable = false)
    private String name;

    @CreatedDate
    @Column(name="created_at")
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDateTime updateDate;

    @Column(name="deleted_at")
    private LocalDateTime deleteDate;
}
