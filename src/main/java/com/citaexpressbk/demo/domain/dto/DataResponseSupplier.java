package com.citaexpressbk.demo.domain.dto;

import com.citaexpressbk.demo.address.DatosDireccion;

public record DataResponseSupplier(Long id, String nit,
                                   String service, DatosDireccion direccion) {
}
