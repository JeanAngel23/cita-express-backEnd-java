package com.citaexpressbk.demo.domain.dto;

import com.citaexpressbk.demo.domain.entity.Supplier;

public record DataListSupplier(Long id, String nit, String service) {

    public DataListSupplier(Supplier supplier){
        this(supplier.getId(), supplier.getService().toString(), supplier.getNit());
    }
}
