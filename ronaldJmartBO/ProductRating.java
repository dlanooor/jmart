package ronaldJmartBO;


/**
 * Write a description of class ProductRating here.
 *
 * @author Ronald Grant
 * @version 18 September 2021
 */
public class ProductRating
{
    private long total;
    private long count;
    
    public ProductRating() {
        total = 0;
        count = 0;
    }
    
    public void insert(int rating) {
        total += rating;
        count++;
    }
    
    public double getAverage() {
        if(count == 0){
            return 0.0;
        }
        else {
            return (double)(total / count);
        }
    }
    
    public long getCount() {
        return this.count;
    }
    
    public long getTotal() {
        return this.total;
    }
}
