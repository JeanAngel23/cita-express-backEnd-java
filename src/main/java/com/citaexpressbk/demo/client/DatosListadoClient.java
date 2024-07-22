package com.citaexpressbk.demo.client;

public record DatosListadoClient(
        Long id,
        String nombre,
        String email


) {
public DatosListadoClient(Client client){
this(client.getId(), client.getNombre(), client.getEmail());
}
}
