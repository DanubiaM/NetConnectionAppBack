package netconnection.app.back.domain.port;

import netconnection.app.back.domain.model.Address;
import netconnection.app.back.domain.model.CPF;
import netconnection.app.back.domain.model.Client;
import netconnection.app.back.domain.port.ClientRepositoryPort;
import netconnection.app.back.domain.port.ClientServicePort;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class FakeClientRepositoryPort implements ClientRepositoryPort {


    @Override
    public void salvar(Client client) {
        //empty fake implementation
    }

    @Override
    public Client findById(String id) {
        Address addressClient = new Address("Rua A.", "Q10","VG","78144034");
        CPF cpf = new CPF("050.959.330-55", LocalDate.now());
        return new Client("2b1d7d0b-56d5-48d6-bf42-d4ca1ef3884a","Joao","sada@gmail.com",
                            cpf,"65 99990000543",addressClient);
    }

    @Override
    public List<Client> findAll() {
        Address addressClient = new Address("Rua A.", "Q10","VG","78144034");
        CPF cpf = new CPF("050.959.330-55", LocalDate.now());
        Client client1 = new Client(UUID.randomUUID().toString(), "João", "email@gmail.com", cpf,"(65) 99999999", addressClient);
        Client client2 = new Client(UUID.randomUUID().toString(), "João", "email@gmail.com", cpf,"(65) 99999999", addressClient);


        return List.of(client1,client2);
    }
}
