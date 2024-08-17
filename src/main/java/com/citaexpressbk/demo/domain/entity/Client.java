package com.citaexpressbk.demo.domain.entity;

import com.citaexpressbk.demo.client.DataRegisterClient;
import com.citaexpressbk.demo.client.DataResponseClient;
import com.citaexpressbk.demo.direccion.Direccion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name= "client")
@Entity(name = "client")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String documento;
    @Embedded
    private Direccion direccion;
    private Boolean status;
    private String telefono;

    public Client(DataRegisterClient dataRegisterClient) {
        this.nombre = dataRegisterClient.nombre();
        this.email = dataRegisterClient.email();
        this.documento = dataRegisterClient.documento();
        this.direccion = new Direccion(dataRegisterClient.direccion());
        this.status = dataRegisterClient.status();
        this.telefono = dataRegisterClient.telefono();


    }

    public void actualizarDatos(DataResponseClient datosActualizarCliente) {
        if (datosActualizarCliente.nombre()!= null){
            this.nombre =datosActualizarCliente.nombre();
        }
        if (datosActualizarCliente.email() != null){
            this.email = datosActualizarCliente.email();
        }
        if (datosActualizarCliente.telefono() != null){
            this.telefono = datosActualizarCliente.telefono();
        }
        if (datosActualizarCliente.direccion() != null){
            this.direccion = direccion.actualizarDireccion(datosActualizarCliente.direccion());
        }

    }

    public void desactivarClient() {
        this.status = false;
    }
}
