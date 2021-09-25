package ronaldJmartBO;


/**
 * Pembuatan Produk.    
 *
 * @author Ronald Grant
 * @version 18 September 2021
 */
public class Product extends Recognizable implements FileParser
{
    private static int idCounter;
    public int id;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    public int storeId;
    
    // public Product(String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category) {
    public Product(int id, int storeId, String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category) {
        super(id);
        this.id = storeId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.rating = new ProductRating();
        idCounter++;
    }
    
    public Product(int id, Store store, String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category) {
        super(id);
        this.id = store.id;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.rating = new ProductRating();
        idCounter++;
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