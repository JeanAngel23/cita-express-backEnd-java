package com.citaexpressbk.demo.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity(name = "UserRole")
@Table(name = "user_roles") // Asegúrate de que el nombre de la tabla coincide con el nombre en la base de datos
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name", unique = true, nullable = false)
    private String role_name; // Ejemplo: "USER", "ADMIN"
}