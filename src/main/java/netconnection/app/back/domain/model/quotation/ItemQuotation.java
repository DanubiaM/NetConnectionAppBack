package netconnection.app.back.domain.model.quotation;

public class ItemQuotation {

    private Integer quantity;
    private Product product;

    private Float profitPercentage;

    public ItemQuotation(Integer _quantity, Product _product) {
        this.setQuantity(_quantity);
        this.setProduct(_product);
    }

    public void setQuantity(Integer quantity) {
        if(quantity == null){
            throw new IllegalArgumentException("Quantity must not be empty");
        }
        if(quantity <= 0){
            throw new IllegalArgumentException("Quantity must not be less or equal than 0");
        }
        this.quantity = quantity;
    }

    public void setProduct(Product product) {
        if(this.product ==  null){
            throw new IllegalArgumentException("Product must not be empty");
        }
        this.product = product;
    }

    public void setProfitPercentage(Float profitPercentage) {
        if(profitPercentage <= 0){
            throw new IllegalArgumentException("Profit Percentage must not be less or equal than 0");
        }
        this.profitPercentage = profitPercentage;
    }


    public Product getProduct() {
        return this.product;
    }

}
