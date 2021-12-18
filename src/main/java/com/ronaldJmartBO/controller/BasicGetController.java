package com.ronaldJmartBO.controller;

import com.ronaldJmartBO.Algorithm;
import com.ronaldJmartBO.Predicate;
import com.ronaldJmartBO.dbjson.JsonTable;
import com.ronaldJmartBO.dbjson.Serializable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Represents Basic Controller to Connect with Android
 *
 * @param <T> the type parameter
 * @author Ronald Grant
 * @version 1.0
 * @since 3 December 2021
 */
@RestController
public interface BasicGetController<T extends Serializable> {
    /**
     * Gets page from pagination in Algorithm Response.
     *
     * @param page     the page
     * @param pageSize the page size
     * @return the page
     */
    @GetMapping("/page")
    public default List<T> getPage(@RequestParam int page, @RequestParam int pageSize) {
        Predicate<T> pred = element -> true;
        List<T> list = Algorithm.collect(getJsonTable(), pred);

        return Algorithm.<T>paginate(list, page, pageSize, pred);
    }

    /**
     * Get by id Response.
     *
     * @param id the id
     * @return the t
     */
    @GetMapping("/{id}")
    public default T getById(@PathVariable int id){ 
        Predicate<T> pred = element -> element.id == id;
        return Algorithm.find(getJsonTable().iterator(), pred);
    }

    /**
     * Gets json table.
     *
     * @return the json table
     */
    public abstract JsonTable<T> getJsonTable();
}