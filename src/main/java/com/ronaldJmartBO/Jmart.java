package com.ronaldJmartBO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Aplikasi Jmart
 *
 * @author Ronald Grant
 * @version 11 September 2021
 */

@SpringBootApplication
public class Jmart
{
    public static long DELIVERED_LIMIT_MS = 10L;
    public static long ON_DELIVERY_LIMIT_MS = 20L;
    public static long ON_PROGRESS_LIMIT_MS = 30L;
    public static long WAITING_CONF_LIMIT_MS = 40L;

    public static void main(String[] args) {
        SpringApplication.run(Jmart.class, args);
//        try {
//            List<Product> list = read("F:\\Backup\\Kuliah\\Semester 5\\Praktikum\\[OOP] Pemrograman Berorientasi Objek\\jmart\\src\\randomProductList.json");
//            List<Product> filtered = filterByPrice(list, 13000.0, 15000.0);
//            filtered.forEach(product -> System.out.println(product.price));
//
//            List<Product> filteredName1 = filterByName(list, "gtx", 1, 5);
//            filteredName1.forEach(product -> System.out.println(product.name));
//
//            System.out.println();
//
//            List<Product> filteredAccountID = filterByAccountid(list, 1, 0, 5);
//            filteredAccountID.forEach(product -> System.out.println(product.name));
//        }
//        catch (Throwable t) {
//            t.printStackTrace();
//        }

//        try {
//            // sesuaikan argument dibawah dengan lokasi resource file yang anda unduh di EMAS!
//            JsonTable<Payment> table = new JsonTable<>(Payment.class, "F:\\Backup\\Kuliah\\Semester 5\\Praktikum\\[OOP] Pemrograman Berorientasi Objek\\jmart\\src\\randomPaymentList.json");
//
//            // membuat thread untuk payment pool
//            ObjectPoolThread<Payment> paymentPool = new ObjectPoolThread<Payment>("Thread-PP", Jmart::paymentTimekeeper);
//
//            // menjalankan thread (ingat start bukan run), run melakukan instruksi dalam current thread
//            paymentPool.start();
//
//            // tambahkan seluruh payment hasil baca ke dalam pool
////            table.forEach(payment -> paymentPool.add(payment));
//
//            // berikan sinyal untuk keluar dari routine apabila seluruh objek telah di proses
//            while(paymentPool.size() != 0);
//            paymentPool.exit();
//
//            // tunggu hingga thread selesai dieksekusi
//            while(paymentPool.isAlive());
//            // thread telah berhasil diselesaikan
//            System.out.println("Thread exited successfully");
//
//            // cek hasil output
//            Gson gson = new Gson();
////            table.forEach(payment -> {
////                String history = gson.toJson(payment.history);
////                System.out.println(history);
////            });
//
////            String filepath = "F:\\Backup\\Kuliah\\Semester 5\\Praktikum\\[OOP] Pemrograman Berorientasi Objek\\jmart\\src\\account.json";
////
////            JsonTable<Account> tableAccount = new JsonTable<>(Account.class, filepath);
////            tableAccount.add(new Account("name", "email", "password", 10000));
////            tableAccount.writeJson();
////
////            tableAccount = new JsonTable<>(Account.class, filepath);
////            tableAccount.forEach(account -> System.out.println(account.toString()));
//        }
//        catch (Throwable t) {
//            t.printStackTrace();
//        }
//        System.out.println();
//        System.out.println("account id: " + new Account(null, null, null, -1).id);
//        System.out.println("account id: " + new Account(null, null, null, -1).id);
//        System.out.println("account id: " + new Account(null, null, null, -1).id);
//
//        System.out.println();
//        System.out.println("payment id: " + new Payment(-1, -1, -1, null).id);
//        System.out.println("payment id: " + new Payment(-1, -1, -1, null).id);
//        System.out.println("payment id: " + new Payment(-1, -1, -1, null).id);

//        Account accTest1 = new Account(1, "Supriyono Satu", "supriyono@ui.ac.id", "Supriyono123");
//        Account accTest2 = new Account(2, "Supriyono Dua", ".supriyono@ui.ac.id", "Supriyono123");
//
//        System.out.println(accTest1.validate());
//        System.out.println(accTest2.validate());
//
//        Complaint compTest1 = new Complaint(1, "Pengiriman tidak cepat, kurir tersesat");
//        System.out.println(compTest1);
        // createCoupon();
        // createShipmentDuration();
        // create();
        // int before = 10000;
        // int after = 7000;
        
        // System.out.println("Promo = " + getPromo());
        // System.out.println("Customer = " + getCustomer());
        // System.out.println("Discount Percentage = " + getDiscountPercentage(before, after));
        // System.out.println("Discounted Price = " + getDiscountedPrice(before, getDiscountPercentage(before, after)));
        // System.out.println("Original Price = " + getOriginalPrice(getDiscountedPrice(before, getDiscountPercentage(before, after)), getDiscountPercentage(before, after)));
        // System.out.println("Commission Multiplier = " + getCommissionMultiplier());
        // System.out.println("Adjusted Price = " + getAdjustedPrice(getDiscountedPrice(before, getDiscountPercentage(before, after))));
        // System.out.println("Admin Fee = " + getAdminFee(getDiscountedPrice(before, getDiscountPercentage(before, after))));
    }

