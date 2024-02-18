package netconnection.app.back.domain.port;

import netconnection.app.back.application.dtos.ClientDTO;
import netconnection.app.back.domain.model.Client;

import java.util.List;

public interface ClientServicePort {

    Client save(Client clientDTO);

    Client findById(String id);

    List<Client> findAll();

}
