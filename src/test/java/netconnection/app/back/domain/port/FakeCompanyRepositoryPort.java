package netconnection.app.back.domain.port;

import netconnection.app.back.domain.model._shared.Address;
import netconnection.app.back.domain.model._shared.Phone;
import netconnection.app.back.domain.model.company.CNPJ;
import netconnection.app.back.domain.model.company.Company;
import netconnection.app.back.domain.model.company.STATUS_COMPANY;
import netconnection.app.back.domain.model.customer.CPF;
import netconnection.app.back.domain.model.customer.Customer;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class FakeCompanyRepositoryPort implements CompanyRepositoryPort {


    @Override
    public void save(Company customer) {
       //fake implementation
    }

    @Override
    public Company findById(String id) {
        Address address = new Address("Rua A.", "Q10","VG","78144034");
        CNPJ cnpj = new CNPJ("91.244.376/0001-05"," COMPANY A",address, STATUS_COMPANY.ACTIVE);
        Phone phoneNumber = new Phone("(69)999670867");

        return new Company( id,cnpj,"A COMPANY LTDA",phoneNumber, "someoneemail@email.com");



    }


    public List<Company> findAll() {
        Address address = new Address("Rua A.", "Q10","VG","78144034");
        CNPJ cnpj = new CNPJ("91.244.376/0001-05"," COMPANY A",address, STATUS_COMPANY.ACTIVE);
        Phone phoneNumber = new Phone("(69)999670867");
        Company c1 = new Company( UUID.randomUUID().toString(),cnpj,"A COMPANY LTDA",phoneNumber, "someoneemail@email.com");
        Company c2 = new Company( UUID.randomUUID().toString(),cnpj,"A COMPANY LTDA",phoneNumber, "someoneemail@email.com");


        return List.of(c1,c2);
    }

    @Override
    public Company findByCNPJNumber(String cnpjNumber) {
        Address address = new Address("Rua A.", "Q10","VG","78144034");
        CNPJ cnpj = new CNPJ(cnpjNumber," COMPANY A",address, STATUS_COMPANY.ACTIVE);
        Phone phoneNumber = new Phone("(69)999670867");

        return new Company( UUID.randomUUID().toString(),cnpj,"A COMPANY LTDA",phoneNumber, "someoneemail@email.com");

    }

    @Override
    public void delete(Company company) {
        //does not do anything
    }
}
