package netconnection.app.back.domain.model;

import netconnection.app.back.domain.model.Address;
import netconnection.app.back.domain.model.CNPJ;
import netconnection.app.back.domain.model.Company;
import netconnection.app.back.domain.model.STATUS_COMPANY;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyTest {

    @Test
    public void shouldBeCreatedNewCompany(){

         //GIVE
         Address address = new Address("Rua A.", "Q10","VG","78144034");
         CNPJ cnpj = new CNPJ("91.244.376/0001-05"," COMPANY A",address, STATUS_COMPANY.ACTIVE);
         Company company = new Company(cnpj,"A COMPANY LTDA","3451-3232", "someoneemail@email.com");
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
                new Company(cnpj,"A COMPANY LTDA","3451-3232", "someoneemail@email.com"));
    }

    @Test
    public void shouldThrowExceptionWhenNameIsEmpty(){
        //GIVE
        Address address = new Address("Rua A.", "Q10","VG","78144034");
        CNPJ cnpj = new CNPJ("91.244.376/0001-05"," COMPANY A",address, STATUS_COMPANY.ACTIVE);
        //WHEN


        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Company(cnpj,null,"3451-3232", "someoneemail@email.com"));

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Company(cnpj,"","3451-3232", "someoneemail@email.com"));
    }

    @Test
    public void shouldThrowExceptionWhenPhoneIsEmpty(){
        //GIVE
        Address address = new Address("Rua A.", "Q10","VG","78144034");
        CNPJ cnpj = new CNPJ("91.244.376/0001-05"," COMPANY A",address, STATUS_COMPANY.ACTIVE);
        //WHEN


        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Company(cnpj,"A COMPANY LTDA","", "someoneemail@email.com"));

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Company(cnpj,"A COMPANY LTDA",null, "someoneemail@email.com"));
    }

    @Test
    public void shouldThrowExceptionWhenEmailIsEmpty(){
        //GIVE
        Address address = new Address("Rua A.", "Q10","VG","78144034");
        CNPJ cnpj = new CNPJ("91.244.376/0001-05"," COMPANY A",address, STATUS_COMPANY.ACTIVE);
        //WHEN


        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Company(cnpj,"A COMPANY LTDA","3451-3232", null));

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Company(cnpj,"A COMPANY LTDA","3451-3232", ""));
    }
}
