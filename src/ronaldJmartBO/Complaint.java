package ronaldJmartBO;


/**
 * Class Complaint
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Date;
import java.text.SimpleDateFormat;

// public class Complaint extends Transaction implements FileParser
// sebelum FileParser dihapus
// public class Complaint extends Recognizable implements FileParser
public class Complaint extends Serializable
{
    // public int paymentId;
    // public String desc;
    
    public final Date date;
    public String desc;
    
    // public Complaint(int id, Payment payment, String desc) {
        // super(id, payment.buyerId, payment.storeId);
        // paymentId = payment.id;
        // this.desc = desc;
    // }
    
    // public Complaint(int id, int buyerId, int storeId, int paymentId, String desc) {
        // super(id, buyerId, storeId);
        // this.paymentId = paymentId;
        // this.desc = desc;
    // }
    
//    public Complaint(int id, String desc) {
//        super(id);
//        date = new Date();
//        this.desc = desc;
//    }

    public Complaint(String desc) {
        date = new Date();
        this.desc = desc;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy");
        return "Complaint{date=" + formatDate.format(date) + ",desc='" + desc + "'}";
    }
    
//    @Override
//    public boolean read(String content) {
//        return false;
//    }
//
//    @Override
//    public Object write() {
//        return null;
//    }
}
