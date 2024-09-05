package com.citaexpressbk.demo.service.interfaces;

import com.citaexpressbk.demo.domain.dto.DataUpdateSupplier;
import com.citaexpressbk.demo.domain.dto.DataListSupplier;
import com.citaexpressbk.demo.domain.dto.DataRegisterSupplier;
import com.citaexpressbk.demo.domain.dto.DataResponseSupplier;
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
