package com.ronaldJmartBO;


/**
 * Pembuatan Produk.    
 *
 * @author Ronald Grant
 * @version 18 September 2021
 */

public class Product extends Serializable
{
    public int accountId;
    public ProductCategory category;
    public boolean conditionUsed;
    public double discount;
    public String name;
    public double price;
    public byte shipmentPlans;
    public int weight;

    public Product(int accountId, String name, int weight, boolean conditionUsed, double price, double discount, ProductCategory category, byte shipmentPlans) {
        this.accountId = accountId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.price = price;
        this.discount = discount;
        this.category = category;
        this.shipmentPlans = shipmentPlans;
    }
    
    @Override
    public String toString(){
        return  "accountID: " + accountId +
                "\nName: " + name +
                "\nWeight: " + weight +
                "\nconditionUsed: " + conditionUsed +
                "\nprice: " + price +
                "\nshipmentPlans: " + shipmentPlans +
                "\ndiscount: " + discount +
                "\ncategory: " + category;
    }
}