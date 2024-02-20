package netconnection.app.back.domain.port;

import netconnection.app.back.domain.model.company.Company;
import netconnection.app.back.domain.model.customer.Customer;

import java.util.List;

public interface CompanyRepositoryPort {
    void save(Company customer);

    Company findById(String id);

    List<Company> findAll();
}
