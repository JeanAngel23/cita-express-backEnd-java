package com.citaexpressbk.demo.supplier;

import com.citaexpressbk.demo.domain.entity.Supplier;

public record DataListSupplier(Long id, String nombre, String service, String email) {

    public DataListSupplier(Supplier supplier){
        this(supplier.getId(), supplier.getNombre(), supplier.getService().toString(), supplier.getEmail());
    }
}
