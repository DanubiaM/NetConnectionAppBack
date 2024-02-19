package netconnection.app.back.domain.model;

import netconnection.app.back.domain.model.Address;
import netconnection.app.back.domain.model.CNPJ;
import netconnection.app.back.domain.model.STATUS_COMPANY;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CNPJTest {
    @Test
    public void shoudlBeCreatedCNPJ(){

        //GIVE
        Address address = new Address("Rua A.", "Q10","VG","78144034");
        CNPJ cnpj = new CNPJ("91.244.376/0001-05"," COMPANY A",address, STATUS_COMPANY.ACTIVE);
        //WHEN


        //THEN
        Assertions.assertNotNull(cnpj);

    }

    @Test
    public void shouldThrowExceptionWhenNumberIsInvalidOrEmpty(){

        //GIVE
        Address address = new Address("Rua A.", "Q10","VG","78144034");

        //WHEN


        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new CNPJ("91.244.3701-05"," COMPANY A",address, STATUS_COMPANY.ACTIVE));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new CNPJ("91244376100005"," COMPANY A",address, STATUS_COMPANY.ACTIVE));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new CNPJ(null," COMPANY A",address, STATUS_COMPANY.ACTIVE));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new CNPJ(""," COMPANY A",address, STATUS_COMPANY.ACTIVE));
    }

    @Test
    public void shouldThrowExceptionWhenCorporateNameIsNotValid(){
        //GIVE
        Address address = new Address("Rua A.", "Q10","VG","78144034");

        //WHEN


        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new CNPJ("91.244.376/0001-05","",address, STATUS_COMPANY.ACTIVE));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new CNPJ("91.244.376/0001-05",null,address, STATUS_COMPANY.ACTIVE));
    }

    @Test
    public void shouldThrowExceptionWhenStatisIsInvalid(){
        //GIVE
        Address address = new Address("Rua A.", "Q10","VG","78144034");

        //WHEN


        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new CNPJ("91.244.376/0001-05","Corporate A",address, null));

    }

}
