package ronaldJmartBO;


/**
 * Pembuatan Shipment Duration.
 *
 * @author Ronald Grant
 * @version 22 Sept 2021
 */
public class ShipmentDuration
{
    public static final ShipmentDuration INSTANT = new ShipmentDuration(1 << 0);
    public static final ShipmentDuration SAME_DAY = new ShipmentDuration(1 << 1);
    public static final ShipmentDuration NEXT_DAY = new ShipmentDuration(1 << 2);
    public static final ShipmentDuration REGULER = new ShipmentDuration(1 << 3);
    public static final ShipmentDuration KARGO = new ShipmentDuration(1 << 4);
    private int bit;
    
    public static void main(String[] args){
        System.out.println(ShipmentDuration.INSTANT);
    }
    
    public ShipmentDuration(int bit) {
        this.bit = bit;
    }
    
    public ShipmentDuration(ShipmentDuration... args) {
        for(ShipmentDuration s: args) {
            this.bit = this.bit | s.bit;
        }
    }
    
    public boolean isDuration(ShipmentDuration reference) {
        if((this.bit & reference.bit) != 0)
            return true;
        else
            return false;
    }
}
