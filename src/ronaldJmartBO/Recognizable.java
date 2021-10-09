package ronaldJmartBO;


/**
 * Recognizable
 *
 * @author Ronald Grant
 * @version 25 Sept 2021
 */
public class Recognizable implements Comparable<Recognizable>
{
    public final int id;

    protected Recognizable(int id)
    {
        this.id = id;
    }

    public boolean equals(Object object)
    {
        // if(object instanceof Recognizable) {
            // // Recognizable recognizable = (Recognizable) object;
            // // if(Object.id == this.id)
                // // return true;
            // // else
                // // return false;
        // }
        // else
            // return false;
        Recognizable recognizable = (Recognizable) object;
        return object instanceof Recognizable && ((Recognizable) object).id == id;
    }
    
    public boolean equals(Recognizable recognizable)
    {
        return id == recognizable.id;
    }

    public static <T extends Recognizable> int getClosingId(Class<T> clazz) {
        return 0;
    }

    public static <T extends Recognizable> int setClosingId(Class<T> clazz, int id) {
        return 0;
    }

    @Override
    public int compareTo(Recognizable recognizable) {
//        if(this.id == recognizable.id)
//            return 0;
//        else if(this.id > recognizable.id)
//            return 1;
//        else
//            return -1;
        return Integer.compare(this.id, recognizable.id);
    }
}
