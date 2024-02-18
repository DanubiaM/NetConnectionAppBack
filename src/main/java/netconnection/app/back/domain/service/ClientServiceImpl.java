package netconnection.app.back.domain.service;

import netconnection.app.back.domain.model.Client;
import netconnection.app.back.domain.port.ClientRepositoryPort;
import netconnection.app.back.domain.port.ClientServicePort;

import java.util.ArrayList;
import java.util.List;

public class ClientServiceImpl implements ClientServicePort {


    ClientServicePort clientServicePort;
    ClientRepositoryPort clientRepositoryPort;

    public ClientServiceImpl(ClientServicePort _clientServicePort, ClientRepositoryPort _clientRepositoryPort){
        this.clientServicePort = _clientServicePort;
        this.clientRepositoryPort =_clientRepositoryPort;
    }


    @Override
    public Client save(Client client) {

        clientRepositoryPort.salvar(client);
        return client;

    }

    @Override
    public Client findById(String id) {

        return clientRepositoryPort.findById(id);
    }

    @Override
    public List<Client> findAll() {


        return clientRepositoryPort.findAll();
    }
}
