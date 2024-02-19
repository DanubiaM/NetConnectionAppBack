package netconnection.app.back.domain.service;

import netconnection.app.back.domain.port.FakeClientRepositoryPort;
import netconnection.app.back.domain.model.Address;
import netconnection.app.back.domain.model.CPF;
import netconnection.app.back.domain.model.Client;
import netconnection.app.back.domain.service.ClientServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceTest {

    private static ClientServiceImpl clientService;

    @Before
    public void startService(){
        clientService =  new ClientServiceImpl( new FakeClientRepositoryPort());
    }

    @Test
    public void shoudlBeCreatedNewClient(){
        //GIVE

        Address addressClient = new Address("Rua A.", "Q10","VG","78144034");
        CPF cpf = new CPF("050.959.330-55", LocalDate.now());
        Client clientNew = new Client(UUID.randomUUID().toString(), "João", "email@gmail.com", cpf,
                "(65) 99999999", addressClient);

        //WHEN

        Client clientSave = clientService.save(clientNew);

        //THEN
        assertEquals(clientNew,clientSave);

    }

    @Test
    public void shouldFindClientById(){
        //GIVE
        String id = "2b1d7d0b-56d5-48d6-bf42-d4ca1ef3884a";

        //WHEN
        Client client = clientService.findById(id);


        //THEN
        assertNotNull(client.getId());
        assertEquals(id,client.getId());

    }

    @Test
    public void shouldFindAllClients(){
        //GIVE
        Address addressClient = new Address("Rua A.", "Q10","VG","78144034");
        CPF cpf = new CPF("050.959.330-55", LocalDate.now());
        Client client1 = new Client(UUID.randomUUID().toString(), "João", "email@gmail.com", cpf,"(65) 99999999", addressClient);
        Client client2 = new Client(UUID.randomUUID().toString(), "João", "email@gmail.com", cpf,"(65) 99999999", addressClient);
        //WHEN
        clientService.save(client1);
        clientService.save(client2);

        //THEN
        assertEquals(2,clientService.findAll().size());
    }




}
