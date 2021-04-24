package components.utility;

import components.GameCore;

import java.util.logging.Logger;

public class PalindromeTester {

    private final static Logger LOGGER = Logger.getLogger(PalindromeTester.class.getName());

    public static boolean isPalindrome(String string){
        String normalizedString = getNormalizedString(string);
        String reversedNormalized = new StringBuilder(normalizedString).reverse().toString();
        LOGGER.info(String.format("comparison of words {%s} and {%s} ", normalizedString, reversedNormalized));
        LOGGER.info(String.format("output {%b}", normalizedString.equals(reversedNormalized)));
        return normalizedString.equals(reversedNormalized);
    }
    public static String getNormalizedString(String string){
        return string.replaceAll("[^\\da-zA-Zа-яёА-ЯЁ]", "").toLowerCase();
    }
}
