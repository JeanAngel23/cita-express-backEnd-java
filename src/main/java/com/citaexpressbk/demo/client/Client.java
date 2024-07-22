package com.citaexpressbk.demo.client;

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

    public Client(DatosRegister datosRegister) {
        this.nombre = datosRegister.nombre();
        this.email = datosRegister.email();
        this.documento = datosRegister.documento();
        this.direccion = new Direccion(datosRegister.direccion());
        this.status = datosRegister.status();
        this.telefono = datosRegister.telefono();


    }

    public void actualizarDatos(DatosRespuestaClient datosActualizarCliente) {
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
