package com.citaexpressbk.demo.client;

import com.citaexpressbk.demo.domain.entity.Client;

public record DataListClient(
        Long id,
        String nombre,
        String email


) {
public DataListClient(Client client){
this(client.getId(), client.getNombre(), client.getEmail());
}
}
