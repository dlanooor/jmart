package com.ronaldJmartBO;


import com.ronaldJmartBO.dbjson.Serializable;

/**
 * Abstract Transaction
 *
 * @author Ronald Grant
 * @version 1.0
 * @since 27 Sept 2021
 */
public abstract class Transaction extends Serializable
{
    /**
     * The enum Rating.
     */
    public enum Rating {
        /**
         * None rating.
         */
        NONE,
        /**
         * Bad rating.
         */
        BAD,
        /**
         * Neutral rating.
         */
        NEUTRAL,
        /**
         * Good rating.
         */
        GOOD;
    }

    /**
     * The Time.
     */
    public String time = "Time";
    /**
     * The Buyer id.
     */
    public int buyerId;
    /**
     * The Store id.
     */
    public int storeId;
    /**
     * The Rating.
     */
    public Rating rating = Rating.NONE;

    /**
     * Instantiates a new Transaction.
     *
     * @param buyerId the buyer id
     * @param storeId the store id
     */
    protected Transaction(int buyerId, int storeId) {
        this.buyerId = buyerId;
        this.storeId = storeId;
    }

    /**
     * Instantiates a new Transaction.
     *
     * @param buyer the buyer
     * @param store the store
     */
    protected Transaction(Account buyer, Store store) {
        buyerId = buyer.id;
        storeId = store.id;
    }
}
