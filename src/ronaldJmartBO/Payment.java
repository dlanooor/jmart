package ronaldJmartBO;


import java.util.ArrayList;
import java.util.Date;

/**
 * Write a description of class Payment here.
 *
 * @author Ronald Grant
 * @version 27 Sept 2021
 */

public class Payment extends Invoice
{
    public static class Record {
        public Invoice.Status status;
        public final Date date;
        public String message;

        public Record (Invoice.Status status, String message) {
            this.status = status;
            this.message = message;
            date = new Date();
        }
    }

    public Shipment shipment;
    public int productCount;
    public ArrayList<Record> history;

    public Payment(int buyerId, int productId, int productCount, Shipment shipment) {
        super(buyerId, productId);
        this.productCount = productCount;
        this.shipment = shipment;
        this.history = new ArrayList<Record>();
    }

    public double getTotalPay(Product product){
       return product.price - product.price * product.discount;
    }
}
