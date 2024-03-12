package netconnection.app.back.domain.model.quotation;

import io.micrometer.common.util.StringUtils;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Quotation {

    private String id;
    private Information information;
    private LocalDate validity;
    private List<ItemQuotation> items;
    private LocalDateTime createdAt;
    private String idCompany;

    private String idCustomer;

    private STATUS_QUOTATION status;



    public Quotation(String _id, Information _information, String _description, LocalDate _validity, List<ItemQuotation> _items,
                     String _idCompany, String _idCustomer) {
        this.setId(_id);
        this.setInformation(_information);
        this.setValidity(_validity);
        this.setItems(_items);
        this.setIdCompany(_idCompany);
        this.setIdCustomer(_idCustomer);
        this.setCreatedAt(LocalDateTime.now());
        this.status = STATUS_QUOTATION.WAITING;

    }

    private void setId(String id) {
        if(StringUtils.isEmpty(id)){
            throw new IllegalArgumentException("ID must not be empty");
        }
        this.id = id;
    }

    private void setInformation(Information information) {
        if(information == null){
            throw new IllegalArgumentException("Information Quotation must not be null");
        }
        this.information = information;
    }

    private void setValidity(LocalDate validity) {
        if(this.validity == null){
            throw new IllegalArgumentException("Validity must not be null");
        }
        this.validity = validity;
    }

    private void setItems(List<ItemQuotation> items) {
        if(this.items == null || this.items.isEmpty()){
            throw new IllegalArgumentException("Items must not be empty");
        }
        this.items = items;
    }

    private void setCreatedAt(LocalDateTime createdAt) {
        if(this.createdAt == null){
            throw new IllegalArgumentException("Created at must not be null");
        }
        this.createdAt = createdAt;
    }

    private void setIdCompany(String idCompany) {
        if(StringUtils.isEmpty(this.idCompany) ){
            throw new IllegalArgumentException("Company ID must not be empty");
        }

        this.idCompany = idCompany;
    }

    private void setIdCustomer(String idCustomer) {
        if(StringUtils.isEmpty(this.idCustomer)){
            throw new IllegalArgumentException("Customer ID must not be empty");
        }
        this.idCustomer = idCustomer;
    }


    public String getId() {
        return this.id;
    }

}
