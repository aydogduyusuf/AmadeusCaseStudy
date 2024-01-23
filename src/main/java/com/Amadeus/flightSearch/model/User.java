package com.Amadeus.flightSearch.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name="user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @NotBlank(message = "Password is required")
    @Column(name="password")
    private String password;

    @NotBlank(message = "Email is required")
    @Column(name="email", unique = true)
    private String email;

    @CreatedDate
    @Column(name="created_at")
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDateTime updateDate;

    @Column(name="deleted_at")
    private LocalDateTime deleteDate;
}
