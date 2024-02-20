package netconnection.app.back.domain.port;

import netconnection.app.back.domain.model.customer.Customer;

import java.util.List;

public interface CustomerServicePort {

    Customer save(Customer customer);

    Customer findById(String id);

    List<Customer> findAll();

}