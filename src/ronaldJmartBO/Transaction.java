package ronaldJmartBO;


/**
 * Abstract Transaksi
 *
 * @author Ronald Grant
 * @version 27 Sept 2021
 */
public abstract class Transaction extends Serializable
{
    public enum Rating {
        NONE,
        BAD,
        NEUTRAL,
        GOOD;
    }
    
    public String time = "Time";
    public int buyerId;
    public int storeId;
    public Rating rating = Rating.NONE;
    
//    protected Transaction(int id, int buyerId, int storeId) {
//        super(id);
//        this.buyerId = buyerId;
//        this.storeId = storeId;
//    }
//
//    protected Transaction(int id, Account buyer, Store store) {
//        super(id);
//        buyerId = buyer.id;
//        storeId = store.id;
//    }

    protected Transaction(int buyerId, int storeId) {
        this.buyerId = buyerId;
        this.storeId = storeId;
    }

    protected Transaction(Account buyer, Store store) {
        buyerId = buyer.id;
        storeId = store.id;
    }
}
