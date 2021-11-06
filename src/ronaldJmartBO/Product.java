package ronaldJmartBO;


/**
 * Pembuatan Produk.    
 *
 * @author Ronald Grant
 * @version 18 September 2021
 */

// sebelum FileParser dihapus
// public class Product extends Recognizable implements FileParser
public class Product extends Serializable
{
//    public int storeId;
    public int accountId;
    public ProductCategory category;
//    public String name;
    public boolean conditionUsed;
    public double discount;
    public String name;
    public double price;
    public byte shipmentPlans;
    public int weight;

//    public PriceTag priceTag;

//    public ProductRating rating;
//    public Shipment.MultiDuration multiDuration;
    
    // private static int idCounter;
    // public int id;

    // public Product(String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category) {

//    sebelum super dihapus (pt modul 5)
//    public Product(int id, int storeId, String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category, Shipment.MultiDuration multiDuration) {
//        super(id);
//        this.storeId = storeId;
//        this.name = name;
//        this.weight = weight;
//        this.conditionUsed = conditionUsed;
//        this.priceTag = priceTag;
//        this.category = category;
//        this.multiDuration = multiDuration;
//        this.rating = new ProductRating();
//    }
//
//    public Product(int id, Store store, String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category, Shipment.MultiDuration multiDuration) {
//        super(id);
//        this.storeId = store.id;
//        this.name = name;
//        this.weight = weight;
//        this.conditionUsed = conditionUsed;
//        this.priceTag = priceTag;
//        this.category = category;
//        this.multiDuration = multiDuration;
//        this.rating = new ProductRating();
//    }

//    public Product(int accountId, String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category, Shipment.MultiDuration multiDuration) {
    public Product(int accountId, String name, int weight, boolean conditionUsed, double price, double discount, ProductCategory category, byte shipmentPlans) {
        this.accountId = accountId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.price = price;
        this.discount = discount;
        this.category = category;
        this.shipmentPlans = shipmentPlans;
    }

//    public Product(Store store, String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category, Shipment.MultiDuration multiDuration) {
//        this.storeId = store.id;
//        this.name = name;
//        this.weight = weight;
//        this.conditionUsed = conditionUsed;
//        this.priceTag = priceTag;
//        this.category = category;
//        this.multiDuration = multiDuration;
//        this.rating = new ProductRating();
//    }
    
    @Override
    public String toString(){
        return  "accountID: " + accountId +
                "\nName: " + name +
                "\nWeight: " + weight +
                "\nconditionUsed: " + conditionUsed +
                "\nprice: " + price +
                "\nshipmentPlans: " + shipmentPlans +
                "\ndiscount: " + discount +
//                "\npriceTag: " + priceTag.getAdjustedPrice() +
                "\ncategory: " + category;
//                "\nrating: " + rating.getAverage() +
//                "\nstoreId: " + storeId;
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