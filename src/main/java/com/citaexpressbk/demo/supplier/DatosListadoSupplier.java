package com.citaexpressbk.demo.supplier;

public record DatosListadoSupplier(Long id, String nombre, String service, String email) {

    public DatosListadoSupplier(Supplier supplier){
        this(supplier.getId(), supplier.getNombre(), supplier.getService().toString(), supplier.getEmail());
    }
}
