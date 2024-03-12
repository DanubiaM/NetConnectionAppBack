package netconnection.app.back.domain.model.quotation;

import netconnection.app.back.domain.model.ValueObject;
import netconnection.app.back.domain.model.validation.Notification;

public class ItemQuotation  extends ValueObject {

    private Integer quantity;
    private Product product;

    private Float profitPercentage;

    public ItemQuotation(Integer _quantity, Product _product, Float profit) {
        super(new Notification());
        this.setQuantity(_quantity);
        this.setProduct(_product);
        this.setProfitPercentage(profit);

        valid();
    }

    private void valid() {
        if(this.notification.hasErrors()) throw new IllegalArgumentException(notification.errorMessage());

    }


    public void setQuantity(Integer quantity) {
        if(quantity == null){
            notification.addError("Quantity must not be empty");
        }
        if(quantity <= 0){
            notification.addError("Quantity must not be less or equal than 0");
        }
        this.quantity = quantity;
    }

    public void setProduct(Product product) {
        if(this.product ==  null){
            notification.addError("Product must not be empty");
        }
        this.product = product;
    }

    public void setProfitPercentage(Float profitPercentage) {
        if(profitPercentage <= 0){
            notification.addError("Profit Percentage must not be less or equal than 0");
        }
        this.profitPercentage = profitPercentage;
    }


    public Product getProduct() {
        return this.product;
    }

}
