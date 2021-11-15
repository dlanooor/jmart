package ronaldJmartBO;

/**
 * Abstract class Invoice
 *
 * @author Ronald Grant
 * @version 27 Sept 2021
 */

import java.util.Date;

public abstract class Invoice extends Serializable
{
    public static enum Rating {
        NONE,
        BAD,
        NEUTRAL,
        GOOD;
    }
    
    public static enum Status {
        WAITING_CONFIRMATION,
        CANCELLED,
        ON_PROGRESS,
        ON_DELIVERY,
        COMPLAINT,
        FINISHED,
        DELIVERED,
        FAILED;
    }

    public final Date date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;

    protected Invoice(int buyerId, int productId)
    {
        this.buyerId = buyerId;
        this.productId = productId;
        date = new Date();
        rating = Rating.NONE;
        complaintId = -1;
    }
}