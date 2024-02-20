package netconnection.app.back.domain.model;

import netconnection.app.back.domain.model.customer.CPF;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CPFTest {

    @Test
    public void shoudlBeCreatedCPF(){
        //GIVE
        CPF cpf = new CPF("050.959.330-55", LocalDate.now());
        CPF cpf2 = new CPF("05095933055", LocalDate.now());

        //WHEN

        //THEN
        Assertions.assertNotNull(cpf);
        Assertions.assertNotNull(cpf);
    }

    @Test
    public void shouldBeThrowExceptionWhenNumberIsInvalidOrEmpty(){
        //GIVE
        //WHEN

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CPF("", LocalDate.now()));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CPF(null, LocalDate.now()));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CPF("022443345-43", LocalDate.now()));

    }
    @Test
    public void shouldBeThrowExceptionWhenEmissionIsEmpty(){
        //GIVE
        //WHEN

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CPF("050.959.330-55", null));


    }

}
