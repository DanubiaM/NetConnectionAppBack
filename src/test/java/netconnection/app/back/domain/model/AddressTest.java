package netconnection.app.back.domain.model;

import netconnection.app.back.domain.model._shared.Address;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertFalse;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressTest {

    @Test
    public void shoudlBeCreatedNewAddress(){
        //GIVE
        Address addressCustomer = new Address("Rua A.", "Q10","VG","78144034");
        //WHEN
        //THEN
        assertFalse(addressCustomer.hasError());
        Assertions.assertNotNull(addressCustomer);
    }

    @Test
    public void shouldBeThrowExceptionWhenDescriptionIsEmpty(){
        //GIVE
        Address addressOne = new Address(null, "Q10","VG","78144034");
        //WHEN

        //THEN
        assertTrue(addressOne.hasError());
        assertEquals("Description must not be empty",addressOne.errorMessages());

    }

    @Test
    public void shouldBeThrowExceptionWhenComplementIsEmpty(){
        //GIVE
        Address addressOne = new Address("Rua A", null, "VG", "78144034");
        //WHEN

        //THEN
        assertTrue(addressOne.hasError());
        assertEquals("Complement must not be empty", addressOne.errorMessages());
    }

    @Test
    public void shouldBeThrowExceptionWhenCityIsEmpty(){
        //GIVE
        Address addressOne = new Address("Rua A", "Q10", null, "78144034");
        //WHEN

        //THEN
        assertTrue(addressOne.hasError());
        assertEquals("City must not be empty", addressOne.errorMessages());

    }
    @Test
    public void shouldBeThrowExceptionWhenCEPIsEmptyAndInvalid(){
        //GIVE
        Address addressOne = new Address("Rua A", "Q10", "VG", "781442034");
        Address addressTwo = new Address("Rua A", "Q10", "VG", null);
        //WHEN

        //THEN
        assertTrue(addressOne.hasError());
        assertEquals("Invalid Format CEP", addressOne.errorMessages());
        assertEquals("CEP must not be empty", addressTwo.errorMessages());
    }


}
