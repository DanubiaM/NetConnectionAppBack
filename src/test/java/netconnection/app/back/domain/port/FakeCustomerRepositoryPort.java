package netconnection.app.back.domain.port;

import netconnection.app.back.domain.model._shared.Address;
import netconnection.app.back.domain.model._shared.Phone;
import netconnection.app.back.domain.model.customer.CPF;
import netconnection.app.back.domain.model.customer.Customer;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class FakeCustomerRepositoryPort implements CustomerRepositoryPort {


    @Override
    public void save(Customer customer) {
        //empty fake implementation
    }

    @Override
    public Customer findById(String id) {
        Address addressCustomer = new Address("Rua A.", "Q10","VG","78144034");
        CPF cpf = new CPF("050.959.330-55", LocalDate.now());
        Phone phoneNumber = new Phone("(69)999670867");

//        return new Customer("2b1d7d0b-56d5-48d6-bf42-d4ca1ef3884a","Joao","sada@gmail.com",
//                            cpf,"65 99990000543",addressCustomer);
            return null;
    }

    @Override
    public List<Customer> findAll() {
        Address addressCustomer = new Address("Rua A.", "Q10","VG","78144034");
        CPF cpf = new CPF("050.959.330-55", LocalDate.now());
        Phone phoneNumber = new Phone("(69)999670867");

//        Customer customer1 = new Customer(UUID.randomUUID().toString(), "João", "email@gmail.com", cpf,"(65) 99999999", addressCustomer);
//        Customer customer2 = new Customer(UUID.randomUUID().toString(), "João", "email@gmail.com", cpf,"(65) 99999999", addressCustomer);


//        return List.of(customer1,customer2);
        return null;
    }
}
