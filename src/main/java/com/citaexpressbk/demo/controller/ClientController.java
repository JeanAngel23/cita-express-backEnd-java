package com.citaexpressbk.demo.controller;

import com.citaexpressbk.demo.client.*;
import com.citaexpressbk.demo.direccion.DatosDireccion;
import com.citaexpressbk.demo.service.interfaces.IClientService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
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
    public ResponseEntity<DatosRespuestaClient> registerClient(@RequestBody @Valid DatosRegister datosRegister, UriComponentsBuilder uriComponentsBuilder) {
        DatosRespuestaClient datosRespuestaClient = clientService.registerClient(datosRegister);
        URI url = uriComponentsBuilder.path("/clients/{id}").buildAndExpand(datosRespuestaClient.id()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaClient);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoClient>> listadoClients(@PageableDefault(size = 12, sort = "nombre", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<DatosListadoClient> clientes = clientService.listadoClients(pageable);
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaClient> retornandoCliente(@PathVariable Long id) {
        DatosRespuestaClient datosCliente = clientService.getClientById(id);
        return ResponseEntity.ok(datosCliente);
    }//Cambiar por status en FlyWay

    //Retornar actualizacion al cliente
    @PutMapping("/{id}")
    public ResponseEntity<DatosRespuestaClient> actualizarCliente(@PathVariable Long id, @RequestBody @Valid DatosRespuestaClient datosActualizarCliente) {
        datosActualizarCliente = new DatosRespuestaClient(id, datosActualizarCliente.nombre(), datosActualizarCliente.email(), datosActualizarCliente.documento(),
                datosActualizarCliente.direccion(), datosActualizarCliente.telefono());
        DatosRespuestaClient clienteActualizado = clientService.updateClient(datosActualizarCliente);
        return ResponseEntity.ok(clienteActualizado);
    }

    //Delete Logico
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> desactivarClient(@PathVariable Long id) {
        clientService.desactivarClient(id);
        return ResponseEntity.noContent().build();
    }

}
