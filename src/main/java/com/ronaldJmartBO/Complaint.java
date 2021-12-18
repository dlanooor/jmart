package com.ronaldJmartBO;


/**
 * Complaint Model
 *
 * @author Ronald Grant
 * @version 1.0
 * @since 27 September 2021
 */


import com.ronaldJmartBO.dbjson.Serializable;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * The type Complaint.
 */
public class Complaint extends Serializable
{
    /**
     * The Complaint Date.
     */
    public final Date date;
    /**
     * The Complaint Desc.
     */
    public String desc;

    /**
     * Instantiates a new Complaint.
     *
     * @param desc the desc
     */
    public Complaint(String desc) {
        date = new Date();
        this.desc = desc;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy");
        return "Complaint{date=" + formatDate.format(date) + ",desc='" + desc + "'}";
    }
}
