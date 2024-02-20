package netconnection.app.back.domain.model;

import netconnection.app.back.domain.model.customer.CPF;
import netconnection.app.back.domain.model.customer.Customer;
import netconnection.app.back.domain.model._shared.Address;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerTest {


    @Test
    public void shoudlBeCreatedCustomer(){
        Address addressCustomer = new Address("Rua A.", "Q10","VG","78144034");
        CPF cpf = new CPF("050.959.330-55", LocalDate.now());

        //WHEN

        Customer newCustomer = new Customer(UUID.randomUUID().toString(), "João", "email@gmail.com", cpf,"(65) 99999999", addressCustomer);

        //THEN
        Assertions.assertNotNull(newCustomer);
        Assertions.assertNotNull(newCustomer.getId());

    }

    @Test
    public void shouldThrowExceptionWhenIdIsEmpty(){
        //GIVE

        Address addressCustomer = new Address("Rua A.", "Q10","VG","78144034");
        CPF cpf = new CPF("050.959.330-55", LocalDate.now());

        //WHEN


        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Customer("", "João", "email@gmail.com", cpf,"(65) 99999999", addressCustomer));

    }
    @Test
    public void shouldThrowExceptionWhenNameIsEmpty(){
        //GIVE

        Address addressCustomer = new Address("Rua A.", "Q10","VG","78144034");
        CPF cpf = new CPF("050.959.330-55", LocalDate.now());

        //WHEN


        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Customer(UUID.randomUUID().toString(),"", "email@gmail.com", cpf,"(65) 99999999", addressCustomer));

    }
    @Test
    public void shouldThrowExceptionWhenEmailIsEmpty(){
        //GIVE

        Address addressCustomer = new Address("Rua A.", "Q10","VG","78144034");
        CPF cpf = new CPF("050.959.330-55", LocalDate.now());

        //WHEN


        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Customer(UUID.randomUUID().toString(), "João", "", cpf,"(65) 99999999", addressCustomer));

    }
    @Test
    public void shouldThrowExceptionWhenPhoneIsEmpty(){
        //GIVE

        Address addressCustomer = new Address("Rua A.", "Q10","VG","78144034");
        CPF cpf = new CPF("050.959.330-55", LocalDate.now());

        //WHEN


        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Customer(UUID.randomUUID().toString(), "João", "email@gmail.com", cpf,"", addressCustomer));

    }
}
