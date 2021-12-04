package com.ronaldJmartBO;

/**
 * Abstract Class Invoice
 *
 * @author Ronald Grant
 * @version 1.0
 * @since 27 Sept 2021
 */

import com.ronaldJmartBO.dbjson.Serializable;

import java.util.Date;

/**
 * The type Invoice.
 */
public abstract class Invoice extends Serializable
{
    /**
     * The enum Rating.
     */
    public static enum Rating {
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
     * The enum Status.
     */
    public static enum Status {
        /**
         * Waiting confirmation status.
         */
        WAITING_CONFIRMATION,
        /**
         * Cancelled status.
         */
        CANCELLED,
        /**
         * On progress status.
         */
        ON_PROGRESS,
        /**
         * On delivery status.
         */
        ON_DELIVERY,
        /**
         * Complaint status.
         */
        COMPLAINT,
        /**
         * Finished status.
         */
        FINISHED,
        /**
         * Delivered status.
         */
        DELIVERED,
        /**
         * Failed status.
         */
        FAILED;
    }

    /**
     * The Date.
     */
    public final Date date;
    /**
     * The Buyer id.
     */
    public int buyerId;
    /**
     * The Product id.
     */
    public int productId;
    /**
     * The Complaint id.
     */
    public int complaintId;
    /**
     * The Rating.
     */
    public Rating rating;

    /**
     * Instantiates a new Invoice.
     *
     * @param buyerId   the buyer id
     * @param productId the product id
     */
    protected Invoice(int buyerId, int productId)
    {
        this.buyerId = buyerId;
        this.productId = productId;
        date = new Date();
        rating = Rating.NONE;
        complaintId = -1;
    }
}