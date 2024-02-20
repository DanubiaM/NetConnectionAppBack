package netconnection.app.back.domain.model.quotation;

import io.micrometer.common.util.StringUtils;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Quotation {

    private String id;
    private String title;
    private String description;
    private LocalDate validity;
    private List<ItemQuotation> items;
    private LocalDateTime createdAt;
    private String idCompany;

    private String idCustomer;



    public Quotation(String _id, String _title, String _description, LocalDate _validity, List<ItemQuotation> _items,
                     String _idCompany, String _idCustomer, LocalDateTime _createdAt) {
        this.id = _id;
        this.title = _title;
        this.description = _description;
        this.validity = _validity;
        this.items = _items;
        this.idCompany = _idCompany;
        this.idCustomer = _idCustomer;
        this.createdAt = _createdAt;

        this.validate();
    }

    private void validate() {
        if(StringUtils.isEmpty(this.id)){
            throw new IllegalArgumentException("ID must not be empty");
        }
        if(StringUtils.isEmpty(this.title)){
            throw new IllegalArgumentException("Title must not be empty");
        }
        if(StringUtils.isEmpty(this.description)){
            throw new IllegalArgumentException("Description must not be empty");
        }
        if(this.validity == null){
            throw new IllegalArgumentException("Validity must not be null");
        }
        if(this.items == null || this.items.isEmpty()){
            throw new IllegalArgumentException("Items must not be empty");
        }
        if(this.createdAt == null){
            throw new IllegalArgumentException("Created at must not be null");
        }
        if(StringUtils.isEmpty(this.idCompany) ){
            throw new IllegalArgumentException("Company ID must not be empty");
        }
        if(StringUtils.isEmpty(this.idCustomer)){
            throw new IllegalArgumentException("Customer ID must not be empty");
        }
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }
}
