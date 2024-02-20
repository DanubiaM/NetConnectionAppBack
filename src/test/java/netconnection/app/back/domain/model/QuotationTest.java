package netconnection.app.back.domain.model;

import netconnection.app.back.domain.model.customer.Customer;
import netconnection.app.back.domain.model.quotation.Quotation;
import netconnection.app.back.domain.model.quotation.ItemQuotation;
import netconnection.app.back.domain.model.quotation.Product;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class QuotationTest {

    @Test
    public void shouldBeCreatedNewQuotation(){
        //GIVE
        List<String> keywords = List.of("A","B","C");
        Product newProduct = new Product("Product A", "Description Product A",
                345.5F,"www.anylink.com.br" ,keywords);
        ItemQuotation item = new ItemQuotation(3, newProduct);

        List<ItemQuotation> items = List.of(item);

        Quotation newQuotation = new Quotation(UUID.randomUUID().toString(),"Title", "Description",
                                               LocalDate.now().plusDays(7), items, UUID.randomUUID().toString(),
                                                UUID.randomUUID().toString(), LocalDateTime.now());

        //WHEN


        //THEN
        Assertions.assertNotNull(newQuotation.getId());
    }

    @Test
    public void shouldNotBeIdEmpty() {
        //GIVE
        List<String> keywords = List.of("A","B","C");
        Product newProduct = new Product("Product A", "Description Product A",
                345.5F,"www.anylink.com.br" ,keywords);
        ItemQuotation item = new ItemQuotation(3, newProduct);

        List<ItemQuotation> items = List.of(item);



        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Quotation(null,"Title", "Description", LocalDate.now().plusDays(7),
                        items, UUID.randomUUID().toString(), UUID.randomUUID().toString(), LocalDateTime.now()));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Quotation("","Title", "Description", LocalDate.now().plusDays(7),
                        items, UUID.randomUUID().toString(), UUID.randomUUID().toString(), LocalDateTime.now()));
    }


    @Test
    public void shouldNotBeTitleEmpty() {
        //GIVE
        List<String> keywords = List.of("A","B","C");
        Product newProduct = new Product("Product A", "Description Product A",
                345.5F,"www.anylink.com.br" ,keywords);
        ItemQuotation item = new ItemQuotation(3, newProduct);

        List<ItemQuotation> items = List.of(item);

        //WHEN


        //THEN
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Quotation(UUID.randomUUID().toString(),"", "Description", LocalDate.now().plusDays(7),
                        items, UUID.randomUUID().toString(), UUID.randomUUID().toString(), LocalDateTime.now()));
        assertEquals("Title must not be empty", exception.getMessage());


        IllegalArgumentException exception2 = Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Quotation(UUID.randomUUID().toString(),null, "Description", LocalDate.now().plusDays(7),
                        items, UUID.randomUUID().toString(), UUID.randomUUID().toString(), LocalDateTime.now()));
        assertEquals("Title must not be empty", exception2.getMessage());


    }

    @Test
    public void shouldNotBeDescriptionEmpty() {
        //GIVE
        List<String> keywords = List.of("A", "B", "C");
        Product newProduct = new Product("Product A", "Description Product A",
                345.5F, "www.anylink.com.br", keywords);
        ItemQuotation item = new ItemQuotation(3, newProduct);

        List<ItemQuotation> items = List.of(item);

        //WHEN


        //THEN
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Quotation(UUID.randomUUID().toString(), "Title ", null, LocalDate.now().plusDays(7),
                        items, UUID.randomUUID().toString(), UUID.randomUUID().toString(), LocalDateTime.now()));
        assertEquals("Description must not be empty", exception.getMessage());


        IllegalArgumentException exception2 = Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Quotation(UUID.randomUUID().toString(), "Title", "", LocalDate.now().plusDays(7),
                        items, UUID.randomUUID().toString(), UUID.randomUUID().toString(), LocalDateTime.now()));
        assertEquals("Description must not be empty", exception2.getMessage());
    }

    @Test
    public void shouldNotBeValidityNull() {
        //GIVE
        List<String> keywords = List.of("A", "B", "C");
        Product newProduct = new Product("Product A", "Description Product A",
                345.5F, "www.anylink.com.br", keywords);
        ItemQuotation item = new ItemQuotation(3, newProduct);

        List<ItemQuotation> items = List.of(item);

        //WHEN


        //THEN
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Quotation(UUID.randomUUID().toString(), "Title ", "Description", null,
                        items, UUID.randomUUID().toString(), UUID.randomUUID().toString(), LocalDateTime.now()));
        assertEquals("Validity must not be null", exception.getMessage());


    }

    @Test
    public void shoulThrowExceptionWhenItemsIsEmpty() {
        //GIVE
        List<ItemQuotation> items = new ArrayList<>();

        //WHEN


        //THEN
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Quotation(UUID.randomUUID().toString(), "Title ", "Description", LocalDate.now().plusDays(7),
                        null, UUID.randomUUID().toString(), UUID.randomUUID().toString(), LocalDateTime.now()));
        assertEquals("Items must not be empty", exception.getMessage());
        IllegalArgumentException exception2 = Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Quotation(UUID.randomUUID().toString(), "Title ", "Description", LocalDate.now().plusDays(7),
                        items, UUID.randomUUID().toString(), UUID.randomUUID().toString(), LocalDateTime.now()));
        assertEquals("Items must not be empty", exception2.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenCreatedIsEmpty() {
        //GIVE
        List<String> keywords = List.of("A", "B", "C");
        Product newProduct = new Product("Product A", "Description Product A",
                345.5F, "www.anylink.com.br", keywords);
        ItemQuotation item = new ItemQuotation(3, newProduct);

        List<ItemQuotation> items = List.of(item);

        //WHEN


        //THEN
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Quotation(UUID.randomUUID().toString(), "Title ", "Description", LocalDate.now().plusDays(7),
                        items, UUID.randomUUID().toString(), UUID.randomUUID().toString(), null));
        assertEquals("Created at must not be null", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenCompanyIdIsEmpty() {
        //GIVE
        List<String> keywords = List.of("A", "B", "C");
        Product newProduct = new Product("Product A", "Description Product A",
                345.5F, "www.anylink.com.br", keywords);
        ItemQuotation item = new ItemQuotation(3, newProduct);

        List<ItemQuotation> items = List.of(item);

        //WHEN


        //THEN
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Quotation(UUID.randomUUID().toString(), "Title ", "Description", LocalDate.now().plusDays(7),
                        items, null, UUID.randomUUID().toString(), LocalDateTime.now()));
        assertEquals("Company ID must not be empty", exception.getMessage());
        IllegalArgumentException exception2 = Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Quotation(UUID.randomUUID().toString(), "Title ", "Description", LocalDate.now().plusDays(7),
                        items, "", UUID.randomUUID().toString(), LocalDateTime.now()));
        assertEquals("Company ID must not be empty", exception2.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenCustomerIdIsEmpty() {
        //GIVE
        List<String> keywords = List.of("A", "B", "C");
        Product newProduct = new Product("Product A", "Description Product A",
                345.5F, "www.anylink.com.br", keywords);
        ItemQuotation item = new ItemQuotation(3, newProduct);

        List<ItemQuotation> items = List.of(item);

        //WHEN


        //THEN
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Quotation(UUID.randomUUID().toString(), "Title ", "Description", LocalDate.now().plusDays(7),
                        items, UUID.randomUUID().toString(),null, LocalDateTime.now()));
        assertEquals("Customer ID must not be empty", exception.getMessage());
        IllegalArgumentException exception2 = Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Quotation(UUID.randomUUID().toString(), "Title ", "Description", LocalDate.now().plusDays(7),
                        items,  UUID.randomUUID().toString(),"", LocalDateTime.now()));
        assertEquals("Customer ID must not be empty", exception2.getMessage());

    }



}
