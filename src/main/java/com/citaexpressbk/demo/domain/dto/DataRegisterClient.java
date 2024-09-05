package com.citaexpressbk.demo.domain.dto;

import com.citaexpressbk.demo.address.DatosDireccion;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DataRegisterClient(
        @NotBlank(message = "El nombre del usuario es obligatorio")
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank(message = "El numero de documento es obligatorio")
        @Pattern(regexp = "\\d{6,12}")
        String document,
        @NotNull
        @Valid
        DatosDireccion direccion,//posible error validar
        Boolean status,
        @NotBlank
        @Pattern(regexp = "\\d{6,12}")
        String phone,
        @NotBlank
        String city
) {
}
