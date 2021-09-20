package ronaldJmartBO;


/**
 * Write a description of class ShipmentDuration here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ShipmentDuration
{
    public static final ShipmentDuration INSTANT = new ShipmentDuration(0b00000001);
    public static final ShipmentDuration SAME_DAY = new ShipmentDuration(0b00000010);
    public static final ShipmentDuration NEXT_DAY = new ShipmentDuration(0b00000100);
    public static final ShipmentDuration REGULER = new ShipmentDuration(0b00001000);
    public static final ShipmentDuration KARGO = new ShipmentDuration(0b00010000);
    private int bit;
    
    public static void main(String[] args) {
        System.out.println(ShipmentDuration.INSTANT);
    }
    
    public ShipmentDuration(int bit) {
        this.bit = bit;
    }
    
    public ShipmentDuration(ShipmentDuration... args) {
        for(ShipmentDuration s:args)
        {
            if(s == ShipmentDuration.INSTANT)
                bit += 1 << 0;
            else if(s == ShipmentDuration.SAME_DAY)
                bit += 1 << 1;
            else if(s == ShipmentDuration.NEXT_DAY)
                bit += 1 << 2;
            else if(s == ShipmentDuration.REGULER)
                bit += 1 << 3;
            else
                bit += 1 << 4;
        }
    }
    
    public boolean isDuration(ShipmentDuration reference) {
        return false;
    }
}
