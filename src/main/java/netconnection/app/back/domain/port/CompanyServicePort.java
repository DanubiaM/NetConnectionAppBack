package netconnection.app.back.domain.port;

import netconnection.app.back.domain.model.company.Company;

import java.util.List;

public interface CompanyServicePort {
    Company save(Company company);

    Company findById(String id);

    List<Company> findAll();
}
