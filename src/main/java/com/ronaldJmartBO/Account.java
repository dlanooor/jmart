package com.ronaldJmartBO;

import com.ronaldJmartBO.dbjson.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Account
 *
 * @author Ronald Grant
 * @version 27 Sept 2021
 */

// sebelum FileParser dihapus
// public class Account extends Recognizable implements FileParser
public class Account extends Serializable
{
    public String name;
    public String email;
    public String password;
    public double balance;
    public Store store;
    public static final String REGEX_EMAIL = "^\\w+([\\.]?[&\\*~\\w+])*@\\w+([\\.-]?)*(\\.\\w{2,3})+$";
    public static final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$)(?=.*[A-Z]).{8,}$";

//    sebelum super dihapus (pt modul 5)
//    Account(int id, String name, String email, String password) {
//        super(id);
//        this.name = name;
//        this.email = email;
//        this.password = password;
//    }

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
    
    public boolean validate() {
        Pattern patternEmail = Pattern.compile(REGEX_EMAIL);
        Matcher matcherEmail = patternEmail.matcher(email);
        
        Pattern patternPassword = Pattern.compile(REGEX_PASSWORD );
        Matcher matcherPassword = patternPassword.matcher(password);
        
        return matcherEmail.find() && matcherPassword.find();
    }
    
//    @Override
//    public boolean read(String content) {
//        return false;
//    }
//
//    @Override
//    public Object write() {
//        return null;
//    }
}
