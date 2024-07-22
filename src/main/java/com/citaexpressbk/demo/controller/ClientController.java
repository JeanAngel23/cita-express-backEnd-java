package com.citaexpressbk.demo.controller;

import com.citaexpressbk.demo.client.*;
import com.citaexpressbk.demo.direccion.DatosDireccion;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
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

    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    @PostMapping
    public ResponseEntity <DatosRespuestaClient>registerClient(@RequestBody @Valid DatosRegister datosRegister, UriComponentsBuilder uriComponentsBuilder ){
        Client client = clientRepository.save(new Client(datosRegister));
        DatosRespuestaClient datosRespuestaClient = new DatosRespuestaClient(client.getId(), client.getNombre(), client.getEmail(), client.getDocumento(),
                new DatosDireccion(client.getDireccion().getCalle(), client.getDireccion().getCiudad(), client.getDireccion().getDistrito()),client.getTelefono());
        URI url = uriComponentsBuilder.path("/client/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaClient);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoClient>>listadoClients(@PageableDefault(size = 12, sort = "nombre", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok(clientRepository.findByStatusTrue(pageable).map(DatosListadoClient::new));
        //Cambiar por Status una vez creada la tabla con FLYw
    }
    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaClient> retornandoCliente(@PathVariable Long id){
        Client client =clientRepository.getReferenceById(id);
        var datosCliente = new DatosRespuestaClient(client.getId(), client.getNombre(), client.getEmail(), client.getDocumento(),
                new DatosDireccion(client.getDireccion().getCalle(), client.getDireccion().getCiudad(), client.getDireccion().getDistrito()),client.getTelefono());
        return ResponseEntity.ok(datosCliente);
    }

    //Retornar actualizacion al cliente
    @PutMapping
    @Transactional
    public ResponseEntity actualizarCliente(@RequestBody @Valid DatosRespuestaClient datosActualizarCliente) {
        Client client = clientRepository.getReferenceById(datosActualizarCliente.id());
        client.actualizarDatos(datosActualizarCliente);
        return ResponseEntity.ok(new DatosRespuestaClient(client.getId(), client.getNombre(), client.getEmail(), client.getDocumento(),
                new DatosDireccion(client.getDireccion().getCalle(), client.getDireccion().getCiudad(), client.getDireccion().getDistrito()), client.getTelefono()));
    }

    //Delete Logico
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity desactivarClient(@PathVariable Long id){
        Client client = clientRepository.getReferenceById(id);
        client.desactivarClient();
        return ResponseEntity.noContent().build();
    }

}
