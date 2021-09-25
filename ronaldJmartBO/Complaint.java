package ronaldJmartBO;


/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complaint extends Transaction implements FileParser
{
    public int paymentId;
    public String desc;
    
    public Complaint(int id, Payment payment, String desc) {
        super(id, payment.buyerId, payment.storeId);
        paymentId = payment.id;
        this.desc = desc;
    }
    
    public Complaint(int id, int buyerId, int storeId, int paymentId, String desc) {
        super(id, buyerId, storeId);
        this.paymentId = paymentId;
        this.desc = desc;
    }
    
    @Override
    public boolean read(String content) {
        return false;
    }
    
    @Override
    public Object write() {
        return null;
    }
}
