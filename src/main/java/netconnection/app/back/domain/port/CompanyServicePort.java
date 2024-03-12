package netconnection.app.back.domain.port;

import netconnection.app.back.domain.model._shared.Phone;
import netconnection.app.back.domain.model.company.CNPJ;
import netconnection.app.back.domain.model.company.Company;

public interface CompanyServicePort {
    Company register(Company company);


    Company updatePhoneNumber(Company company, Phone newPhoneNumber);


    Company updateCNPJ(Company company, CNPJ newCNPJ);

    void delete(Company company);

    Company findById(String id);
}
