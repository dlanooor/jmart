package com.ronaldJmartBO;


/**
 * Phone Top Up Model
 *
 * @author Ronald Grant
 * @version 1.0
 * @since 27 September 2021
 */
public class PhoneTopUp extends Invoice {
    /**
     * The Phone number.
     */
    public String phoneNumber;
    /**
     * The Status.
     */
    public Status status;

    /**
     * Instantiates a new Phone top up.
     *
     * @param buyerId     the buyer id
     * @param productId   the product id
     * @param phoneNumber the phone number
     */
    public PhoneTopUp(int buyerId, int productId, String phoneNumber) {
        super(buyerId, productId);
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets total.
     *
     * @param product the product
     * @return the total
     */
    public double getTotal(Product product) {
        return product.price - product.price * product.discount;
    }
}
