package com.ronaldJmartBO;


import com.ronaldJmartBO.dbjson.Serializable;


/**
 * Product Model
 *
 * @author Ronald Grant
 * @version 2.0
 * @since 27 September 2021
 */
public class Product extends Serializable
{
    /**
     * The Product Account id.
     */
    public int accountId;
    /**
     * The Product Category.
     */
    public ProductCategory category;
    /**
     * The Product Condition.
     */
    public boolean conditionUsed;
    /**
     * The Product Discount.
     */
    public double discount;
    /**
     * The Product Name.
     */
    public String name;
    /**
     * The Product Price.
     */
    public double price;
    /**
     * The Product Shipment plans.
     */
    public byte shipmentPlans;
    /**
     * The Product Weight.
     */
    public int weight;

    /**
     * Instantiates a new Product.
     *
     * @param accountId     the account id
     * @param name          the name
     * @param weight        the weight
     * @param conditionUsed the condition used
     * @param price         the price
     * @param discount      the discount
     * @param category      the category
     * @param shipmentPlans the shipment plans
     */
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