package com.ronaldJmartBO;


/**
 * Shipment Model
 *
 * @author Ronald Grant
 * @version 1.0
 * @since 27 Sept 2021
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * The type Shipment.
 */
public class Shipment
{
    /**
     * The Address.
     */
    public String address;
    /**
     * The Cost.
     */
    public int cost;
    /**
     * The Plan.
     */
    public byte plan;
    /**
     * The Receipt.
     */
    public String receipt;

    /**
     * The constant INSTANT.
     */
    public static final Plan INSTANT = new Plan((byte)(1 << 0));
    /**
     * The constant SAME_DAY.
     */
    public static final Plan SAME_DAY = new Plan((byte)(1 << 1));
    /**
     * The constant NEXT_DAY.
     */
    public static final Plan NEXT_DAY = new Plan((byte)(1 << 2));
    /**
     * The constant REGULER.
     */
    public static final Plan REGULER = new Plan((byte)(1 << 3));
    /**
     * The constant KARGO.
     */
    public static final Plan KARGO = new Plan((byte)(1 << 4));
    /**
     * The constant ESTIMATION_FORMAT.
     */
    public static final SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("EEE MMMM dd yyyy");

    /**
     * Instantiates a new Shipment.
     *
     * @param address the address
     * @param cost    the cost
     * @param plan    the plan
     * @param receipt the receipt
     */
// Constructor
    public Shipment(String address, int cost, byte plan, String receipt)
    {
        this.address = address;
        this.cost = cost;
        this.plan = plan;
        this.receipt = receipt;
    }

    /**
     * Gets estimated arrival.
     *
     * @param reference the reference
     * @return the estimated arrival
     */
    public String getEstimatedArrival(Date reference) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(reference);

        if(this.plan == INSTANT.bit)
            cal.add(Calendar.DATE, 0);
        else if(this.plan == SAME_DAY.bit)
            cal.add(Calendar.DATE, 0);
        else if(this.plan == NEXT_DAY.bit)
            cal.add(Calendar.DATE, 1);
        else if(this.plan == REGULER.bit)
            cal.add(Calendar.DATE, 2);
        else if(this.plan == KARGO.bit)
            cal.add(Calendar.DATE, 5);

        String curr_date = ESTIMATION_FORMAT.format(cal);
        return curr_date;
    }

    /**
     * Is duration boolean.
     *
     * @param reference the reference
     * @return the boolean
     */
    public boolean isDuration(Plan reference) {
        if((this.plan & reference.bit) != 0)
            return true;
        else
            return false;
    }

    /**
     * Is duration boolean.
     *
     * @param object    the object
     * @param reference the reference
     * @return the boolean
     */
    public boolean isDuration(byte object, Plan reference) {
        if((object & reference.bit) != 0)
            return true;
        else
            return false;
    }

    /**
     * The type Plan.
     */
    public static class Plan {
        /**
         * The Bit.
         */
        public final byte bit;

        private Plan(byte bit){
            this.bit = bit;
        }
    }
}
