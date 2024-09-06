package com.citaexpressbk.demo.domain.entity;

import com.citaexpressbk.demo.address.Direccion;
import com.citaexpressbk.demo.domain.dto.DataUpdateSupplier;
import com.citaexpressbk.demo.domain.dto.DataRegisterSupplier;
import com.citaexpressbk.demo.enums.Service;
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
    //private String nombre;
    //private String email;
    private String nit;

    @Embedded
    private Direccion direccion;

    @Enumerated(EnumType.STRING)
    private Service service;

    private Boolean status;


    public Supplier(DataRegisterSupplier dataRegisterSupplier) {
        this.status = true;
        //this.nombre = dataRegisterSupplier.nombre();
        //this.email = dataRegisterSupplier.email();
        this.nit = dataRegisterSupplier.nit();
        this.direccion = new Direccion(dataRegisterSupplier.direccion());
        this.service = dataRegisterSupplier.service();
    }

//Method for update info of supplier but i´ts not important

    public void actualizarDatos(DataUpdateSupplier dataUpdateSupplier) {

       // if (dataUpdateSupplier.telefono() != null) {
       //     this.nombre = dataUpdateSupplier.telefono();
       // }
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