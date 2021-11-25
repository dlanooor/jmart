package com.ronaldJmartBO.controller;
import com.ronaldJmartBO.Algorithm;
import com.ronaldJmartBO.dbjson.JsonTable;
import com.ronaldJmartBO.dbjson.Serializable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface BasicGetController<T extends Serializable> {
    @GetMapping("/id")
    default T getById(@PathVariable int id){
        return Algorithm.<T>find(getJsonTable(), (e) -> e.id == id);
    }

    @GetMapping("/page")
    default List<T> getPage (@PathVariable int page, @PathVariable int pageSize){
        return Algorithm.<T>paginate(getJsonTable(), page, pageSize, e -> true);
    }

    public abstract JsonTable<T> getJsonTable();
//    @GetMapping("/id")
//    public default T getById(int id) {
//        return null;
//    }
//
//    public abstract JsonTable<T> getJsonTable();
//
//    @GetMapping("/page")
//    public default List<T> getPage(int page, int pageSize) {
//        return null;
//    }
}