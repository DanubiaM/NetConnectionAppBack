package netconnection.app.back.domain.port;

import netconnection.app.back.domain.model.Client;

import java.util.List;

public interface ClientRepositoryPort {

    void salvar(Client client);

    Client findById(String id);

    List<Client> findAll();
}
