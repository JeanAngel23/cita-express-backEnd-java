package com.citaexpressbk.demo.domain.dto;

import com.citaexpressbk.demo.domain.entity.Client;

public record DataListClient(
        Long id,
        String name,
        String email


) {
public DataListClient(Client client){
this(client.getId(), client.getName(), client.getEmail());
}
}
