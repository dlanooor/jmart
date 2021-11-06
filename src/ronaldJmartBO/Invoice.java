package ronaldJmartBO;


/**
 * Abstract class Invoice
 *
 * @author Ronald Grant
 * @version 27 Sept 2021
 */

import java.util.Date;
import java.util.ArrayList;
// sebelum FileParser dihapus
//public abstract class Invoice extends Recognizable implements FileParser
public abstract class Invoice extends Serializable
{
    public enum Rating {
        NONE,
        BAD,
        NEUTRAL,
        GOOD;
    }
    
    public enum Status {
        WAITING_CONFIRMATION,
        CANCELLED,
        ON_PROGRESS,
        ON_DELIVERY,
        COMPLAINT,
        FINISHED,
        FAILED;
    }
    
    public class Record {
        public Status status;
        public Date date;
        public String message;
    }
    
    public final Date date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;
    public Status status;
    public ArrayList<Record> history;

//    protected Invoice(int id, int buyerId, int productId)
//    {
//        super(id);
//        this.buyerId = buyerId;
//        this.productId = productId;
//        date = new Date();
//        rating = Rating.NONE;
//        status = Status.WAITING_CONFIRMATION;
//    }

    protected Invoice(int buyerId, int productId)
    {
        this.buyerId = buyerId;
        this.productId = productId;
        date = new Date();
        rating = Rating.NONE;
        status = Status.WAITING_CONFIRMATION;
    }

//    @Override
//    public boolean read(String content) {
//        return false;
//    }
}
