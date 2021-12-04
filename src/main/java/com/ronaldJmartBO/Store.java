package com.ronaldJmartBO;

import com.ronaldJmartBO.dbjson.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Store Model
 *
 * @author Ronald Grant
 * @version 1.0
 * @since 27 Sept 2021
 */
public class Store extends Serializable
{
    /**
     * The Name.
     */
    public String name;
    /**
     * The Address.
     */
    public String address;
    /**
     * The Phone number.
     */
    public String phoneNumber;
    /**
     * The Balance.
     */
    public double balance;
    /**
     * The constant REGEX_PHONE.
     */
    public static final String REGEX_PHONE = "^[0-9]{9,12}\b";
    /**
     * The constant REGEX_NAME.
     */
    public static final String REGEX_NAME = "^[A-Z][a-z\\sa-z]{4,19}\b";

    /**
     * Instantiates a new Store.
     *
     * @param name        the name
     * @param address     the address
     * @param phoneNumber the phone number
     * @param balance     the balance
     */
    public Store(String name, String address, String phoneNumber, double balance)
    {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public String toString() {
        return  "name: " + name +
                "\naddress: " + address +
                "\nphoneNumber: " + phoneNumber;
    }

    /**
     * Validate boolean.
     *
     * @return the boolean
     */
    public boolean validate() {
        Pattern patternPhone = Pattern.compile(REGEX_PHONE);
        Matcher matcherPhone = patternPhone.matcher(phoneNumber);
        
        Pattern patternName = Pattern.compile(REGEX_NAME);
        Matcher matcherName = patternName.matcher(name);
        
        return matcherPhone.find() && matcherName.find();
    }
}