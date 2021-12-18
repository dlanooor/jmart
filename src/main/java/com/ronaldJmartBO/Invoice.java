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
     * The enum Invoice Rating.
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
     * The enum Invoice Status.
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
     * The Invoice Date.
     */
    public final Date date;
    /**
     * The Invoice Buyer id.
     */
    public int buyerId;
    /**
     * The Invoice Product id.
     */
    public int productId;
    /**
     * The Invoice Complaint id.
     */
    public int complaintId;
    /**
     * The Invoice Rating.
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