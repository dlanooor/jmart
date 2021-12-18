package com.ronaldJmartBO;

import com.ronaldJmartBO.dbjson.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Account Model
 *
 * @author Ronald Grant
 * @version 2.0
 * @since 3 December 2021
 */
public class Account extends Serializable
{
    /**
     * The Account Name.
     */
    public String name;
    /**
     * The Account Email.
     */
    public String email;
    /**
     * The Account Password.
     */
    public String password;
    /**
     * The Account Balance.
     */
    public double balance;
    /**
     * The Account Store.
     */
    public Store store;
    /**
     * The constant REGEX_EMAIL.
     */
    public static final String REGEX_EMAIL = "^\\w+([\\.]?[&\\*~\\w+])*@\\w+([\\.-]?)*(\\.\\w{2,3})+$";
    /**
     * The constant REGEX_PASSWORD.
     */
    public static final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$)(?=.*[A-Z]).{8,}$";

    /**
     * Instantiates a new Account.
     *
     * @param name     the name
     * @param email    the email
     * @param password the password
     * @param balance  the balance
     */
    public Account(String name, String email, String password, double balance) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }

    public String toString() {
        return  "name: " + name +
                "\nemail: " + email +
                "\npassword: " + password +
                "\nbalance: " + balance;
    }

    /**
     * Validate email and password.
     *
     * @return the boolean
     */
    public boolean validate() {
        Pattern patternEmail = Pattern.compile(REGEX_EMAIL);
        Matcher matcherEmail = patternEmail.matcher(email);
        
        Pattern patternPassword = Pattern.compile(REGEX_PASSWORD );
        Matcher matcherPassword = patternPassword.matcher(password);
        
        return matcherEmail.find() && matcherPassword.find();
    }
}
