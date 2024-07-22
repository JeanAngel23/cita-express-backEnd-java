package com.citaexpressbk.demo.controller;

import com.citaexpressbk.demo.direccion.DatosDireccion;
import com.citaexpressbk.demo.supplier.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/citaexpress/supplier")
@SecurityRequirement(name = "bearer-key")
public class SupplierController {

    private final SupplierRepository supplierRepository;

    public SupplierController(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DatosRespuestaSupplier> registrarSupplier(@RequestBody @Valid DatosRegistroSupplier datosRegistroSupplier,
                                                                    UriComponentsBuilder uriComponentsBuilder){
        Supplier supplier = supplierRepository.save(new Supplier(datosRegistroSupplier));
        DatosRespuestaSupplier datosRespuestaSupplier = new DatosRespuestaSupplier(supplier.getId(), supplier.getNombre(),supplier.getEmail(),supplier.getTelefono(),supplier.getDocumento(),
                supplier.getService().toString(),
                new DatosDireccion(supplier.getDireccion().getCalle(), supplier.getDireccion().getCiudad(), supplier.getDireccion().getDistrito()));
        URI url = uriComponentsBuilder.path("/supplier{id}").buildAndExpand(supplier.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaSupplier);
    }
    @GetMapping
    public ResponseEntity<Page<DatosListadoSupplier>> listadoSupplier(@PageableDefault(size = 10)Pageable pageable){
        return ResponseEntity.ok(supplierRepository.findByStatusTrue(pageable).map(DatosListadoSupplier::new));
    }
    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaSupplier> retornarSupplier (@PathVariable Long id){
        Supplier supplier = supplierRepository.getReferenceById(id);
        var datosSuplier = new DatosRespuestaSupplier(supplier.getId(), supplier.getNombre(),supplier.getEmail(),supplier.getTelefono(),supplier.getDocumento(),
                supplier.getService().toString(),
                new DatosDireccion(supplier.getDireccion().getCalle(), supplier.getDireccion().getCiudad(), supplier.getDireccion().getDistrito()));
        return ResponseEntity.ok(datosSuplier);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarSupplier(@RequestBody @Valid DatosActualizarSupplier datosActualizarSupplier) {
        Supplier supplier = supplierRepository.getReferenceById(datosActualizarSupplier.id());
        supplier.actualizarDatos(datosActualizarSupplier);
        return ResponseEntity.ok(new DatosRespuestaSupplier(supplier.getId(), supplier.getNombre(),supplier.getEmail(),supplier.getTelefono(),supplier.getDocumento(),
                supplier.getService().toString(),
                new DatosDireccion(supplier.getDireccion().getCalle(), supplier.getDireccion().getCiudad(),supplier.getDireccion().getDistrito())));
    }

    //Delete Logico

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity desactivarSupplier(@PathVariable Long id){
        Supplier supplier = supplierRepository.getReferenceById(id);
        supplier.desactivarSupplier();
        return ResponseEntity.noContent().build();
    }
//Recordar url de Swagger localhost:8080/swagger-ui.html

}

