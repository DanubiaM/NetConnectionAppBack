package netconnection.app.back.domain.model;

import netconnection.app.back.domain.model._shared.Address;
import netconnection.app.back.domain.model.company.CNPJ;
import netconnection.app.back.domain.model.company.STATUS_COMPANY;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

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
        assertFalse(cnpj.hasError());
        Assertions.assertNotNull(cnpj);

    }

    @Test
    public void shouldThrowExceptionWhenNumberIsInvalidOrEmpty(){

        //GIVE
        Address address = new Address("Rua A.", "Q10","VG","78144034");
        CNPJ cnpj1 = new CNPJ("91.244.3701-05"," COMPANY A",address, STATUS_COMPANY.ACTIVE);
        CNPJ cnpj2 = new CNPJ("91244376100005", " COMPANY A", address, STATUS_COMPANY.ACTIVE);
        CNPJ cnpj3 = new CNPJ(null, " COMPANY A", address, STATUS_COMPANY.ACTIVE);
        CNPJ cnpj4 = new CNPJ("", " COMPANY A", address, STATUS_COMPANY.ACTIVE);
        //WHEN


        //THEN
        assertTrue(cnpj1.hasError());
        assertTrue(cnpj2.hasError());
        assertTrue(cnpj3.hasError());
        assertTrue(cnpj4.hasError());

        assertEquals("Invalid CNPJ number.",cnpj1.errorMessages());
        assertEquals("Invalid CNPJ number.",cnpj2.errorMessages());
        assertEquals("CNPJ number should not be empty.",cnpj3.errorMessages());
        assertEquals("CNPJ number should not be empty.",cnpj4.errorMessages());

    }

    @Test
    public void shouldThrowExceptionWhenCorporateNameIsNotValid(){
        //GIVE
        Address address = new Address("Rua A.", "Q10","VG","78144034");
        CNPJ cnpj1 = new CNPJ("91.244.376/0001-05", null, address, STATUS_COMPANY.ACTIVE);
        CNPJ cnpj2 = new CNPJ("91.244.376/0001-05", "", address, STATUS_COMPANY.ACTIVE);
        //WHEN


        //THEN
        assertTrue(cnpj1.hasError());
        assertTrue(cnpj2.hasError());

        assertEquals("Corporate Name is not valid.",cnpj1.errorMessages());
        assertEquals("Corporate Name is not valid.",cnpj2.errorMessages());

    }

    @Test
    public void shouldThrowExceptionWhenStatusIsInvalid(){
        //GIVE
        Address address = new Address("Rua A.", "Q10","VG","78144034");
        CNPJ cnpj1 = new CNPJ("91.244.376/0001-05", "Corporate A", address, null);
        //WHEN


        //THEN
        assertTrue(cnpj1.hasError());
        assertEquals("Status should not be null.",cnpj1.errorMessages());

    }

}
