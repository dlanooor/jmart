package com.ronaldJmartBO.controller;

import com.ronaldJmartBO.*;
import com.ronaldJmartBO.dbjson.JsonAutowired;
import com.ronaldJmartBO.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController implements BasicGetController<Product>{
    @JsonAutowired(value = Product.class, filepath = "F:\\Backup\\Kuliah\\Semester 5\\Praktikum\\[OOP] Pemrograman Berorientasi Objek\\jmart\\account.json")
    public static JsonTable<Product> productTable;

    @PostMapping("/create")
    Product create(@RequestParam int accountId, @RequestParam String name, @RequestParam int weight, @RequestParam boolean conditionUsed, @RequestParam double price, @RequestParam double discount, @RequestParam ProductCategory category, @RequestParam byte shipmentPlans) {
        for(Account account : AccountController.accountTable) {
            if(account.id == accountId && account.store != null) {
                Product product = new Product(accountId, name, weight, conditionUsed, price, discount, category, shipmentPlans);
                return product;
            }
        }
        return null;
    }

    public JsonTable<Product> getJsonTable() {
        return productTable;
    }

    @GetMapping("/{id}/store")
    List<Product> getProductByStore(@PathVariable int id, @RequestParam int page, @RequestParam int pageSize) {
        Predicate<Product> pred = product -> product.accountId == id;
        return Algorithm.paginate((List<Product>) this.getJsonTable().iterator(), page, pageSize, pred);
    }

    @GetMapping("/getFiltered")
    List<Product> getProductFiltered(@RequestParam int page, @RequestParam int pageSize, @RequestParam int accountId, @RequestParam String search, @RequestParam int minPrice, @RequestParam int maxPrice, @RequestParam ProductCategory category) {
        Predicate<Product> filterAccountId = filterAcc -> filterAcc.accountId == accountId;
        Predicate<Product> containSearch = searchContain -> searchContain.name.toLowerCase().contains(search.toLowerCase());
        Predicate<Product> minFilterPrice = priceMin -> priceMin.price >= minPrice;
        Predicate<Product> maxFilterPrice = priceMax -> priceMax.price <= maxPrice;
        Predicate<Product> categoryFilter = filterCategory -> filterCategory.category.equals(category);
        Predicate<Product> pred = filtered -> Algorithm.exists(getJsonTable(), filterAccountId)
                                                && Algorithm.exists(getJsonTable(), containSearch)
                                                && Algorithm.exists(getJsonTable(), minFilterPrice)
                                                && Algorithm.exists(getJsonTable(), maxFilterPrice)
                                                && Algorithm.exists(getJsonTable(), categoryFilter);

        return Algorithm.paginate(getJsonTable(), page, pageSize, pred);
    }
}
