package netconnection.app.back.domain.service;

import netconnection.app.back.domain.model.company.Company;
import netconnection.app.back.domain.model.customer.Customer;
import netconnection.app.back.domain.model.quotation.ItemQuotation;
import netconnection.app.back.domain.model.quotation.Product;
import netconnection.app.back.domain.model.quotation.Quotation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuotatioServiceTest {

    @Test
    public void shouldBeRegisterNewQuotation(){
        //GIVE
        String idCustomer = "9c124aca-ff3a-407a-b539-7774d9204298";

        String idCompany = "487f3de4-9b5f-45ad-b533-c8b301662ff5";

        Product productA = new Product("Product A", "Descrioption" , 230F, "www..dfs", List.of("A"));
        Product productB = new Product("Product B", "Descrioption" , 110F, "www..dfs", List.of("B"));

        ItemQuotation item1 = new ItemQuotation(2,productA);
        ItemQuotation item2 = new ItemQuotation(1,productB);

        List<ItemQuotation> items = List.of(item1,item2);

        Quotation newQuotatio = new Quotation(UUID.randomUUID().toString(),"Quotation A","Description A",
        LocalDate.now().plusDays(7),items, idCompany,idCustomer, LocalDateTime.now());



    }

}
