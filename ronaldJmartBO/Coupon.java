package ronaldJmartBO;


/**
 * Write a description of class Coupon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Coupon
{
    public final String name;
    public final int code;
    public final double cut;
    public final Type type;
    public final double minimum;
    private boolean used;
    
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
    
    public boolean canApply(PriceTag priceTag) {
        if(priceTag.getAdjustedPrice() >= minimum && used == false)
            return true;
        else
            return false;
    }
    
    public double apply(PriceTag priceTag) {
        used = true;
        if(type == Type.DISCOUNT)
            return priceTag.getAdjustedPrice() - (priceTag.getAdjustedPrice() * cut / 100);
        else
            return priceTag.getAdjustedPrice() - cut;
    }
}
