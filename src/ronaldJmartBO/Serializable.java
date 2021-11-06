package ronaldJmartBO;

import java.util.*;

/**
 * Recognizable
 *
 * @author Ronald Grant
 * @version 25 Sept 2021
 */
public class Serializable implements Comparable<Serializable>
{
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<>();

    protected Serializable()
    {
        Integer counter = mapCounter.get(getClass());
        counter = counter == null ? 0 : counter + 1;
        mapCounter.put(getClass(), counter);
        this.id = counter;
    }

//    protected Recognizable(int id)
//    {
//        this.id = id;
//    }

    public boolean equals(Object other)
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
        Serializable serializable = (Serializable) other;
        return other instanceof Serializable && ((Serializable) other).id == id;
    }
    
    public boolean equals(Serializable other)
    {
        return id == other.id;
    }

    public static <T extends Serializable> Integer getClosingId(Class<T> clazz) {
        return mapCounter.get(clazz);
    }

    public static <T extends Serializable> Integer setClosingId(Class<T> clazz, int id) {
        return mapCounter.put(clazz, id);
    }

    @Override
    public int compareTo(Serializable other) {
//        if(this.id == recognizable.id)
//            return 0;
//        else if(this.id > recognizable.id)
//            return 1;
//        else
//            return -1;
        return Integer.compare(this.id, other.id);
    }
}
