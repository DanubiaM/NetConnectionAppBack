package netconnection.app.back.domain.port;

import netconnection.app.back.domain.model._shared.Phone;
import netconnection.app.back.domain.model.company.Company;

import java.util.List;

public interface CompanyServicePort {
    Company register(Company company);


    Company updatePhoneNumber(Company company, Phone newPhoneNumber);
}
