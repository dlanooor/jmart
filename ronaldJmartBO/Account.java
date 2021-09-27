package ronaldJmartBO;


/**
 * Account
 *
 * @author Ronald Grant
 * @version 27 Sept 2021
 */
public class Account extends Recognizable implements FileParser
{
    public String name;
    public String email;
    public String password;
    
    Account(int id, String name, String email, String password) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public String toString() {
        return  "name: " + name +
                "\nemail: " + email +
                "\npassword: " + password;
    }
    
    @Override
    public boolean read(String content) {
        return false;
    }
    
    @Override
    public Object write() {
        return null;
    }
}
