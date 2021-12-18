package com.ronaldJmartBO;

import com.ronaldJmartBO.dbjson.Serializable;

/**
 * Represent Coupon Model
 *
 * @author Ronald Grant
 * @version 1.0
 * @since 27 September 2021
 */
public class Coupon extends Serializable
{
    /**
     * The Coupon Name.
     */
    public final String name;
    /**
     * The Coupon Code.
     */
    public final int code;
    /**
     * The Coupon Cut.
     */
    public final double cut;
    /**
     * The Coupon Type.
     */
    public final Type type;
    /**
     * The Coupon Minimum.
     */
    public final double minimum;
    private boolean used;

    /**
     * Instantiates a new Coupon.
     *
     * @param name    the name
     * @param code    the code
     * @param type    the type
     * @param cut     the cut
     * @param minimum the minimum
     */
    public Coupon(String name, int code, Type type, double cut, double minimum) {
        this.name = name;
        this.code = code;
        this.type = type;
        this.cut = cut;
        this.minimum = minimum;
        used = false;
    }

    /**
     * Is Coupon used.
     *
     * @return the boolean
     */
    public boolean isUsed() {
        return used;
    }

    /**
     * Can apply Coupon.
     *
     * @param price    the price
     * @param discount the discount
     * @return the boolean
     */
    public boolean canApply(double price, double discount) {
        if(Treasury.getAdjustedPrice(price, discount) >= minimum && used == false)
            return true;
        else
            return false;
    }

    /**
     * Apply Coupon.
     *
     * @param price    the price
     * @param discount the discount
     * @return the double
     */
    public double apply(double price, double discount) {
        used = true;
        if(type == Type.DISCOUNT)
            return Treasury.getAdjustedPrice(price, discount) - (Treasury.getAdjustedPrice(price, discount) * cut / 100);
        else
            return Treasury.getAdjustedPrice(price, discount) - cut;
    }

    /**
     * The Coupon enum Type.
     */
    public enum Type {
        /**
         * Discount type.
         */
        DISCOUNT,
        /**
         * Rebate type.
         */
        REBATE;
    }
}