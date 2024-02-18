package netconnection.app.back;

import netconnection.app.back.domain.model.Client;
import netconnection.app.back.domain.port.ClientRepositoryPort;
import netconnection.app.back.domain.port.ClientServicePort;

import java.util.List;

public class FakeClientRepositoryPort implements ClientRepositoryPort {


    @Override
    public void salvar(Client client) {

    }

    @Override
    public Client findById(String id) {
        return null;
    }

    @Override
    public List<Client> findAll() {
        return null;
    }
}
