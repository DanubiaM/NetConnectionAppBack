package netconnection.app.back.domain.model;

import netconnection.app.back.domain.model.quotation.Product;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTest {

    @Test
    public void shouldBeCreatedNewProduct(){
        //GIVE
        List<String> keywords = List.of("A","B","C");
        Product newProduct = new Product("Product A", "Description Product A",
                                    345.5F,"www.anylink.com.br" ,keywords);

        //WHEN

        //THEN
        Assertions.assertNotNull(newProduct);
    }

    @Test
    public void shouldThrowExceptionWhenNameIsInvalid(){
        //GIVE
        List<String> keywords = List.of("A","B","C");

        //WHEN

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Product("", "Description Product A",
                        345.5F,"www.anylink.com.br" ,keywords));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Product(null, "Description Product A",
                        345.5F,"www.anylink.com.br" ,keywords));

    }
    @Test
    public void shouldThrowExceptionWhenDescriptionIsEmpty(){
        //GIVE
        List<String> keywords = List.of("A","B","C");

        //WHEN

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Product("Product A", "",
                        345.5F,"www.anylink.com.br" ,keywords));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Product("Product B", null,
                        345.5F,"www.anylink.com.br" ,keywords));

    }

    @Test
    public void shouldThrowExceptionWhenNumberIsInvalid(){
        //GIVE
        List<String> keywords = List.of("A","B","C");

        //WHEN

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Product("Product A", "description",
                        null,"www.anylink.com.br" ,keywords));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Product("Product B", "description",
                        -345.5F,"www.anylink.com.br" ,keywords));

    }
    @Test
    public void shouldThrowExceptionWhenURLIsInvalid(){
        //GIVE
        List<String> keywords = List.of("A","B","C");

        //WHEN

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Product("Product A", "description",
                        345.5F,null ,keywords));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Product("Product B", "description",
                        345.5F,"" ,keywords));

    }
}
