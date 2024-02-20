package netconnection.app.back.domain.service;

import netconnection.app.back.domain.model._shared.Address;
import netconnection.app.back.domain.model.company.CNPJ;
import netconnection.app.back.domain.model.company.Company;
import netconnection.app.back.domain.model.company.STATUS_COMPANY;
import netconnection.app.back.domain.model.customer.CPF;
import netconnection.app.back.domain.model.customer.Customer;
import netconnection.app.back.domain.port.FakeCompanyRepositoryPort;
import netconnection.app.back.domain.port.FakeCustomerRepositoryPort;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyServiceTest {

    private static CompanyServiceImpl companyService;

    @Before
    public void startService(){
        companyService =  new CompanyServiceImpl(new FakeCompanyRepositoryPort());
    }

    @Test
    public void shoudlBeCreatedNewCompany(){
        //GIVE
        Address address = new Address("Rua A.", "Q10","VG","78144034");
        CNPJ cnpj = new CNPJ("91.244.376/0001-05"," COMPANY A",address, STATUS_COMPANY.ACTIVE);
        Company company = new Company( UUID.randomUUID().toString(),cnpj,"A COMPANY LTDA","3451-3232", "someoneemail@email.com");

        //WHEN

        Company companySaved = companyService.save(company);

        //THEN
        assertEquals(company,companySaved);

    }

    @Test
    public void shouldFindCompanyById(){
        //GIVE
        String id = "4bc4aeb9-529c-4cc2-a642-0f88773ffa3f";
        //WHEN

        Company company = companyService.findById(id);

        //THEN
        assertNotNull(company.getId());
        assertEquals(id,company.getId());

    }

    @Test
    public void shouldFindAllCompany(){
        //GIVE

        //WHEN
        List<Company> findCompanys = companyService.findAll();

        //THEN
        assertEquals(2,findCompanys.size());
    }




}
