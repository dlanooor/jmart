package com.ronaldJmartBO;

/**
 * Pembuatan Kupon
 *
 * @author Ronald Grant
 * @version 18 Sept 2021
 */
// sebelum FileParser dihapus
// public class Coupon extends Recognizable implements FileParser

public class Coupon extends Serializable
{
    public final String name;
    public final int code;
    public final double cut;
    public final Type type;
    public final double minimum;
    private boolean used;

//    sebelum super dihapus (pt modul 5)
//    public Coupon(int id, String name, int code, Type type, double cut, double minimum) {
//        super(id);
//        this.name = name;
//        this.code = code;
//        this.type = type;
//        this.cut = cut;
//        this.minimum = minimum;
//        used = false;
//    }

    public Coupon(String name, int code, Type type, double cut, double minimum) {
        this.name = name;
        this.code = code;
        this.type = type;
        this.cut = cut;
        this.minimum = minimum;
        used = false;
    }

    public boolean isUsed() {
        return used;
    }
    
    public boolean canApply(double price, double discount) {
        if(Treasury.getAdjustedPrice(price, discount) >= minimum && used == false)
            return true;
        else
            return false;
    }
    
    public double apply(double price, double discount) {
        used = true;
        if(type == Type.DISCOUNT)
            return Treasury.getAdjustedPrice(price, discount) - (Treasury.getAdjustedPrice(price, discount) * cut / 100);
        else
            return Treasury.getAdjustedPrice(price, discount) - cut;
    }

    public enum Type {
        DISCOUNT,
        REBATE;
    }

//    @Override
//    public boolean read(String content) {
//        return false;
//    }
//
//    @Override
//    public Object write() {
//        return null;
//    }
}