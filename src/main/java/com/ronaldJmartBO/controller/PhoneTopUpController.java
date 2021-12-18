package com.ronaldJmartBO.controller;

import com.ronaldJmartBO.Account;
import com.ronaldJmartBO.Invoice;
import com.ronaldJmartBO.PhoneTopUp;
import com.ronaldJmartBO.dbjson.JsonAutowired;
import com.ronaldJmartBO.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents Phone Top Up Controller to Connect with Android
 *
 * @author Ronald Grant
 * @version 1.0
 * @since 15 December 2021
 */
@RestController
@RequestMapping("/phonetopup")
public class PhoneTopUpController implements BasicGetController<PhoneTopUp>{
    /**
     * The Phone top up table (get from .json file).
     */
    @JsonAutowired(value = PhoneTopUp.class, filepath = "F:\\Backup\\Kuliah\\Semester 5\\Praktikum\\[OOP] Pemrograman Berorientasi Objek\\jmart\\json\\phonetopup.json")
    public static JsonTable<PhoneTopUp> phoneTopUpTable;

    /**
     * Create phone top up response.
     *
     * @param accountId   the account id
     * @param phoneNumber the phone number
     * @return the phone top up
     */
    @PostMapping("/create")
    PhoneTopUp create(@RequestParam int accountId, @RequestParam String phoneNumber) {
        for(Account account : AccountController.accountTable) {
            if(account.id == accountId) {
                PhoneTopUp phoneTopUp = new PhoneTopUp(accountId, 99, phoneNumber);
                phoneTopUp.status = Invoice.Status.FINISHED;
                phoneTopUpTable.add(phoneTopUp);
                return phoneTopUp;
            }
        }
        return null;
    }

    /**
     * Gets phone top up history response.
     *
     * @param id       the id
     * @param page     the page
     * @param pageSize the page size
     * @return the phone top up
     */
    @GetMapping("/{id}/phone")
    List<PhoneTopUp> getPhoneTopUp(@PathVariable int id, @RequestParam int page, @RequestParam int pageSize) {
        List<PhoneTopUp> list = new ArrayList<>();


        for(PhoneTopUp phoneTopUp : getJsonTable()) {
            if(phoneTopUp.buyerId == id)
                list.add(phoneTopUp);
        }

        return list;
    }

    @Override
    public JsonTable<PhoneTopUp> getJsonTable() {
        return phoneTopUpTable;
    }
}
