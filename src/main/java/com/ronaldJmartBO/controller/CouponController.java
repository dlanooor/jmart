package com.ronaldJmartBO.controller;

import com.ronaldJmartBO.*;
import com.ronaldJmartBO.dbjson.JsonAutowired;
import com.ronaldJmartBO.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Represents Coupon Controller to Connect with Android
 *
 * @author Ronald Grant
 * @version 1.0
 * @since 3 December 2021
 */
@RestController
@RequestMapping("/coupon")
public class CouponController implements BasicGetController<Coupon> {
    /**
     * The Coupon table (get from .json file).
     */
    @JsonAutowired(value = Coupon.class, filepath = "F:\\Backup\\Kuliah\\Semester 5\\Praktikum\\[OOP] Pemrograman Berorientasi Objek\\jmart\\json\\coupon.json")
    public static JsonTable<Coupon> couponTable;

    public JsonTable<Coupon> getJsonTable() {
        return couponTable;
    }

    /**
     * Can apply Coupon.
     *
     * @param id       the id
     * @param price    the price
     * @param discount the discount
     * @return the boolean
     */
    @GetMapping("/{id}/canApply")
    boolean canApply(@PathVariable int id, @RequestParam double price, @RequestParam double discount) {
        for (Coupon coupon : couponTable) {
            if(coupon.id == id)
                return coupon.canApply(price, discount);
        }
        return false;
    }

    /**
     * Is Coupon used.
     *
     * @param id the id
     * @return the boolean
     */
    @GetMapping("/{id}/isUsed")
    boolean isUsed(@PathVariable int id) {
        for (Coupon coupon : couponTable) {
            if(coupon.id == id)
                return coupon.isUsed();
        }
        return false;
    }

    /**
     * Gets available Coupon.
     *
     * @param page     the page
     * @param pageSize the page size
     * @return the available
     */
    @GetMapping("/getAvailable")
    List<Coupon> getAvailable(@RequestParam int page, @RequestParam int pageSize) {
        Predicate<Coupon> couponPredicate = available -> available.isUsed();
        return Algorithm.paginate(getJsonTable(), page, pageSize, couponPredicate);
    }
}
