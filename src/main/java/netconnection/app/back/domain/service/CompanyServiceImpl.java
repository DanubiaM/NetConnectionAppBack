package netconnection.app.back.domain.service;

import netconnection.app.back.domain.model._shared.Phone;
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
    public Company register(Company company) {

        if(company.hasError()){
            throw new IllegalArgumentException(company.errorMessages());
        }

        //Verify is not exist other Company with same CNPJ number.
        Company companyExist = this.companyRepositoryPort.findByCNPJNumber(company.getCNPJNumber());

        if(companyExist != null){
            throw new IllegalArgumentException("Company already exist");
        }

        this.companyRepositoryPort.save(company);

        return company;
    }

    @Override
    public Company updatePhoneNumber(Company company, Phone newPhoneNumber) {

        company.updatePhoneNumber(newPhoneNumber);

        return company;
    }


}
