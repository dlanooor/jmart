package ronaldJmartBO;


/**
 * Recognizable
 *
 * @author Ronald Grant
 * @version 25 Sept 2021
 */
public abstract class Recognizable
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
}
