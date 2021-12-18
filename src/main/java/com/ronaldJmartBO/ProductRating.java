package com.ronaldJmartBO;


/**
 * Product Rating
 *
 * @author Ronald Grant
 * @version 1.0
 * @since 18 September 2021
 */
public class ProductRating
{
    private long total;
    private long count;

    /**
     * Instantiates a new Product rating.
     */
    public ProductRating() {
        total = 0;
        count = 0;
    }

    /**
     * Insert ProductRating.
     *
     * @param rating the rating
     */
    public void insert(int rating) {
        total += rating;
        count++;
    }

    /**
     * Gets ProductRating average.
     *
     * @return the average
     */
    public double getAverage() {
        if(count == 0){
            return 0.0;
        }
        else {
            return (double)(total / count);
        }
    }

    /**
     * Gets ProductRating count.
     *
     * @return the count
     */
    public long getCount() {
        return this.count;
    }

    /**
     * Gets ProductRating total.
     *
     * @return the total
     */
    public long getTotal() {
        return this.total;
    }
}
