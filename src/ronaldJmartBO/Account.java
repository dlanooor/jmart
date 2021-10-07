package ronaldJmartBO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public static final String REGEX_EMAIL = "^\\w+([\\.]?[&\\*~\\w+])*@\\w+([\\.-]?)*(\\.\\w{2,3})+$";
    public static final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$)(?=.*[A-Z]).{8,}$";
    
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
    
    public boolean validate() {
        Pattern patternEmail = Pattern.compile(REGEX_EMAIL);
        Matcher matcherEmail = patternEmail.matcher(email);
        
        Pattern patternPassword = Pattern.compile(REGEX_PASSWORD );
        Matcher matcherPassword = patternPassword.matcher(password);
        
        return matcherEmail.find() && matcherPassword.find();
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
