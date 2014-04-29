//File name: CreditCardValidation.java
//
//Authors: oakes Isaac and Roman Galysh
//


package creditCardValidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreditCardValidation {
    
    private static Pattern visa = Pattern.compile("^4[0-9]{12}(?:[0-9]{3})?$");
    private static Pattern masterCard = Pattern.compile("^5[1-5][0-9]{14}$");
    private static Matcher visaMatcher;
    private static Matcher masterCardMatcher;
    
    public static boolean validate(String txt) {
        visaMatcher = visa.matcher(txt);
        masterCardMatcher = masterCard.matcher(txt);
        
        if (visaMatcher.matches() || masterCardMatcher.matches())
            return true;
        
        return false;
        
    }
}