package ronaldJmartBO;


/**
 * Shipment
 *
 * @author Ronald Grant
 * @version 27 Sept 2021
 */
public class Shipment implements FileParser
{
    public String address;
    public int shipmentCost;
    public Duration duration;
    public String receipt;
    
    public static class Duration
    {
        public static final Duration INSTANT = new Duration((byte)(1 << 0));
        public static final Duration SAME_DAY = new Duration((byte)(1 << 1));
        public static final Duration NEXT_DAY = new Duration((byte)(1 << 2));
        public static final Duration REGULER = new Duration((byte)(1 << 3));
        public static final Duration KARGO = new Duration((byte)(1 << 4));
        public byte bit;
        
        // public static void main(String[] args){
            // System.out.println(Duration.INSTANT);
        // }
        
        private Duration(byte bit) {
            this.bit = bit;
        }
        
        // private Duration(Duration... args) {
            // for(Duration s: args) {
                // this.bit = this.bit | s.bit;
            // }
        // }
        
        // public boolean isDuration(ShipmentDuration reference) {
            // if((this.bit & reference.bit) != 0)
                // return true;
            // else
                // return false;
        // }
    }
    
    public class MultiDuration {
        public byte bit;
        public MultiDuration(Duration... args) {
            for(Duration s: args) {
               this.bit |= s.bit;
            }
        }
        
        public boolean isDuration(Duration reference) {
            if((this.bit & reference.bit) != 0)
                return true;
            else
                return false;
        }
    }
    
    public Shipment(String address, int shipmentCost, Duration duration, String receipt)
    {
        this.address = address;
        this.shipmentCost = shipmentCost;
        this.duration = duration;
        this.receipt = receipt;
    }
    
    @Override
    public boolean read(String content) {
        return false;
    }
}
