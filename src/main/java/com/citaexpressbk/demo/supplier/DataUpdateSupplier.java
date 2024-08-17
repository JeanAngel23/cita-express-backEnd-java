package com.citaexpressbk.demo.supplier;

import com.citaexpressbk.demo.direccion.DatosDireccion;
import jakarta.validation.constraints.NotNull;

public record DataUpdateSupplier(@NotNull Long id, String nombre, String telefono, String email, Service service , DatosDireccion direccion) {
}
