package ronaldJmartBO;


/**
 * Shipment
 *
 * @author Ronald Grant
 * @version 27 Sept 2021
 */
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
        public static final SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("EEE MMMM dd yyyy");
        public byte bit;
        
        // public static void main(String[] args){
            // System.out.println(Duration.INSTANT);
        // }
        
        private Duration(byte bit) {
            this.bit = bit;
        }
        
        public String getEstimatedArrival(Date reference) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(reference);
            
            if(this.bit == Duration.INSTANT.bit)
                cal.add(Calendar.DATE, 0);
            else if(this.bit == Duration.SAME_DAY.bit)
                cal.add(Calendar.DATE, 0);
            else if(this.bit == Duration.NEXT_DAY.bit)
                cal.add(Calendar.DATE, 1);
            else if(this.bit == Duration.REGULER.bit)
                cal.add(Calendar.DATE, 2);
            else if(this.bit == Duration.KARGO.bit)
                cal.add(Calendar.DATE, 5);
                
            String curr_date = ESTIMATION_FORMAT.format(cal);
            return curr_date;
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
