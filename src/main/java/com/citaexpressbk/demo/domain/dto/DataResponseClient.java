package com.citaexpressbk.demo.domain.dto;

import com.citaexpressbk.demo.address.DatosDireccion;
import jakarta.validation.constraints.NotNull;

public record DataResponseClient(@NotNull Long id, String name, String email, String document, DatosDireccion address, String phone) {
    public static record DatosActualizarCliente() {
    }
}
