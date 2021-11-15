package ronaldJmartBO;

public class PhoneTopUp extends Invoice {
    public String phoneNumber;
    public Status status;

    public PhoneTopUp(int buyerId, int productId, String phoneNumber) {
        super(buyerId, productId);
        this.phoneNumber = phoneNumber;
    }

    public double getTotal(Product product) {
        return product.price - product.price * product.discount;
    }
}
