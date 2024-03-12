package netconnection.app.back.domain.service;

import netconnection.app.back.domain.model._shared.Address;
import netconnection.app.back.domain.model._shared.Phone;
import netconnection.app.back.domain.model.company.CNPJ;
import netconnection.app.back.domain.model.company.Company;
import netconnection.app.back.domain.model.company.STATUS_COMPANY;
import netconnection.app.back.domain.model.customer.CPF;
import netconnection.app.back.domain.port.FakeCompanyRepositoryPort;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyServiceTest {

    private static CompanyServiceImpl companyService;
    Address address;
    CNPJ cnpj;
    Phone phoneNumber;
    Company company;

    @Before
    public void startService(){
        companyService =  new CompanyServiceImpl(new FakeCompanyRepositoryPort());
        address = new Address("Rua A.", "Q10", "VG", "78144034");
        cnpj = new CNPJ("91.244.376/0001-05", " COMPANY A", address, STATUS_COMPANY.ACTIVE);
        phoneNumber = new Phone("(69)999670867");
        company = new Company(UUID.randomUUID().toString(), cnpj, "A COMPANY LTDA", phoneNumber, "someoneemail@email.com");
    }

    @Test
    public void shoudlBeCreatedNewCompany(){
        //GIVE

        //WHEN

        Company companySaved = companyService.register(company);

        //THEN
        assertEquals(company,companySaved);


    }

    @Test
    public void shouldBeThrowExceptionWhenNumberCNPJAlreadyRegister(){
        //GIVE


        //WHEN

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () -> companyService.register(company),
                "Company already exist");

    }

    @Test
    public void shouldBeUpdatePhoneNumber(){
        //GIVE


        //WHEN
        Phone newPhoneNumber = new Phone("(69)999554472");
        Company companyUpdated = companyService.updatePhoneNumber(company, newPhoneNumber);

        //THEN
        assertEquals(newPhoneNumber, companyUpdated.getPhoneNumber());
    }



    //A test to update CNPJ
    @Test
    public void shouldBeUpdateCNPJ(){
        //GIVE


        //WHEN
        CNPJ newCNPJ = new CNPJ("91.244.376/0001-05", " COMPANY B", address, STATUS_COMPANY.ACTIVE);

        Company companyUpdated = companyService.updateCNPJ(company, newCNPJ);

        //THEN
        assertEquals(newCNPJ, companyUpdated.getCnpj());
    }

    //A test to delete company -> just call delete repository, check if exist is make by application service?
    @Test
    public void shouldBeDeleteCompany(){
        //GIVE


        //WHEN
        companyService.delete(company);

        //THEN
//        assertThrows(IllegalArgumentException.class, () -> companyService.findById(company.getId()),
//                "Company not found");
    }



}
