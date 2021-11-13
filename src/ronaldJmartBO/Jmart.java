package ronaldJmartBO;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Aplikasi Jmart
 *
 * @author Ronald Grant
 * @version 11 September 2021
 */

public class Jmart
{
    class Country {
        public String name;
        public int population;
        public List<String> listOfStates;
    }

    public static void main(String[] args) {
        //lokasi path city.json
//        String filepath = "/Backup/Kuliah/Semester 5/Praktikum/[OOP] Pemrograman Berorientasi Objek/jmart/src/city.json";
//        Gson gson = new Gson();
//        try {
//            BufferedReader br = new BufferedReader(new FileReader(filepath));
//            Country input = gson.fromJson(br, Country.class);
//            System.out.println("name: " + input.name);
//            System.out.println("population: " + input.population);
//            System.out.println("states:");
//            input.listOfStates.forEach(state -> System.out.println(state));
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }

//         randomProductList.json
        try {
            List<Product> list = read("F:\\Backup\\Kuliah\\Semester 5\\Praktikum\\[OOP] Pemrograman Berorientasi Objek\\jmart\\src\\randomProductList.json");
            List<Product> filtered = filterByPrice(list, 13000.0, 15000.0);
//            filtered.forEach(product -> System.out.println(product.price));

            List<Product> filteredName1 = filterByName(list, "gtx", 1, 5);
            filteredName1.forEach(product -> System.out.println(product.name));

            System.out.println();

            List<Product> filteredAccountID = filterByAccountid(list, 1, 0, 5);
            filteredAccountID.forEach(product -> System.out.println(product.name));
        }
        catch (Throwable t) {
            t.printStackTrace();
        }

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

    private static List<Product> paginate(List<Product> list, int page, int pageSize, Predicate<Product> pred) {
        List<Product> pagination = new ArrayList<>();

        for(Product lists : list) {
            if(pred.predicate(lists)) {
                pagination.add(lists);
            }
        }

        if(pageSize < 0 || page < 0) {
            throw new IllegalArgumentException("Invalid Page Size: " + pageSize);
        }

        int fromIndex = page * pageSize;
        if(pagination == null || pagination.size() <= fromIndex){
            return Collections.emptyList();
        }

        return pagination.subList(fromIndex, Math.min(fromIndex + pageSize, pagination.size()));
    }

    public static List<Product> filterByAccountid(List<Product> list, int accountid, int page, int pageSize) {
        List<Product> accountidFilteredList = new ArrayList<>();

        Predicate<Product> predByAccountId = prodList -> (prodList.accountId == accountid);
        accountidFilteredList = paginate(list, page,pageSize, predByAccountId);

        return accountidFilteredList;
    }

    public static List<Product> filterByName(List<Product> list, String search, int page, int pageSize) {
        List<Product> nameFilteredList = new ArrayList<>();

        Predicate<Product> predByName = prodList -> prodList.name.toLowerCase().contains(search.toLowerCase());
        nameFilteredList = paginate(list, page, pageSize, predByName);

        return nameFilteredList;
    }

    public static List<Product> filterByCategory(List<Product> list, ProductCategory category) {
        List<Product> categoryFilteredList = new ArrayList<>();

        for(Product lists : list) {
            if(lists.category == category) {
                categoryFilteredList.add(lists);
            }
        }

        return categoryFilteredList;
    }

    public static List<Product> filterByPrice(List<Product> list, double minPrice, double maxPrice) {
        List<Product> listFilterByPrice = new ArrayList<>();
        if(minPrice == 0.0 && maxPrice == 0.0) return null;
        else if(minPrice == 0.0)
        {
            for(Product lists : list)
            {
                if(lists.price <= maxPrice) listFilterByPrice.add(lists);
            }
        }
        else if(maxPrice == 0.0)
        {
            for(Product lists : list)
            {
                if(lists.price >= minPrice) listFilterByPrice.add(lists);
            }
        }
        else
            for(Product lists : list)
            {
                if(lists.price >= minPrice && lists.price <= maxPrice) listFilterByPrice.add(lists);
            }
        return listFilterByPrice;
    }

    public static List<Product> read(String filepath) throws FileNotFoundException{
        final JsonReader reader = new JsonReader(new FileReader(filepath));
        Product[] entry = new Gson().fromJson(reader, Product[].class);
        List<Product> list = new ArrayList<>();
        Collections.addAll(list, entry);
        return list;
    }



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