package ronaldJmartBO;


/**
 * Write a description of class Payment here.
 *
 * @author Ronald Grant
 * @version 27 Sept 2021
 */
// public class Payment extends Transaction implements FileParser
public class Payment extends Invoice
{
    // public int productId;
    // public ShipmentDuration shipmentDuration;
    public Shipment shipment;
    public int productCount;
    
    // public Payment(int id, int buyerId, Product product, ShipmentDuration shipmentDuration) {
        // super(id, buyerId, product.storeId);
        // this.productId = product.id;
        // this.shipmentDuration = shipmentDuration;
    // }
    
    // public Payment(int id, int buyerId, int storeId, int productId, ShipmentDuration shipmentDuration) {
        // super(id, buyerId, storeId);
        // this.productId = productId;
        // this.shipmentDuration = shipmentDuration;
    // }

    public Payment(int buyerId, int productId, int productCount, Shipment shipment) {
        super(buyerId, productId);
        this.productCount = productCount;
        this.shipment = shipment;
    }

    public double getTotalPay(){
        return 0;
    }
//    @Override
//    public boolean validate() {
//        return false;
//    }
//
//    @Override
//    public Invoice perform() {
//        return null;
//    }
}
