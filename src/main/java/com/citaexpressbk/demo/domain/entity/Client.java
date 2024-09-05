package com.citaexpressbk.demo.domain.entity;

import com.citaexpressbk.demo.domain.dto.DataRegisterClient;
import com.citaexpressbk.demo.domain.dto.DataResponseClient;
import com.citaexpressbk.demo.address.Direccion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name= "Clients")
@Entity(name = "Client")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String document;
    @Embedded
    private Direccion direccion;
    private Boolean status;
    private String phone;


    public Client(DataRegisterClient dataRegisterClient) {
        this.name = dataRegisterClient.name();
        this.email = dataRegisterClient.email();
        this.document = dataRegisterClient.document();
        this.direccion = new Direccion(dataRegisterClient.direccion());
        this.status = dataRegisterClient.status();
        this.phone = dataRegisterClient.phone();


    }

    public void actualizarDatos(DataResponseClient datosActualizarCliente) {
        if (datosActualizarCliente.name()!= null){
            this.name =datosActualizarCliente.name();
        }
        if (datosActualizarCliente.email() != null){
            this.email = datosActualizarCliente.email();
        }
        if (datosActualizarCliente.phone() != null){
            this.phone = datosActualizarCliente.phone();
        }
        if (datosActualizarCliente.address() != null){
            this.direccion = direccion.actualizarDireccion(datosActualizarCliente.address());
        }

    }

    public void desactivarClient() {
        this.status = false;
    }
}
