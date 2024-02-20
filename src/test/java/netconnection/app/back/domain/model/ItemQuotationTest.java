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
public class ItemBudgetTest {

    @Test
    public void shouldBeCreatedItemBudget(){

        //GIVE
        List<String> keywords = List.of("A","B","C");
        Product newProduct = new Product("Product A", "Description Product A",
                                 345.5F,"www.anylink.com.br" ,keywords);
        ItemBudget item = new ItemBudget(3, newProduct);

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
                new ItemBudget(-2, newProduct));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new ItemBudget(0, newProduct));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new ItemBudget(null, newProduct));

    }
    @Test
    public void shouldThrowExceptionWhenProductIsNull(){

        //GIVE

        //WHEN

        //THEN
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new ItemBudget(3, null));



    }

}
