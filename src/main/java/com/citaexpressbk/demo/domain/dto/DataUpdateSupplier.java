package com.citaexpressbk.demo.domain.dto;

import com.citaexpressbk.demo.address.DatosDireccion;
import com.citaexpressbk.demo.enums.Service;
import jakarta.validation.constraints.NotNull;

public record DataUpdateSupplier(@NotNull Long id, Service service, DatosDireccion direccion) {
}
