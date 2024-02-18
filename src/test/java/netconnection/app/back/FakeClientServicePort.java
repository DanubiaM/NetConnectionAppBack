package netconnection.app.back;

import netconnection.app.back.application.dtos.ClientDTO;
import netconnection.app.back.domain.model.Client;
import netconnection.app.back.domain.port.ClientServicePort;

import java.util.List;

public class FakeClientServicePort implements ClientServicePort {
    @Override
    public Client save(Client clientDTO) {
        //empty fake implementation

        return new Client();
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
