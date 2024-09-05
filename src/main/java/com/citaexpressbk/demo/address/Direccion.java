package com.citaexpressbk.demo.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Direccion {

    private String address;
    private String city;

    public Direccion(DatosDireccion direccion) {
        this.address = direccion.address();
        this.city = direccion.city();
    }

    public Direccion actualizarDireccion(DatosDireccion direccion) {
        this.address = direccion.address();
        this.city = direccion.city();
        return this;
    }
}
