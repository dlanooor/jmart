package com.ronaldJmartBO;

import com.ronaldJmartBO.dbjson.JsonDBEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Backend jMart Application
 *
 * @author Ronald Grant
 * @version 2.7
 * @since 11 September 2021
 */
@SpringBootApplication
public class Jmart
{
    /**
     * The constant DELIVERED_LIMIT_MS.
     */
    public static long DELIVERED_LIMIT_MS = 10L;
    /**
     * The constant ON_DELIVERY_LIMIT_MS.
     */
    public static long ON_DELIVERY_LIMIT_MS = 20L;
    /**
     * The constant ON_PROGRESS_LIMIT_MS.
     */
    public static long ON_PROGRESS_LIMIT_MS = 30L;
    /**
     * The constant WAITING_CONF_LIMIT_MS.
     */
    public static long WAITING_CONF_LIMIT_MS = 40L;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        JsonDBEngine.Run(Jmart.class);
        SpringApplication.run(Jmart.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));
    }
}