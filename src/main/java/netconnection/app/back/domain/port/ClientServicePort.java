package netconnection.app.back.domain.port;

import netconnection.app.back.application.dtos.ClientDTO;

import java.util.List;

public interface ClientServicePort {

    void saveClient(ClientDTO clientDTO);


}
