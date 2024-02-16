package netconnection.app.back.domain.service;

import netconnection.app.back.application.dtos.ClientDTO;
import netconnection.app.back.domain.port.ClientServicePort;

import java.util.List;

public class ClientServiceImpl implements ClientServicePort {


    ClientServicePort clientServicePort;

    public ClientServiceImpl(ClientServicePort _clientServicePort){
        this.clientServicePort = _clientServicePort;
    }


    @Override
    public void saveClient(ClientDTO clientDTO) {

    }
}
