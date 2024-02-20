package netconnection.app.back.domain.model;

import netconnection.app.back.domain.model.quotation.ItemQuotation;
import netconnection.app.back.domain.model.quotation.Product;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemQuotationTest {

    @Test
    public void shouldBeCreatedItemQuotation(){

        //GIVE
        List<String> keywords = List.of("A","B","C");
        Product newProduct = new Product("Product A", "Description Product A",
                                 345.5F,"www.anylink.com.br" ,keywords);
        ItemQuotation item = new ItemQuotation(3, newProduct);

        //WHEN


        //THEN
        Assertions.assertNotNull(item);
        Assertions.assertNotNull(item.getProduct());
    }

    @Test
    public void shouldThrowExceptionWhenQuantitytIsInvalid(){

        //GIVE
        List<String> keywords = List.of("A","B","C");
        Product newProduct = new Product("Product A", "Description Product A",
                345.5F,"www.anylink.com.br" ,keywords);

        //WHEN

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new ItemQuotation(-2, newProduct));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new ItemQuotation(0, newProduct));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new ItemQuotation(null, newProduct));

    }
    @Test
    public void shouldThrowExceptionWhenProductIsNull(){

        //GIVE

        //WHEN

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new ItemQuotation(3, null));



    }

}
