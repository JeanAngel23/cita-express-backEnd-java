package com.citaexpressbk.demo.client;

import com.citaexpressbk.demo.direccion.DatosDireccion;
import jakarta.validation.constraints.NotNull;

public record DatosRespuestaClient(@NotNull Long id, String nombre, String email, String documento, DatosDireccion direccion, String telefono) {
    public static record DatosActualizarCliente() {
    }
}
