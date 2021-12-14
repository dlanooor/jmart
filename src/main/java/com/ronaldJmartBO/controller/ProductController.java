package com.ronaldJmartBO.controller;

import com.ronaldJmartBO.*;
import com.ronaldJmartBO.dbjson.JsonAutowired;
import com.ronaldJmartBO.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents Product Controller to Connect with Android
 *
 * @author Ronald Grant
 * @version 1.0
 * @since 3 December 2021
 */
@RestController
@RequestMapping("/product")
public class ProductController implements BasicGetController<Product>{
    /**
     * The Product table.
     */
    @JsonAutowired(value = Product.class, filepath = "F:\\Backup\\Kuliah\\Semester 5\\Praktikum\\[OOP] Pemrograman Berorientasi Objek\\jmart\\json\\product.json")
    public static JsonTable<Product> productTable;

    /**
     * Create product.
     *
     * @param accountId     the account id
     * @param name          the name
     * @param weight        the weight
     * @param conditionUsed the condition used
     * @param price         the price
     * @param discount      the discount
     * @param category      the category
     * @param shipmentPlans the shipment plans
     * @return the product
     */
    @PostMapping("/create")
    Product create(@RequestParam int accountId, @RequestParam String name, @RequestParam int weight, @RequestParam boolean conditionUsed, @RequestParam double price, @RequestParam double discount, @RequestParam ProductCategory category, @RequestParam byte shipmentPlans) {
        for(Account account : AccountController.accountTable) {
            if(account.id == accountId && account.store != null) {
                Product product = new Product(accountId, name, weight, conditionUsed, price, discount, category, shipmentPlans);
                productTable.add(product);
                return product;
            }
        }
        return null;
    }

    public JsonTable<Product> getJsonTable() {
        return productTable;
    }

    /**
     * Gets product by store.
     *
     * @param id       the id
     * @param page     the page
     * @param pageSize the page size
     * @return the product by store
     */
    @GetMapping("/{id}/store")
    List<Product> getProductByStore(@PathVariable int id, @RequestParam int page, @RequestParam int pageSize) {
        Predicate<Product> predicates = prod -> prod.accountId == id || prod.accountId != id;
        List<Product> list = new ArrayList<>();

        for(Product product : getJsonTable()) {
            list.add(product);
        }
        return Algorithm.<Product>paginate(list, page, pageSize, predicates);
    }

    /**
     * Gets product filtered.
     *
     * @param page      the page
     * @param pageSize  the page size
     * @param accountId the account id
     * @param search    the search
     * @param minPrice  the min price
     * @param maxPrice  the max price
     * @param category  the category
     * @return the product filtered
     */
    @GetMapping("/getFiltered")
    List<Product> getProductFiltered(@RequestParam int page, @RequestParam int pageSize, @RequestParam int accountId,
                                     @RequestParam String search, @RequestParam int minPrice, @RequestParam int maxPrice,
                                     @RequestParam ProductCategory category) {
        Predicate<Product> filter = filtered ->
                filtered.accountId == accountId || filtered.accountId != accountId
                && filtered.name.toLowerCase().contains((search.toLowerCase()))
                && filtered.price >= minPrice
                && filtered.price <= maxPrice
                && filtered.category.equals(category);

        List<Product> list = new ArrayList<>();
        for(Product product : getJsonTable()) {
            list.add(product);
        }

        return Algorithm.paginate(list, page, pageSize, filter);
    }
}