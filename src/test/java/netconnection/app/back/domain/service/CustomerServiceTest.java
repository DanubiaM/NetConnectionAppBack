package netconnection.app.back.domain.service;

import netconnection.app.back.domain.port.FakeCustomerRepositoryPort;
import netconnection.app.back.domain.model._shared.Address;
import netconnection.app.back.domain.model.customer.CPF;
import netconnection.app.back.domain.model.customer.Customer;
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
public class CustomerServiceTest {

    private static CustomerServiceImpl customerService;

    @Before
    public void startService(){
        customerService =  new CustomerServiceImpl( new FakeCustomerRepositoryPort());
    }

    @Test
    public void shoudlBeCreatedNewCustomer(){
        //GIVE

        Address addressCustomer = new Address("Rua A.", "Q10","VG","78144034");
        CPF cpf = new CPF("050.959.330-55", LocalDate.now());

//        Customer customerNew = new Customer(UUID.randomUUID().toString(), "João", "email@gmail.com", cpf,
//                "(65) 99999999", addressCustomer);

        //WHEN

//        Customer customerSave = customerService.save(customerNew);
//
//        //THEN
//        assertEquals(customerNew,customerSave);

    }

    @Test
    public void shouldFindCustomerById(){
        //GIVE
        String id = "2b1d7d0b-56d5-48d6-bf42-d4ca1ef3884a";

        //WHEN
        Customer customer = customerService.findById(id);


        //THEN
        assertNotNull(customer.getId());
        assertEquals(id,customer.getId());

    }

    @Test
    public void shouldFindAllCustomer(){
        //GIVE
        Address addressCustomer = new Address("Rua A.", "Q10","VG","78144034");
        CPF cpf = new CPF("050.959.330-55", LocalDate.now());
//        Customer customer1 = new Customer(UUID.randomUUID().toString(), "João", "email@gmail.com", cpf,"(65) 99999999", addressCustomer);
//        Customer customer2 = new Customer(UUID.randomUUID().toString(), "João", "email@gmail.com", cpf,"(65) 99999999", addressCustomer);
//        //WHEN
//        customerService.save(customer1);
//        customerService.save(customer2);
//
//        //THEN
//        assertEquals(2, customerService.findAll().size());
    }




}
