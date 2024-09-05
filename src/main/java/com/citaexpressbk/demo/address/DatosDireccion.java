package com.citaexpressbk.demo.address;

import jakarta.validation.constraints.NotBlank;

public record DatosDireccion(
        @NotBlank
        String address,
        @NotBlank
        String city) {
}
