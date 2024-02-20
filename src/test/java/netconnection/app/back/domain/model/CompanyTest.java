package netconnection.app.back.domain.model;

import netconnection.app.back.domain.model._shared.Address;
import netconnection.app.back.domain.model.company.CNPJ;
import netconnection.app.back.domain.model.company.Company;
import netconnection.app.back.domain.model.company.STATUS_COMPANY;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyTest {

    @Test
    public void shouldBeCreatedNewCompany(){

         //GIVE
         Address address = new Address("Rua A.", "Q10","VG","78144034");
         CNPJ cnpj = new CNPJ("91.244.376/0001-05"," COMPANY A",address, STATUS_COMPANY.ACTIVE);
         Company company = new Company( UUID.randomUUID().toString(),cnpj,"A COMPANY LTDA","3451-3232", "someoneemail@email.com");
         //WHEN


         //THEN
         Assertions.assertNotNull(company);
         Assertions.assertNotNull(company.getId());

    }

    @Test
    public void shouldThrowExceptionWhenCNPJIsDisable(){
        //GIVE
        Address address = new Address("Rua A.", "Q10","VG","78144034");
        CNPJ cnpj = new CNPJ("91.244.376/0001-05"," COMPANY A",address, STATUS_COMPANY.DISABLE);
        //WHEN


        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Company(UUID.randomUUID().toString(), cnpj,"A COMPANY LTDA","3451-3232", "someoneemail@email.com"));
    }

    @Test
    public void shouldThrowExceptionWhenNameIsEmpty(){
        //GIVE
        Address address = new Address("Rua A.", "Q10","VG","78144034");
        CNPJ cnpj = new CNPJ("91.244.376/0001-05"," COMPANY A",address, STATUS_COMPANY.ACTIVE);
        //WHEN


        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Company(UUID.randomUUID().toString(),cnpj,null,"3451-3232", "someoneemail@email.com"));

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Company(UUID.randomUUID().toString(), cnpj,"","3451-3232", "someoneemail@email.com"));
    }

    @Test
    public void shouldThrowExceptionWhenPhoneIsEmpty(){
        //GIVE
        Address address = new Address("Rua A.", "Q10","VG","78144034");
        CNPJ cnpj = new CNPJ("91.244.376/0001-05"," COMPANY A",address, STATUS_COMPANY.ACTIVE);
        //WHEN


        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Company(UUID.randomUUID().toString(), cnpj,"A COMPANY LTDA","", "someoneemail@email.com"));

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Company(UUID.randomUUID().toString(), cnpj,"A COMPANY LTDA",null, "someoneemail@email.com"));
    }

    @Test
    public void shouldThrowExceptionWhenEmailIsEmpty(){
        //GIVE
        Address address = new Address("Rua A.", "Q10","VG","78144034");
        CNPJ cnpj = new CNPJ("91.244.376/0001-05"," COMPANY A",address, STATUS_COMPANY.ACTIVE);
        //WHEN


        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Company(UUID.randomUUID().toString(), cnpj,"A COMPANY LTDA","3451-3232", null));

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Company(UUID.randomUUID().toString(),cnpj,"A COMPANY LTDA","3451-3232", ""));
    }
}
