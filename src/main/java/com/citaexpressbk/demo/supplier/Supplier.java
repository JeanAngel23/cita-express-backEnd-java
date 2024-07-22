package com.citaexpressbk.demo.supplier;

import com.citaexpressbk.demo.direccion.Direccion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name= "supplier")
@Entity(name = "Supplier")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String documento;

    @Embedded
    private Direccion direccion;

    @Enumerated(EnumType.STRING)
    private Service service;

    private Boolean status;
    private String telefono;

    public Supplier(DatosRegistroSupplier datosRegistroSupplier) {
        this.status = true;
        this.nombre = datosRegistroSupplier.nombre();
        this.email = datosRegistroSupplier.email();
        this.documento = datosRegistroSupplier.documento();
        this.direccion = new Direccion(datosRegistroSupplier.direccion());
        this.service = datosRegistroSupplier.service();
        this.telefono = datosRegistroSupplier.telefono();
    }


    public void actualizarDatos(DatosActualizarSupplier datosActualizarSupplier) {
        if (datosActualizarSupplier.nombre() != null) {
            this.nombre = datosActualizarSupplier.nombre();
        }
        if (datosActualizarSupplier.email() != null) {
            this.nombre = datosActualizarSupplier.email();
        }
        if (datosActualizarSupplier.telefono() != null) {
            this.nombre = datosActualizarSupplier.telefono();
        }
        if (datosActualizarSupplier.direccion() != null){
            this.direccion = direccion.actualizarDireccion(datosActualizarSupplier.direccion());
        }
        if (datosActualizarSupplier.service()!=null){
            this.service = datosActualizarSupplier.service();
        }
    }


    public void desactivarSupplier() {
        this.status = false;
    }
}