package ronaldJmartBO;


/**
 * Pembuatan Produk.    
 *
 * @author Ronald Grant
 * @version 18 September 2021
 */
public class Product
{
    private static int idCounter;
    public int id;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    
    public Product(String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category) {
        this.id = idCounter;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.rating = new ProductRating();
        idCounter++;
    }
}