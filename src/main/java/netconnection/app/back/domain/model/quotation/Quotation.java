package netconnection.app.back.domain.model.quotation;

import io.micrometer.common.util.StringUtils;
import netconnection.app.back.domain.model.Entity;
import netconnection.app.back.domain.model.validation.Notification;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Quotation extends Entity {

    private Information information;
    private LocalDate validity;
    private List<ItemQuotation> items;
    private LocalDateTime createdAt;
    private String idCompany;

    private String idCustomer;

    private STATUS_QUOTATION status;



    public Quotation(String _id, Information _information, LocalDate _validity, List<ItemQuotation> _items,
                     String _idCompany, String _idCustomer) {
        super(_id, new Notification());
        this.setInformation(_information);
        this.setValidity(_validity);
        this.setItems(_items);
        this.setIdCompany(_idCompany);
        this.setIdCustomer(_idCustomer);
        this.setCreatedAt(LocalDateTime.now());
        this.status = STATUS_QUOTATION.WAITING;

        valid();

    }

    private void valid() {
        if(this.notification.hasErrors()) notification.addError(notification.errorMessage());

    }


    private void setInformation(Information information) {
        if(information == null){
            notification.addError("Information Quotation must not be null");
        }
        this.information = information;
    }

    private void setValidity(LocalDate validity) {
        if(validity == null){
            notification.addError("Validity must not be null");
        }
        this.validity = validity;
    }

    private void setItems(List<ItemQuotation> items) {
        if(items == null || items.isEmpty()){
            notification.addError("Items must not be empty");
        }
        this.items = items;
    }

    private void setCreatedAt(LocalDateTime createdAt) {
        if(createdAt == null){
            notification.addError("Created at must not be null");
        }
        this.createdAt = createdAt;
    }

    private void setIdCompany(String idCompany) {
        if(StringUtils.isEmpty(idCompany) ){
            notification.addError("Company ID must not be empty");
        }

        this.idCompany = idCompany;
    }

    private void setIdCustomer(String idCustomer) {
        if(StringUtils.isEmpty(idCustomer)){
            notification.addError("Customer ID must not be empty");
        }
        this.idCustomer = idCustomer;
    }


}
