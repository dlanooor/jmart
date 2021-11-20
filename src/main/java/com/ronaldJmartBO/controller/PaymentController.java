package com.ronaldJmartBO.controller;

import com.ronaldJmartBO.ObjectPoolThread;
import com.ronaldJmartBO.Payment;
import com.ronaldJmartBO.dbjson.JsonAutowired;
import com.ronaldJmartBO.dbjson.JsonTable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment>{
    public static final long DELIVERED_LIMIT_MS = 10L;
    public static final long ON_DELIVERY_LIMIT_MS = 20L;
    public static final long ON_PROGRESS_LIMIT_MS = 30L;
    public static final long WAITING_CONF_LIMIT_MS = 40L;

    @JsonAutowired(value = Payment.class, filepath = "F:\\Backup\\Kuliah\\Semester 5\\Praktikum\\[OOP] Pemrograman Berorientasi Objek\\jmart\\account.json")
    public static JsonTable<Payment> paymentTable;
    public static ObjectPoolThread<Payment> poolThread;

    @PostMapping("/{id}/accept")
    boolean accept(int id) {
        return false;
    }

    @PostMapping("/{id}/cancel")
    boolean cancel(int id) {
        return false;
    }

    @PostMapping("/create")
    Payment create(int buyerId, int productId, int productCount, String shipmentAddress, byte shipmentPlan) {
        return null;
    }

    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }

    @PostMapping("/{id}/submit")
    boolean submit(int id, String receipt) {
        return false;
    }

    static boolean timekeeper(Payment payment) {
        return false;
    }
}
