package netconnection.app.back.domain.model;

import netconnection.app.back.domain.model._shared.Address;
import netconnection.app.back.domain.model._shared.Phone;
import netconnection.app.back.domain.model.company.CNPJ;
import netconnection.app.back.domain.model.company.Company;
import netconnection.app.back.domain.model.company.STATUS_COMPANY;
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
public class CompanyTest {
    Address address;
    Phone phoneNumber;
    @Before
    public void setUp(){
        address = new Address("Rua A.", "Q10","VG","78144034");
        phoneNumber = new Phone("(69)999670867");
    }

    @Test
    public void shouldBeCreatedNewCompany(){

         //GIVE
        CNPJ cnpj = new CNPJ("91.244.376/0001-05"," COMPANY A",address, STATUS_COMPANY.ACTIVE);

        Company company = new Company( UUID.randomUUID().toString(),cnpj,"A COMPANY LTDA",phoneNumber, "someoneemail@email.com");
         //WHEN


         //THEN

         assertFalse(company.hasError());
         Assertions.assertNotNull(company);

    }

    @Test
    public void shouldThrowExceptionWhenCNPJIsDisable(){
        //GIVE
        CNPJ cnpj = new CNPJ("91.244.376/0001-05"," COMPANY A",address, STATUS_COMPANY.DISABLE);
        Company company = new Company(UUID.randomUUID().toString(), cnpj, "A COMPANY LTDA", phoneNumber, "someoneemail@email.com");
        //WHEN


        //THEN
        assertTrue(company.hasError());
        assertEquals("CNPJ must not be disable", company.errorMessages());

    }

    @Test
    public void shouldThrowExceptionWhenNameIsEmpty(){
        //GIVE
        CNPJ cnpj = new CNPJ("91.244.376/0001-05"," COMPANY A",address, STATUS_COMPANY.ACTIVE);
        Company company = new Company(UUID.randomUUID().toString(), cnpj, "", phoneNumber, "someoneemail@email.com");
        Company company1 = new Company(UUID.randomUUID().toString(), cnpj, null, phoneNumber, "someoneemail@email.com");
        //WHEN


        //THEN
        assertTrue(company1.hasError());
        assertTrue(company.hasError());

        assertEquals("Name must not be empty",company.errorMessages());
        assertEquals("Name must not be null",company1.errorMessages());


    }

    @Test
    public void shouldThrowExceptionWhenPhoneIsEmpty(){

        //GIVE
        CNPJ cnpj = new CNPJ("91.244.376/0001-05"," COMPANY A",address, STATUS_COMPANY.ACTIVE);
        Company company = new Company(UUID.randomUUID().toString(), cnpj,"A COMPANY LTDA",null, "someoneemail@email.com");

        //WHEN


        //THEN
        assertTrue(company.hasError());
        assertEquals("Phone must not be null",company.errorMessages());
    }

    @Test
    public void shouldThrowExceptionWhenEmailIsEmpty(){

        //GIVE
        CNPJ cnpj = new CNPJ("91.244.376/0001-05"," COMPANY A",address, STATUS_COMPANY.ACTIVE);
        Company company = new Company(UUID.randomUUID().toString(), cnpj,"A COMPANY LTDA",phoneNumber, null);
        Company company1 = new Company(UUID.randomUUID().toString(), cnpj, "A COMPANY LTDA", phoneNumber, "");
        Company company2 = new Company(UUID.randomUUID().toString(), cnpj, "A COMPANY LTDA", phoneNumber, " someformatinvalid.com");
        //WHEN


        //THEN
        assertTrue(company.hasError());
        assertTrue(company1.hasError());
        assertTrue(company2.hasError());

        assertEquals("Email must not be null",company.errorMessages());
        assertEquals("Email must not be empty, Email format invalid",company1.errorMessages());
        assertEquals("Email format invalid",company2.errorMessages());
    }
}
