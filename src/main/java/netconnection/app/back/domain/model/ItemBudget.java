package netconnection.app.back.domain.model;

public class ItemBudget {

    private Integer quantity;
    private Product product;


    public ItemBudget(Integer _quantity, Product _product) {
        this.quantity = _quantity;
        this.product = _product;

        this.valide();
    }

    private void valide() {

        if(quantity == null){
            throw new IllegalArgumentException("Amount must not be empty");
        }

        if(quantity <= 0){
            throw new IllegalArgumentException("Quantity must not be less or equal than 0");
        }

        if(this.product ==  null){
            throw new IllegalArgumentException("Amount must not be empty");
        }

    }

    public Product getProduct() {
        return this.product;
    }

}
