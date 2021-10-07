package ronaldJmartBO;

import java.util.ArrayList;

/**
 * Aplikasi Jmart
 *
 * @author Ronald Grant
 * @version 11 September 2021
 */
public class Jmart
{
    public static void main(String[] args) {
        Account accTest1 = new Account(1, "Supriyono Satu", "supriyono@ui.ac.id", "Supriyono123");
        Account accTest2 = new Account(2, "Supriyono Dua", ".supriyono@ui.ac.id", "Supriyono123");
        
        System.out.println(accTest1.validate());
        System.out.println(accTest2.validate());
        
        Complaint compTest1 = new Complaint(1, "Pengiriman tidak cepat, kurir tersesat");
        System.out.println(compTest1);
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