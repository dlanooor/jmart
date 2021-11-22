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

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
    public static final String REGEX_EMAIL = "^\\w+([\\.]?[&\\*~\\w+])*@\\w+([\\.-]?)*(\\.\\w{2,3})+$";
    public static final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$)(?=.*[A-Z]).{8,}$";
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);

    @JsonAutowired(value = Account.class, filepath = "F:\\Backup\\Kuliah\\Semester 5\\Praktikum\\[OOP] Pemrograman Berorientasi Objek\\jmart\\account.json")
    public static JsonTable<Account> accountTable;

    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }

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

    @PostMapping("/{id}/registerStore")
    Store registerStore(@PathVariable int id, @RequestParam String name, @RequestParam String address, @RequestParam String phoneNumber) {
        for(Account account : accountTable) {
            if(account.id == id && account.store != null){
                account.store = new Store(name, address, phoneNumber, 0.0);
                return account.store;
            }

        }
        return null;
    }

    @PostMapping("/{id}/topUp")
    boolean topUp(int id, @RequestParam double balance) {
        for(Account account : accountTable) {
            if(account.id == id) {
                account.balance += balance;
                return true;
            }
        }
        return false;
    }

//    @GetMapping
//    String index() { return "account page"; }
//
//    @PostMapping("/register")
//    Account register
//            (
//                    @RequestParam String name,
//                    @RequestParam String email,
//                    @RequestParam String password
//            )
//    {
//        return new Account(name, email, password, 0);
//    }
//
//    @GetMapping("/{id}")
//    String getById(@PathVariable int id) { return "account id " + id + " not found!"; }
}

