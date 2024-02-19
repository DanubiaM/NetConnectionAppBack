package netconnection.app.back.domain.model;

import java.util.UUID;

public class ItemBudget {

    private Integer amount;
    private Product product;


    public ItemBudget(Integer _amount, Product _product) {
        this.amount = _amount;
        this.product = _product;

        this.valide();
    }

    private void valide() {

        if(amount == null){
            throw new IllegalArgumentException("Amount must not be empty");
        }

        if(amount <= 0){
            throw new IllegalArgumentException("Amount must not be less or equal than 0");
        }

        if(this.product ==  null){
            throw new IllegalArgumentException("Amount must not be empty");
        }

    }

    public Product getProduct() {
        return this.product;
    }

}
