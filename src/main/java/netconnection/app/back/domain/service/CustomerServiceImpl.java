package netconnection.app.back.domain.service;

import netconnection.app.back.domain.model.customer.Customer;
import netconnection.app.back.domain.port.CustomerRepositoryPort;
import netconnection.app.back.domain.port.CustomerServicePort;

import java.util.List;

public class CustomerServiceImpl implements CustomerServicePort {


    CustomerRepositoryPort customerRepositoryPort;

    public CustomerServiceImpl(CustomerRepositoryPort _customerRepositoryPort){
        this.customerRepositoryPort =_customerRepositoryPort;
    }


    @Override
    public Customer save(Customer customer) {

        customerRepositoryPort.save(customer);
        return customer;

    }

    @Override
    public Customer findById(String id) {

        return customerRepositoryPort.findById(id);
    }

    @Override
    public List<Customer> findAll() {

        return customerRepositoryPort.findAll();
    }
}
