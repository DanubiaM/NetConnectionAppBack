package netconnection.app.back.domain.model;

import netconnection.app.back.domain.model.Address;
import netconnection.app.back.domain.model.Client;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressTest {

    @Test
    public void shoudlBeCreatedNewAddress(){
        //GIVE
        Address addressClient = new Address("Rua A.", "Q10","VG","78144034");
        //WHEN
        //THEN
        Assertions.assertNotNull(addressClient);
    }

    @Test
    public void shouldBeThrowExceptionWhenDescriptionIsEmpty(){
        //GIVE
        //WHEN

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Address(null, "Q10","VG","78144034"));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Address("", "Q10","VG","78144034"));
    }

    @Test
    public void shouldBeThrowExceptionWhenComplementIsEmpty(){
        //GIVE
        //WHEN

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Address("Rua A", null,"VG","78144034"));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Address("Rua A", "","VG","78144034"));
    }

    @Test
    public void shouldBeThrowExceptionWhenCityIsEmpty(){
        //GIVE
        //WHEN

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Address("Rua A", "Q10",null,"78144034"));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Address("Rua A", "Q10","","78144034"));
    }
    @Test
    public void shouldBeThrowExceptionWhenCEPIsEmpty(){
        //GIVE
        //WHEN

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Address("Rua A", "Q10","VG",null));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Address("Rua A", "Q10","VG",""));
    }

    @Test
    public void shouldBeThrowExceptionWhenCEPIsInvalidFormatter(){
        //GIVE

        //WHEN

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Address("Rua A", "Q10","VG","23432"));

    }

}
