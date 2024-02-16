package netconnection.app.back;

import netconnection.app.back.application.dtos.ClientDTO;
import netconnection.app.back.domain.port.ClientServicePort;

import java.util.List;

public class FakeClientServicePort implements ClientServicePort {
    @Override
    public void saveClient(ClientDTO clientDTO) {
        //empty fake implementation
    }

}
