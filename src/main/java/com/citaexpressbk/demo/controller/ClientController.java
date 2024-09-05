package com.citaexpressbk.demo.controller;

import com.citaexpressbk.demo.domain.dto.DataListClient;
import com.citaexpressbk.demo.domain.dto.DataRegisterClient;
import com.citaexpressbk.demo.domain.dto.DataResponseClient;
import com.citaexpressbk.demo.service.interfaces.IClientService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/citaexpress/client")
@SecurityRequirement(name = "bearer-key")
public class ClientController {

    private final IClientService clientService;

    @Autowired
    public ClientController(IClientService clientService) {
        this.clientService = clientService;
    }
    @PostMapping
    public ResponseEntity<DataResponseClient> registerClient(@RequestBody @Valid DataRegisterClient dataRegisterClient, UriComponentsBuilder uriComponentsBuilder) {
        DataResponseClient dataResponseClient = clientService.registerClient(dataRegisterClient);
        URI url = uriComponentsBuilder.path("/clients/{id}").buildAndExpand(dataResponseClient.id()).toUri();
        return ResponseEntity.created(url).body(dataResponseClient);
    }

    @GetMapping
    public ResponseEntity<Page<DataListClient>> listadoClients(@PageableDefault(size = 12, sort = "nombre", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<DataListClient> clientes = clientService.listadoClients(pageable);
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResponseClient> retornandoCliente(@PathVariable Long id) {
        DataResponseClient datosCliente = clientService.getClientById(id);
        return ResponseEntity.ok(datosCliente);
    }//Cambiar por status en FlyWay

    //Retornar actualizacion al cliente
    @PutMapping("/{id}")
    public ResponseEntity<DataResponseClient> actualizarCliente(@PathVariable Long id, @RequestBody @Valid DataResponseClient datosActualizarCliente) {
        datosActualizarCliente = new DataResponseClient(id, datosActualizarCliente.name(), datosActualizarCliente.email(), datosActualizarCliente.document(),
                datosActualizarCliente.address(), datosActualizarCliente.phone());
        DataResponseClient clienteActualizado = clientService.updateClient(datosActualizarCliente);
        return ResponseEntity.ok(clienteActualizado);
    }

    //Delete Logico
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> desactivarClient(@PathVariable Long id) {
        clientService.desactivarClient(id);
        return ResponseEntity.noContent().build();
    }

}
