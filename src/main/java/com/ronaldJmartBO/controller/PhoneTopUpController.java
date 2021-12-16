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
    @JsonAutowired(value = PhoneTopUp.class, filepath = "F:\\Backup\\Kuliah\\Semester 5\\Praktikum\\[OOP] Pemrograman Berorientasi Objek\\jmart\\json\\phonetopup.json")
    public static JsonTable<PhoneTopUp> phoneTopUpTable;

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

    @GetMapping("/{id}/phone")
    List<PhoneTopUp> getPhoneTopUp(@PathVariable int id, @RequestParam int page, @RequestParam int pageSize) {
        List<PhoneTopUp> list = new ArrayList<>();

        System.out.println(id);
        for(PhoneTopUp phoneTopUp : getJsonTable()) {
            if(phoneTopUp.buyerId == id)
                list.add(phoneTopUp);
        }
        System.out.println("hadir");
        return list;
    }

    @Override
    public JsonTable<PhoneTopUp> getJsonTable() {
        return phoneTopUpTable;
    }
}
