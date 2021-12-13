package com.ronaldJmartBO;


import java.util.ArrayList;
import java.util.Date;

/**
 * Payment Model
 *
 * @author Ronald Grant
 * @version 1.0
 * @since 27 Sept 2021
 */
public class Payment extends Invoice
{
    /**
     * The type Record.
     */
    public static class Record {
        /**
         * The Status.
         */
        public Invoice.Status status;
        /**
         * The Date.
         */
        public final Date date;
        /**
         * The Message.
         */
        public String message;

        /**
         * Instantiates a new Record.
         *
         * @param status  the status
         * @param message the message
         */
        public Record (Invoice.Status status, String message) {
            this.status = status;
            this.message = message;
            date = new Date();
        }
    }

    /**
     * The Shipment.
     */
    public Shipment shipment;
    /**
     * The Product count.
     */
    public int productCount;
    /**
     * The History.
     */
    public ArrayList<Record> history;

    /**
     * Instantiates a new Payment.
     *
     * @param buyerId      the buyer id
     * @param productId    the product id
     * @param productCount the product count
     * @param shipment     the shipment
     */
    public Payment(int buyerId, int productId, int productCount, Shipment shipment) {
        super(buyerId, productId);
        this.productCount = productCount;
        this.shipment = shipment;
        this.history = new ArrayList<Record>();
    }

    /**
     * Get total pay double.
     *
     * @param product the product
     * @return the double
     */
    public double getTotalPay(Product product){
       return product.price - (product.price * (product.discount / 100));
    }
}
