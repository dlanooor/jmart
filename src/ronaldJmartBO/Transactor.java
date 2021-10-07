package ronaldJmartBO;


/**
 * Transactor
 *
 * @author Ronald Grant
 * @version 27 Sept 2021
 */
public interface Transactor
{
    public boolean validate();
    public Invoice perform();
}
