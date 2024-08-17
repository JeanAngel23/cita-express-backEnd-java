package com.citaexpressbk.demo.service.interfaces;

import com.citaexpressbk.demo.client.DataListClient;
import com.citaexpressbk.demo.client.DataRegisterClient;
import com.citaexpressbk.demo.client.DataResponseClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IClientService {

    DataResponseClient registerClient(DataRegisterClient dataRegisterClient);

    Page<DataListClient> listadoClients(Pageable pageable);

    DataResponseClient getClientById(Long id);

    DataResponseClient updateClient(DataResponseClient datosActualizarCliente);

    void desactivarClient(Long id);
}
