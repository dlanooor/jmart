package com.ronaldJmartBO;

import com.ronaldJmartBO.dbjson.Serializable;

/**
 * Represent Coupon Model
 *
 * @author Ronald Grant
 * @version 18 Sept 2021
 */
public class Coupon extends Serializable
{
    /**
     * The Name.
     */
    public final String name;
    /**
     * The Code.
     */
    public final int code;
    /**
     * The Cut.
     */
    public final double cut;
    /**
     * The Type.
     */
    public final Type type;
    /**
     * The Minimum.
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
     * Is used boolean.
     *
     * @return the boolean
     */
    public boolean isUsed() {
        return used;
    }

    /**
     * Can apply boolean.
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
     * Apply double.
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
     * The enum Type.
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