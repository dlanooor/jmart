package ronaldJmartBO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Store
 *
 * @author Ronald Grant
 * @version 27 Sept 2021
 */
public class Store extends Recognizable implements FileParser
{
    public String name;
    public String address;
    public String phoneNumber;
    public static final String REGEX_PHONE = "^[0-9]{9,12}\b";
    public static final String REGEX_NAME = "^[A-Z][a-z\\sa-z]{4,19}\b";
    
    public Store(int accountId, String name, String address, String phoneNumber)
    {
        super(accountId);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    public Store(Account account, String name, String address, String phoneNumber)
    {
        super(account.id);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    public String toString() {
        return  "name: " + name +
                "\naddress: " + address +
                "\nphoneNumber: " + phoneNumber;
    }
    
    public boolean validate() {
        Pattern patternPhone = Pattern.compile(REGEX_PHONE);
        Matcher matcherPhone = patternPhone.matcher(phoneNumber);
        
        Pattern patternName = Pattern.compile(REGEX_NAME);
        Matcher matcherName = patternName.matcher(name);
        
        return matcherPhone.find() && matcherName.find();
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