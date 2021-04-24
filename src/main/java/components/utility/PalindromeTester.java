package components.utility;

public class PalindromeTester {
    public static boolean isPalindrome(String optionalPalindrome){
        String normalizedString = getNormalizedString(optionalPalindrome);
        String reversedNormalized = new StringBuilder(normalizedString).reverse().toString();
        return normalizedString.equals(reversedNormalized);
    }
    public static String getNormalizedString(String string){
        return string.replaceAll("[^\\da-zA-Zа-яёА-ЯЁ]", "").toLowerCase();
    }
}
