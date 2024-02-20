package netconnection.app.back.domain.service;

import netconnection.app.back.domain.model.company.Company;
import netconnection.app.back.domain.port.CompanyRepositoryPort;
import netconnection.app.back.domain.port.CompanyServicePort;

import java.util.List;

public class CompanyServiceImpl implements CompanyServicePort {

    CompanyRepositoryPort companyRepositoryPort;

    public CompanyServiceImpl(CompanyRepositoryPort _companyRepositoryPort){
        this.companyRepositoryPort = _companyRepositoryPort;
    }

    @Override
    public Company save(Company company) {

        this.companyRepositoryPort.save(company);

        return company;
    }

    @Override
    public Company findById(String id) {

        return this.companyRepositoryPort.findById(id);
    }

    @Override
    public List<Company> findAll() {
        return this.companyRepositoryPort.findAll();
    }
}
