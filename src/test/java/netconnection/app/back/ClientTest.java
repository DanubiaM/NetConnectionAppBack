package netconnection.app.back;

import netconnection.app.back.application.dtos.ClientDTO;
import netconnection.app.back.domain.model.Address;
import netconnection.app.back.domain.model.CPF;
import netconnection.app.back.domain.model.Client;
import netconnection.app.back.domain.service.ClientServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
public class ClientTest {



    @Test
    void shoudlBeCreatedNewClient(){

//        Address addressClient = new Address("Rua A.", "Q10","VG","78144034");
//        CPF cpf = new CPF("050.959.330-55", LocalDate.now());
//        Client clientNew = new Client(UUID.randomUUID().toString(), "João", "email@gmail.com", cpf,
//                                "(65) 99999999", addressClient);

        //GIVE
        ClientDTO  newClientDTO = new ClientDTO("Joao", "jao@gmail.com","050.959.330-55",
                                                LocalDate.now(),"(23) 99283889","Rua A n6",
                                    "Q 10","VG","78134034");




        //WHEN
        ClientServiceImpl clientService = new ClientServiceImpl( new FakeClientServicePort());



        //THEN
        assertDoesNotThrow(() -> clientService.saveClient(newClientDTO));

    }

}
