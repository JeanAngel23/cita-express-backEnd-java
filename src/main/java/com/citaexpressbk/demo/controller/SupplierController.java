package com.citaexpressbk.demo.controller;

import com.citaexpressbk.demo.service.interfaces.ISupplierService;
import com.citaexpressbk.demo.supplier.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final ISupplierService supplierService;

    @Autowired
    public SupplierController(ISupplierService supplierService) {
        this.supplierService = supplierService;
    }
    @PostMapping
    public ResponseEntity<DataResponseSupplier> registrarSupplier(@RequestBody @Valid DataRegisterSupplier dataRegisterSupplier, UriComponentsBuilder uriComponentsBuilder){
        DataResponseSupplier dataResponseSupplier = supplierService.registrarSupplier(dataRegisterSupplier);
        URI url = uriComponentsBuilder.path("/supplier/{id}").buildAndExpand(dataResponseSupplier.id()).toUri();
        return ResponseEntity.created(url).body(dataResponseSupplier);
    }
    @GetMapping
    public ResponseEntity<Page<DataListSupplier>> listadoSupplier(@PageableDefault(size = 10)Pageable pageable){
        Page<DataListSupplier> suppliers = supplierService.listadoSupplier(pageable);
        return ResponseEntity.ok(suppliers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResponseSupplier> retornarSupplier (@PathVariable Long id){
        DataResponseSupplier datosSuplier = supplierService.retornarSupplier(id);
        return ResponseEntity.ok(datosSuplier);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResponseSupplier> actualizarSupplier(@PathVariable Long id, @RequestBody @Valid DataUpdateSupplier dataUpdateSupplier) {
        dataUpdateSupplier = new DataUpdateSupplier(id, dataUpdateSupplier.nombre(), dataUpdateSupplier.email(), dataUpdateSupplier.telefono(),
                dataUpdateSupplier.service(), dataUpdateSupplier.direccion());
        DataResponseSupplier supplierActualizado = supplierService.updateSupplier(dataUpdateSupplier);
        return ResponseEntity.ok(supplierActualizado);
    }

    //Delete Logico

    @DeleteMapping("/{id}")
    public ResponseEntity desactivarSupplier(@PathVariable Long id){
        supplierService.desactivarSupplier(id);
        return ResponseEntity.noContent().build();
    }
//Recordar url de Swagger localhost:8080/swagger-ui.html

}

