package com.citaexpressbk.demo.service.interfaces;

import com.citaexpressbk.demo.client.DatosListadoClient;
import com.citaexpressbk.demo.client.DatosRegister;
import com.citaexpressbk.demo.client.DatosRespuestaClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IClientService {

    DatosRespuestaClient registerClient(DatosRegister datosRegister);

    Page<DatosListadoClient> listadoClients(Pageable pageable);

    DatosRespuestaClient getClientById(Long id);

    DatosRespuestaClient updateClient(DatosRespuestaClient datosActualizarCliente);

    void desactivarClient(Long id);
}
