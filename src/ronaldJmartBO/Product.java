package ronaldJmartBO;


/**
 * Pembuatan Produk.    
 *
 * @author Ronald Grant
 * @version 18 September 2021
 */
public class Product extends Recognizable implements FileParser
{
    public int storeId;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    public Shipment.MultiDuration multiDuration;
    
    // private static int idCounter;
    // public int id;

    // public Product(String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category) {
    public Product(int id, int storeId, String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category, Shipment.MultiDuration multiDuration) {
        super(id);
        this.storeId = storeId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.multiDuration = multiDuration;
        this.rating = new ProductRating();
    }
    
    public Product(int id, Store store, String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category, Shipment.MultiDuration multiDuration) {
        super(id);
        this.storeId = store.id;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.multiDuration = multiDuration;
        this.rating = new ProductRating();
    }
    
    @Override
    public String toString(){
        return  "Name: " + name +
                "\nWeight: " + weight +
                "\nconditionUsed: " + conditionUsed +
                "\npriceTag: " + priceTag.getAdjustedPrice() +
                "\ncategory: " + category +
                "\nrating: " + rating.getAverage() +
                "\nstoreId: " + storeId;
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