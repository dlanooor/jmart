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
// sebelum FileParser dihapus
// public class Shipment implements FileParser
public class Shipment
{
    public String address;
    public int cost;
    public byte plan;
    public String receipt;

    public static final Plan INSTANT = new Plan((byte)(1 << 0));
    public static final Plan SAME_DAY = new Plan((byte)(1 << 1));
    public static final Plan NEXT_DAY = new Plan((byte)(1 << 2));
    public static final Plan REGULER = new Plan((byte)(1 << 3));
    public static final Plan KARGO = new Plan((byte)(1 << 4));
    public static final SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("EEE MMMM dd yyyy");

    // Constructor
    public Shipment(String address, int cost, byte plan, String receipt)
    {
        this.address = address;
        this.cost = cost;
        this.plan = plan;
        this.receipt = receipt;
    }

    public String getEstimatedArrival(Date reference) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(reference);

//        if(this.plan == Plan.INSTANT.bit)
//            cal.add(Calendar.DATE, 0);
//        else if(this.plan == Plan.SAME_DAY.bit)
//            cal.add(Calendar.DATE, 0);
//        else if(this.plan == Plan.NEXT_DAY.bit)
//            cal.add(Calendar.DATE, 1);
//        else if(this.plan == Plan.REGULER.bit)
//            cal.add(Calendar.DATE, 2);
//        else if(this.plan == Plan.KARGO.bit)
//            cal.add(Calendar.DATE, 5);

        if(this.plan == INSTANT.bit)
            cal.add(Calendar.DATE, 0);
        else if(this.plan == SAME_DAY.bit)
            cal.add(Calendar.DATE, 0);
        else if(this.plan == NEXT_DAY.bit)
            cal.add(Calendar.DATE, 1);
        else if(this.plan == REGULER.bit)
            cal.add(Calendar.DATE, 2);
        else if(this.plan == KARGO.bit)
            cal.add(Calendar.DATE, 5);

        String curr_date = ESTIMATION_FORMAT.format(cal);
        return curr_date;
    }

//    public static class Duration
//    {

        
        // public static void main(String[] args){
            // System.out.println(Duration.INSTANT);
        // }
        
//        private Duration(byte bit) {
//            this.bit = bit;
//        }
        
//        public String getEstimatedArrival(Date reference) {
//            Calendar cal = Calendar.getInstance();
//            cal.setTime(reference);
//
//            if(this.bit == Duration.INSTANT.bit)
//                cal.add(Calendar.DATE, 0);
//            else if(this.bit == Duration.SAME_DAY.bit)
//                cal.add(Calendar.DATE, 0);
//            else if(this.bit == Duration.NEXT_DAY.bit)
//                cal.add(Calendar.DATE, 1);
//            else if(this.bit == Duration.REGULER.bit)
//                cal.add(Calendar.DATE, 2);
//            else if(this.bit == Duration.KARGO.bit)
//                cal.add(Calendar.DATE, 5);
//
//            String curr_date = ESTIMATION_FORMAT.format(cal);
//            return curr_date;
//        }
        
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
//    }

    public boolean isDuration(Plan reference) {
        if((this.plan & reference.bit) != 0)
            return true;
        else
            return false;
    }

    public boolean isDuration(byte object, Plan reference) {
        if((object & reference.bit) != 0)
            return true;
        else
            return false;
    }

//    public class MultiDuration {
//        public byte bit;
//        public MultiDuration(Duration... args) {
//            for(Duration s: args) {
//               this.bit |= s.bit;
//            }
//        }
//
//        public boolean isDuration(Duration reference) {
//            if((this.bit & reference.bit) != 0)
//                return true;
//            else
//                return false;
//        }
//    }
    
//    public Shipment(String address, int shipmentCost, Duration duration, String receipt)
//    {
//        this.address = address;
//        this.shipmentCost = shipmentCost;
//        this.duration = duration;
//        this.receipt = receipt;
//    }

    public static class Plan {
        public final byte bit;

        private Plan(byte bit){
            this.bit = bit;
        }
    }
}
