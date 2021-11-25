package com.ronaldJmartBO.controller;

import com.ronaldJmartBO.*;
import com.ronaldJmartBO.dbjson.JsonAutowired;
import com.ronaldJmartBO.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coupon")
public class CouponController implements BasicGetController<Coupon> {
    @JsonAutowired(value = Coupon.class, filepath = "F:\\Backup\\Kuliah\\Semester 5\\Praktikum\\[OOP] Pemrograman Berorientasi Objek\\jmart\\account.json")
    public static JsonTable<Coupon> couponTable;

    public JsonTable<Coupon> getJsonTable() {
        return couponTable;
    }

    @GetMapping("/{id}/canApply")
    boolean canApply(@PathVariable int id, @RequestParam double price, @RequestParam double discount) {
        for (Coupon coupon : couponTable) {
            if(coupon.id == id)
                return coupon.canApply(price, discount);
        }
        return false;
    }

    @GetMapping("/{id}/isUsed")
    boolean isUsed(@PathVariable int id) {
        for (Coupon coupon : couponTable) {
            if(coupon.id == id)
                return coupon.isUsed();
        }
        return false;
    }

    @GetMapping("/getAvailable")
    List<Coupon> getAvailable(@RequestParam int page, @RequestParam int pageSize) {
        Predicate<Coupon> couponPredicate = available -> available.isUsed();
        return Algorithm.paginate(getJsonTable(), page, pageSize, couponPredicate);
    }
}
