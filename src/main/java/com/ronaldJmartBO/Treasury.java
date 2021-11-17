package com.ronaldJmartBO;


/**
 * Price Tag
 *
 * @author Ronald Grant
 * @version 18 September 2021
 */
public class Treasury
{
    public static double COMMISSION_MULTIPLIER = 0.05;
    public static double BOTTOM_PRICE = 20000.0;
    public static double BOTTOM_FEE = 1000.0;

//    public Treasury(double price) {
//        this.price = price;
//        this.discount = 0.0;
//    }
//
//    public Treasury(double price, double discount) {
//        this.price = price;
//        this.discount = discount;
//    }
    
    public static double getAdjustedPrice(double price, double discount) {
        return getDiscountedPrice(price, discount) + getAdminFee(price, discount);
    }
    
    public static double getAdminFee(double price, double discount) {
        if(getDiscountedPrice(price, discount) < BOTTOM_PRICE) {
            return BOTTOM_FEE;
        }
        else {
            return getDiscountedPrice(price, discount) * COMMISSION_MULTIPLIER;
        }
    }
    
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
