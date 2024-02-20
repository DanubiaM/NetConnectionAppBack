package netconnection.app.back.domain.model;

import netconnection.app.back.domain.model.Address;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientTest {


    @Test
    public void shoudlBeCreatedClient(){
        Address addressClient = new Address("Rua A.", "Q10","VG","78144034");
        CPF cpf = new CPF("050.959.330-55", LocalDate.now());

        //WHEN

        Client newClient = new Client(UUID.randomUUID().toString(), "João", "email@gmail.com", cpf,"(65) 99999999", addressClient);

        //THEN
        Assertions.assertNotNull(newClient);
        Assertions.assertNotNull(newClient.getId());

    }

    @Test
    public void shouldThrowExceptionWhenIdIsEmpty(){
        //GIVE

        Address addressClient = new Address("Rua A.", "Q10","VG","78144034");
        CPF cpf = new CPF("050.959.330-55", LocalDate.now());

        //WHEN


        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Client("", "João", "email@gmail.com", cpf,"(65) 99999999", addressClient));

    }
    @Test
    public void shouldThrowExceptionWhenNameIsEmpty(){
        //GIVE

        Address addressClient = new Address("Rua A.", "Q10","VG","78144034");
        CPF cpf = new CPF("050.959.330-55", LocalDate.now());

        //WHEN


        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Client(UUID.randomUUID().toString(),"", "email@gmail.com", cpf,"(65) 99999999", addressClient));

    }
    @Test
    public void shouldThrowExceptionWhenEmailIsEmpty(){
        //GIVE

        Address addressClient = new Address("Rua A.", "Q10","VG","78144034");
        CPF cpf = new CPF("050.959.330-55", LocalDate.now());

        //WHEN


        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Client(UUID.randomUUID().toString(), "João", "", cpf,"(65) 99999999", addressClient));

    }
    @Test
    public void shouldThrowExceptionWhenPhoneIsEmpty(){
        //GIVE

        Address addressClient = new Address("Rua A.", "Q10","VG","78144034");
        CPF cpf = new CPF("050.959.330-55", LocalDate.now());

        //WHEN


        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Client(UUID.randomUUID().toString(), "João", "email@gmail.com", cpf,"", addressClient));

    }
}
