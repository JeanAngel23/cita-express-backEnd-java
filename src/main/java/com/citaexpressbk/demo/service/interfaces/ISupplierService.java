package com.citaexpressbk.demo.service.interfaces;

import com.citaexpressbk.demo.supplier.DataUpdateSupplier;
import com.citaexpressbk.demo.supplier.DataListSupplier;
import com.citaexpressbk.demo.supplier.DataRegisterSupplier;
import com.citaexpressbk.demo.supplier.DataResponseSupplier;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISupplierService {

    DataResponseSupplier registrarSupplier(DataRegisterSupplier dataRegisterSupplier);

    Page<DataListSupplier> listadoSupplier(Pageable pageable);

    DataResponseSupplier retornarSupplier(Long id);

    DataResponseSupplier updateSupplier(@Valid DataUpdateSupplier dataUpdateSupplier);

    void  desactivarSupplier(Long id);
}
