package com.citaexpressbk.demo.service;

import com.citaexpressbk.demo.client.*;
import com.citaexpressbk.demo.direccion.DatosDireccion;
import com.citaexpressbk.demo.domain.entity.Client;
import com.citaexpressbk.demo.service.interfaces.IClientService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements IClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public DataResponseClient registerClient(DataRegisterClient dataRegisterClient) {
        Client client = clientRepository.save(new Client(dataRegisterClient));
        return new DataResponseClient(client.getId(), client.getNombre(), client.getEmail(), client.getDocumento(),
                new DatosDireccion(client.getDireccion().getCalle(), client.getDireccion().getCiudad(), client.getDireccion().getDistrito()), client.getTelefono());
    }

    @Override
    public Page<DataListClient> listadoClients(Pageable pageable) {
        return clientRepository.findByStatusTrue(pageable).map(DataListClient::new);
    }

    @Override
    public DataResponseClient getClientById(Long id) {
        Client client = clientRepository.getReferenceById(id);
        return new DataResponseClient(client.getId(), client.getNombre(), client.getEmail(), client.getDocumento(),
                new DatosDireccion(client.getDireccion().getCalle(), client.getDireccion().getCiudad(), client.getDireccion().getDistrito()), client.getTelefono());
    }

    @Override
    @Transactional
    public DataResponseClient updateClient(DataResponseClient datosActualizarCliente) {
        Client client = clientRepository.getReferenceById(datosActualizarCliente.id());
        client.actualizarDatos(datosActualizarCliente);
        return new DataResponseClient(client.getId(), client.getNombre(), client.getEmail(), client.getDocumento(),
                new DatosDireccion(client.getDireccion().getCalle(), client.getDireccion().getCiudad(), client.getDireccion().getDistrito()), client.getTelefono());
    }

    @Override
    @Transactional
    public void desactivarClient(Long id) {
        Client client = clientRepository.getReferenceById(id);
        client.desactivarClient();
    }
}
