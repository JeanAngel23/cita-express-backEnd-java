package com.citaexpressbk.demo.domain.entity;

import com.citaexpressbk.demo.direccion.Direccion;
import com.citaexpressbk.demo.supplier.DataUpdateSupplier;
import com.citaexpressbk.demo.supplier.DataRegisterSupplier;
import com.citaexpressbk.demo.supplier.Service;
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

    public Supplier(DataRegisterSupplier dataRegisterSupplier) {
        this.status = true;
        this.nombre = dataRegisterSupplier.nombre();
        this.email = dataRegisterSupplier.email();
        this.documento = dataRegisterSupplier.documento();
        this.direccion = new Direccion(dataRegisterSupplier.direccion());
        this.service = dataRegisterSupplier.service();
        this.telefono = dataRegisterSupplier.telefono();
    }


    public void actualizarDatos(DataUpdateSupplier dataUpdateSupplier) {
        if (dataUpdateSupplier.nombre() != null) {
            this.nombre = dataUpdateSupplier.nombre();
        }
        if (dataUpdateSupplier.email() != null) {
            this.nombre = dataUpdateSupplier.email();
        }
        if (dataUpdateSupplier.telefono() != null) {
            this.nombre = dataUpdateSupplier.telefono();
        }
        if (dataUpdateSupplier.direccion() != null){
            this.direccion = direccion.actualizarDireccion(dataUpdateSupplier.direccion());
        }
        if (dataUpdateSupplier.service()!=null){
            this.service = dataUpdateSupplier.service();
        }
    }


    public void desactivarSupplier() {
        this.status = false;
    }
}