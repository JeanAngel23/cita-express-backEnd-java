package com.citaexpressbk.demo.service.interfaces;

import com.citaexpressbk.demo.domain.dto.DataListClient;
import com.citaexpressbk.demo.domain.dto.DataRegisterClient;
import com.citaexpressbk.demo.domain.dto.DataResponseClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IClientService {

    DataResponseClient registerClient(DataRegisterClient dataRegisterClient);

    Page<DataListClient> listadoClients(Pageable pageable);

    DataResponseClient getClientById(Long id);

    DataResponseClient updateClient(DataResponseClient datosActualizarCliente);

    void desactivarClient(Long id);
}
