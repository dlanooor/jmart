package com.ronaldJmartBO.controller;

import com.ronaldJmartBO.Account;
import com.ronaldJmartBO.Store;
import com.ronaldJmartBO.dbjson.JsonAutowired;
import com.ronaldJmartBO.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents Account Controller to Connect with Android
 *
 * @author Ronald Grant
 * @version 1.0
 * @since 3 December 2021
 */
@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
    /**
     * The constant REGEX_EMAIL.
     */
    public static final String REGEX_EMAIL = "^\\w+([\\.]?[&\\*~\\w+])*@\\w+([\\.-]?)*(\\.\\w{2,3})+$";
    /**
     * The constant REGEX_PASSWORD.
     */
    public static final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$)(?=.*[A-Z]).{8,}$";
    /**
     * The constant REGEX_PATTERN_EMAIL.
     */
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    /**
     * The constant REGEX_PATTERN_PASSWORD.
     */
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);

    /**
     * The Account table.
     */
    @JsonAutowired(value = Account.class, filepath = "F:\\Backup\\Kuliah\\Semester 5\\Praktikum\\[OOP] Pemrograman Berorientasi Objek\\jmart\\json\\account.json")
    public static JsonTable<Account> accountTable;

    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }

    /**
     * Login account.
     *
     * @param email    the email
     * @param password the password
     * @return the account
     */
    @PostMapping("/login")
    Account login(@RequestParam String email, @RequestParam String password) {
        for(Account account : accountTable) {
            try {
                // Static getInstance method is called with hashing MD5
                MessageDigest md = MessageDigest.getInstance("MD5");

                // digest() method is called to calculate message digest
                //  of an input digest() return array of byte
                byte[] messageDigest = md.digest(password.getBytes());

                // Convert byte array into signum representation
                BigInteger no = new BigInteger(1, messageDigest);

                // Convert message digest into hex value
                String hashtext = no.toString(16);
                while (hashtext.length() < 32) {
                    hashtext = "0" + hashtext;
                }

                if(account.email.equals(email) && account.password.equals(hashtext))
                    return account;
            }

            // For specifying wrong message digest algorithms
            catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    /**
     * Register account.
     *
     * @param name     the name
     * @param email    the email
     * @param password the password
     * @return the account
     */
    @PostMapping("/register")
    Account register(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        Matcher matcherEmail = REGEX_PATTERN_EMAIL.matcher(email);
        Matcher matcherPassword = REGEX_PATTERN_PASSWORD.matcher(password);

        boolean uniqueEmail = true;

        for(Account account : accountTable) {
            if(account.email.equals(email))
                uniqueEmail = false;
        }

        if(!name.isBlank() && matcherEmail.find() && matcherPassword.find() && uniqueEmail) {
            try {
                // Static getInstance method is called with hashing MD5
                MessageDigest md = MessageDigest.getInstance("MD5");

                // digest() method is called to calculate message digest
                //  of an input digest() return array of byte
                byte[] messageDigest = md.digest(password.getBytes());

                // Convert byte array into signum representation
                BigInteger no = new BigInteger(1, messageDigest);

                // Convert message digest into hex value
                String hashtext = no.toString(16);
                while (hashtext.length() < 32) {
                    hashtext = "0" + hashtext;
                }

                Account newAccount = new Account(name, email, hashtext, 0.0);
                accountTable.add(newAccount);
                return newAccount;
            }

            // For specifying wrong message digest algorithms
            catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }

        return null;
    }

    /**
     * Register store store.
     *
     * @param id          the id
     * @param name        the name
     * @param address     the address
     * @param phoneNumber the phone number
     * @return the store
     */
    @PostMapping("/{id}/registerStore")
    Store registerStore(@PathVariable int id, @RequestParam String name, @RequestParam String address, @RequestParam String phoneNumber) {
        for(Account account : accountTable) {
            if(account.id == id && account.store == null){
                account.store = new Store(name, address, phoneNumber, 0.0);
                return account.store;
            }
        }
        return null;
    }

    /**
     * Top up boolean.
     *
     * @param id      the id
     * @param balance the balance
     * @return the boolean
     */
    @PostMapping("/{id}/topUp")
    boolean topUp(@PathVariable int id, @RequestParam Double balance) {
        for(Account account : accountTable) {
            if(account.id == id) {
                account.balance += balance;
                return true;
            }
        }
        return false;
    }
}