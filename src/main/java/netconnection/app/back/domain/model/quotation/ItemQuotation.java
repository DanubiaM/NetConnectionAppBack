package netconnection.app.back.domain.model.quotation;

public class ItemQuotation {

    private Integer quantity;
    private Product product;


    public ItemQuotation(Integer _quantity, Product _product) {
        this.quantity = _quantity;
        this.product = _product;

        this.valide();
    }

    private void valide() {

        if(quantity == null){
            throw new IllegalArgumentException("Quantity must not be empty");
        }

        if(quantity <= 0){
            throw new IllegalArgumentException("Quantity must not be less or equal than 0");
        }

        if(this.product ==  null){
            throw new IllegalArgumentException("Product must not be empty");
        }

    }

    public Product getProduct() {
        return this.product;
    }

}
