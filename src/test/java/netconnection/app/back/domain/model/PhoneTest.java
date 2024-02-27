package netconnection.app.back.domain.model;

import netconnection.app.back.domain.model._shared.Phone;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhoneTest {

    @Test
    public void shouldBeCreatedANewPhoneWithOneNumber(){
        Phone phoneNumber = new Phone("(65)999670867");

        Assertions.assertNotNull(phoneNumber);

    }

    @Test
    public void shouldBeCreatedANewPhoneWithTwoOneNumber(){
        Phone phoneNumber = new Phone("(66)999670867","(66)999670867");

        Assertions.assertNotNull(phoneNumber);

    }

    @Test
    public void shouldBeCreatedANewPhoneWithThreeOneNumber(){
        Phone phoneNumber = new Phone("(66)999670867","(66)999670867","(62)999670867");

        Assertions.assertNotNull(phoneNumber);

    }

    @Test
    public void shouldBeShowMessageErrorWhenTheNumberPhoneIsEmpty(){
        //GIVE
        Phone phoneNumber = new Phone("");
        Phone phoneNumber2 = new Phone(null);
        Phone phoneNumber3 = new Phone(null,null);

        //WHEN


        //THEN

        assertTrue(phoneNumber.hasError());
        assertTrue( phoneNumber2.hasError());
        assertTrue(phoneNumber3.hasError());
        assertEquals("Phone Number One should not be empty", phoneNumber.errorMessages());
        assertEquals("Phone Number One should not be empty", phoneNumber2.errorMessages());
        assertEquals("Phone Number One should not be empty, Phone Number Two should not be empty", phoneNumber3.errorMessages());
    }
    @Test
    public void shouldBeShowMessageErrorWhenTheNumberPhoneIsInvalid(){
        //GIVE
        Phone phoneNumber = new Phone("3451-3455","(65)99999-9999");


        //WHEN


        //THEN

        assertTrue(phoneNumber.hasError());

        assertEquals("Ilegal Phone Number One, Ilegal Phone Number Two", phoneNumber.errorMessages());

    }
}
