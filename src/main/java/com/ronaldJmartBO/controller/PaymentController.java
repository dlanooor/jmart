package com.ronaldJmartBO.controller;

import com.ronaldJmartBO.*;
import com.ronaldJmartBO.dbjson.JsonAutowired;
import com.ronaldJmartBO.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.ronaldJmartBO.controller.AccountController.accountTable;
import static com.ronaldJmartBO.controller.ProductController.productTable;

/**
 * Represents Payment Controller to Connect with Android
 *
 * @author Ronald Grant
 * @version 1.0
 * @since 3 December 2021
 */
@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment>{
    /**
     * The constant DELIVERED_LIMIT_MS.
     */
    public static final long DELIVERED_LIMIT_MS = 10L;
    /**
     * The constant ON_DELIVERY_LIMIT_MS.
     */
    public static final long ON_DELIVERY_LIMIT_MS = 20L;
    /**
     * The constant ON_PROGRESS_LIMIT_MS.
     */
    public static final long ON_PROGRESS_LIMIT_MS = 30L;
    /**
     * The constant WAITING_CONF_LIMIT_MS.
     */
    public static final long WAITING_CONF_LIMIT_MS = 40L;

    /**
     * The Payment table (get from .json file).
     */
    @JsonAutowired(value = Payment.class, filepath = "F:\\Backup\\Kuliah\\Semester 5\\Praktikum\\[OOP] Pemrograman Berorientasi Objek\\jmart\\json\\payment.json")
    public static JsonTable<Payment> paymentTable;
    /**
     * The Pool thread.
     */
    public static ObjectPoolThread<Payment> poolThread;

    static
    {
        poolThread = new ObjectPoolThread<Payment>("Thread", PaymentController::timekeeper);
        poolThread.start();
    }

    /**
     * Accept Payment from Store Account.
     *
     * @param id the id
     * @return the boolean
     */
    @PostMapping("/{id}/accept")
    boolean accept(@PathVariable int id) {
        Predicate<Payment> searchPayment = paymentSearch -> paymentSearch.id == id;
        Algorithm.find(paymentTable, searchPayment);
        Payment payment = Algorithm.find(paymentTable, searchPayment);

        if(Algorithm.exists(paymentTable, searchPayment) && payment.history.get(payment.history.size() - 1).status.equals(Invoice.Status.WAITING_CONFIRMATION)) {
            payment.history.add(new Payment.Record(Invoice.Status.ON_PROGRESS, "Order Processed"));
            return true;
        }
        return false;
    }

    /**
     * Cancel Payment from Store Account.
     *
     * @param id the id
     * @return the boolean
     */
    @PostMapping("/{id}/cancel")
    boolean cancel(@PathVariable int id) {
        Predicate<Payment> searchPayment = paymentSearch -> paymentSearch.id == id;
        Algorithm.find(paymentTable, searchPayment);
        Payment payment = Algorithm.find(paymentTable, searchPayment);

        if(Algorithm.exists(paymentTable, searchPayment) && payment.history.get(payment.history.size() - 1).status.equals(Invoice.Status.WAITING_CONFIRMATION)) {
            payment.history.add(new Payment.Record(Invoice.Status.CANCELLED, "Order Cancelled"));
            return true;
        }
        return false;
    }

    /**
     * Gets Payment Invoice from Account.
     *
     * @param id       the id
     * @param page     the page
     * @param pageSize the page size
     * @return the payment
     */
    @GetMapping("/{id}/invoice")
    List<Payment> getPayment(@PathVariable int id, @RequestParam int page, @RequestParam int pageSize) {
        List<Payment> list = new ArrayList<>();

        for(Payment payment : getJsonTable()) {
            if(payment.buyerId == id)
                list.add(payment);
        }

        return list;
    }

    /**
     * Gets Payment Invoice from Store Account.
     *
     * @param accountId the account id
     * @param page      the page
     * @param pageSize  the page size
     * @return the payment store
     */
    @GetMapping("/{accountId}/invoiceStore")
    List<Payment> getPaymentStore(@PathVariable int accountId, @RequestParam int page, @RequestParam int pageSize) {
        List<Payment> list = new ArrayList<>();

        for(Payment payment : getJsonTable()) {
            for (Product product : productTable){
                if(product.accountId == accountId) {
                    list.add(payment);
                }
            }
        }

        return list;
    }

    /**
     * Create payment from Account.
     *
     * @param buyerId         the buyer id
     * @param productId       the product id
     * @param productCount    the product count
     * @param shipmentAddress the shipment address
     * @param shipmentPlan    the shipment plan
     * @return the payment
     */
    @PostMapping("/create")
    Payment create(@RequestParam int buyerId, @RequestParam int productId, @RequestParam int productCount, @RequestParam String shipmentAddress, @RequestParam byte shipmentPlan) {
        Predicate<Account> searchAcc = accSearch -> accSearch.id == buyerId;
        Predicate<Product> searchProd = prodSearch -> prodSearch.id == productId;

        Account accountPayment = null;
        Product productPayment = null;

        for(Account account : accountTable) {
            if(account.id == buyerId)
                accountPayment = account;
        }

        for(Product product : productTable) {
            if(product.id == productId)
                productPayment = product;
        }

        if(accountPayment != null && productPayment != null && accountPayment.balance >= ((productPayment.price - (productPayment.price * (productPayment.discount / 100))) * productCount)) {
            Shipment shipment = new Shipment(shipmentAddress, 10000, shipmentPlan, "Receipt");
            Payment payment = new Payment(buyerId, productId, productCount, shipment);

            for(Account account : accountTable) {
                if(account.id == buyerId)
                    account.balance = account.balance - payment.getTotalPay(productPayment) * productCount;
            }
            payment.history.add(new Payment.Record(Invoice.Status.WAITING_CONFIRMATION, "Waiting Confirmation"));
            paymentTable.add(payment);
            poolThread.add(payment);
            return payment;
        }
        return null;
    }

    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }

    /**
     * Submit Payment from Store Account.
     *
     * @param id      the id
     * @param receipt the receipt
     * @return the boolean
     */
    @PostMapping("/{id}/submit")
    boolean submit(@PathVariable int id, @RequestParam String receipt) {
        Predicate<Payment> searchPayment = paymentSearch -> paymentSearch.id == id;
        Algorithm.find(paymentTable, searchPayment);
        Payment payment = Algorithm.find(paymentTable, searchPayment);

        if(Algorithm.exists(paymentTable, searchPayment) && payment.history.get(payment.history.size() - 1).status.equals(Invoice.Status.ON_PROGRESS) && !payment.shipment.receipt.isBlank()) {
            payment.shipment.receipt = receipt;
            payment.history.add(new Payment.Record(Invoice.Status.ON_DELIVERY, "Packet on Delivery"));
            for(Product product : productTable) {
                for(Account account : accountTable) {
                    if(account.id == product.accountId && product.id == payment.productId)
                        account.store.balance += ((product.price - product.price * (product.discount / 100)) * payment.productCount);
                }
            }

            return true;
        }
        return false;
    }

    /**
     * Timekeeper used For Threading.
     *
     * @param payment the payment
     * @return the boolean
     */
    static boolean timekeeper(Payment payment) {
        long elapsedTime = (new java.util.Date()).getTime() - payment.history.get(payment.history.size()-1).date.getTime();

        if(payment.history.get(payment.history.size()-1).status.equals(Invoice.Status.WAITING_CONFIRMATION) && elapsedTime > WAITING_CONF_LIMIT_MS)
            payment.history.add(new Payment.Record(Invoice.Status.FAILED, "Failed"));

        else if(payment.history.get(payment.history.size()-1).status.equals(Invoice.Status.ON_PROGRESS) && elapsedTime > ON_PROGRESS_LIMIT_MS)
            payment.history.add(new Payment.Record(Invoice.Status.FAILED, "Failed"));

        else if(payment.history.get(payment.history.size()-1).status.equals(Invoice.Status.ON_DELIVERY) && elapsedTime > ON_DELIVERY_LIMIT_MS)
            payment.history.add(new Payment.Record(Invoice.Status.DELIVERED, "Delivered"));

        else if(payment.history.get(payment.history.size() - 1).status.equals(Invoice.Status.DELIVERED) && elapsedTime > ON_DELIVERY_LIMIT_MS)
            payment.history.add(new Payment.Record(Invoice.Status.FINISHED, "Finished"));

        for(Payment.Record element: payment.history) {
            if(element.status == Invoice.Status.FINISHED || element.status == Invoice.Status.FAILED)
                payment.history.remove(element);
        }

        if(payment.history.isEmpty())
            return true;
        else
            return false;
    }
}
