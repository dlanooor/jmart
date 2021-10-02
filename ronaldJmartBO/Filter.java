package ronaldJmartBO;

import java.util.ArrayList;

/**
 * class Filter
 *
 * @author Ronald Grant
 * @version 2 Oct 2021
 */
public class Filter
{
    public static ArrayList<PriceTag> filterPriceTag(PriceTag[] list, double value, boolean less) {
        ArrayList<PriceTag> arrList = new ArrayList<PriceTag>();
        if(less) {
            for(PriceTag i : list) {
                if(i.getAdjustedPrice() < value)
                    arrList.add(i);
            }
        }
        
        else {
            for(PriceTag i : list) {
                if(i.getAdjustedPrice() >= value)
                    arrList.add(i);
            }
        }
        
        return arrList;
    }
    
    public static void filterProductRating(ArrayList<ProductRating> list, double value, boolean less) {
        if(less) {
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i).getAverage() < value)
                    list.remove(i);
            }
        }
        
        else {
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i).getAverage() >= value)
                    list.remove(i);
            }
        }
    }
}
