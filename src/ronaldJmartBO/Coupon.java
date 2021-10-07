package ronaldJmartBO;


/**
 * Pembuatan Kupon
 *
 * @author Ronald Grant
 * @version 18 Sept 2021
 */
public class Coupon extends Recognizable implements FileParser
{
    public final String name;
    public final int code;
    public final double cut;
    public final Type type;
    public final double minimum;
    private boolean used;
    
    public Coupon(int id, String name, int code, Type type, double cut, double minimum) {
        super(id);
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
    
    @Override
    public boolean read(String content) {
        return false;
    }
    
    @Override
    public Object write() {
        return null;
    }
}