    public static boolean paymentTimekeeper(Payment payment) {
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

//    private static List<Product> paginate(List<Product> list, int page, int pageSize, Predicate<Product> pred) {
//        List<Product> pagination = new ArrayList<>();
//
//        for(Product lists : list) {
//            if(pred.predicate(lists)) {
//                pagination.add(lists);
//            }
//        }
//
//        if(pageSize < 0 || page < 0) {
//            throw new IllegalArgumentException("Invalid Page Size: " + pageSize);
//        }
//
//        int fromIndex = page * pageSize;
//        if(pagination == null || pagination.size() <= fromIndex){
//            return Collections.emptyList();
//        }
//
//        return pagination.subList(fromIndex, Math.min(fromIndex + pageSize, pagination.size()));
//    }
//
//    public static List<Product> filterByAccountid(List<Product> list, int accountid, int page, int pageSize) {
//        List<Product> accountidFilteredList = new ArrayList<>();
//
//        Predicate<Product> predByAccountId = prodList -> (prodList.accountId == accountid);
//        accountidFilteredList = paginate(list, page,pageSize, predByAccountId);
//
//        return accountidFilteredList;
//    }
//
//    public static List<Product> filterByName(List<Product> list, String search, int page, int pageSize) {
//        List<Product> nameFilteredList = new ArrayList<>();
//
//        Predicate<Product> predByName = prodList -> prodList.name.toLowerCase().contains(search.toLowerCase());
//        nameFilteredList = paginate(list, page, pageSize, predByName);
//
//        return nameFilteredList;
//    }
//
//    public static List<Product> filterByCategory(List<Product> list, ProductCategory category) {
//        List<Product> categoryFilteredList = new ArrayList<>();
//
//        for(Product lists : list) {
//            if(lists.category == category) {
//                categoryFilteredList.add(lists);
//            }
//        }
//
//        return categoryFilteredList;
//    }
//
//    public static List<Product> filterByPrice(List<Product> list, double minPrice, double maxPrice) {
//        List<Product> listFilterByPrice = new ArrayList<>();
//        if(minPrice == 0.0 && maxPrice == 0.0) return null;
//        else if(minPrice == 0.0)
//        {
//            for(Product lists : list)
//            {
//                if(lists.price <= maxPrice) listFilterByPrice.add(lists);
//            }
//        }
//        else if(maxPrice == 0.0)
//        {
//            for(Product lists : list)
//            {
//                if(lists.price >= minPrice) listFilterByPrice.add(lists);
//            }
//        }
//        else
//            for(Product lists : list)
//            {
//                if(lists.price >= minPrice && lists.price <= maxPrice) listFilterByPrice.add(lists);
//            }
//        return listFilterByPrice;
//    }
//
//    public static List<Product> read(String filepath) throws FileNotFoundException{
//        final JsonReader reader = new JsonReader(new FileReader(filepath));
//        Product[] entry = new Gson().fromJson(reader, Product[].class);
//        List<Product> list = new ArrayList<>();
//        Collections.addAll(list, entry);
//        return list;
//    }



    // public static Product create() {
        // // ProductCategory category = ProductCategory.GAMING;
        // // PriceTag priceTag = new PriceTag(10000, 50);
        
        // // Product product = new Product("PS4", false, priceTag, category);
        // return new Product("PS4", 4, false, new PriceTag(10000, 50), ProductCategory.GAMING);
    // }
    
    // public static Product createProduct(){
        // return new Product("PS5", 4, false, new PriceTag(20000, 50), ProductCategory.GAMING);
    // }
    
    // public static Coupon createCoupon(){
        // return new Coupon("Coupon 1", 1, Type.DISCOUNT, 20.5, 20000);
    // }
    
    // public static ShipmentDuration createShipmentDuration(){
        // return new ShipmentDuration(ShipmentDuration.KARGO, ShipmentDuration.REGULER);
    // }
    
    // public static int getPromo() {
        // return 0;
    // }
    
    // public static String getCustomer() {
        // return "oop";
    // }
    
    // public static float getDiscountPercentage(int before, int after) {
        // int potonganHarga = before - after;
        // if (before < after) {
            // return 0.0f;
        // }
        // else {
            // return (float)(potonganHarga / 100);
        // }
    // }
    
    // public static int getDiscountedPrice(int price, float discountPercentage) {
        // if(discountPercentage > 100.0f) {
            // return 100;
        // }
        // else {
            // return (int)(price - (price * discountPercentage / 100));
        // }
    // }
    
    // public static int getOriginalPrice(int discountedPrice, float discountPercentage) {
        // return (int)(discountedPrice * 100 / (100 - discountPercentage));
    // }
    
    // public static float getCommissionMultiplier() {
        // return 0.05f;
    // }
    
    // public static int getAdjustedPrice(int price) {
        // return price + (int)(price * getCommissionMultiplier());
    // }
    
    // public static int getAdminFee(int price) {
        // return (int)(price * getCommissionMultiplier());
    // }
}