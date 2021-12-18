package com.ronaldJmartBO;


/**
 * Price Tag
 *
 * @author Ronald Grant
 * @version 1.0
 * @since 18 September 2021
 */
public class Treasury
{
    /**
     * The constant COMMISSION_MULTIPLIER.
     */
    public static double COMMISSION_MULTIPLIER = 0.05;
    /**
     * The constant BOTTOM_PRICE.
     */
    public static double BOTTOM_PRICE = 20000.0;
    /**
     * The constant BOTTOM_FEE.
     */
    public static double BOTTOM_FEE = 1000.0;

    /**
     * Gets adjusted price.
     *
     * @param price    the price
     * @param discount the discount
     * @return the adjusted price
     */
    public static double getAdjustedPrice(double price, double discount) {
        return getDiscountedPrice(price, discount) + getAdminFee(price, discount);
    }

    /**
     * Gets admin fee.
     *
     * @param price    the price
     * @param discount the discount
     * @return the admin fee
     */
    public static double getAdminFee(double price, double discount) {
        if(getDiscountedPrice(price, discount) < BOTTOM_PRICE) {
            return BOTTOM_FEE;
        }
        else {
            return getDiscountedPrice(price, discount) * COMMISSION_MULTIPLIER;
        }
    }

    /**
     * Gets Discounted Price.
     *
     * @param price    the price
     * @param discount the discount
     * @return Discounted Price
     */
    private static double getDiscountedPrice(double price, double discount) {
        if(discount > 100.0) {
            discount = 100;
        }
        if(discount == 100.0) {
            return 0.0;
        }
        else {
            return price - (price * discount / 100);
        }
    }
}
