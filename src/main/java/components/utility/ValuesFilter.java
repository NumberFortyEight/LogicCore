package components.utility;

import components.entity.InputValue;

public class ValuesFilter {
    public static boolean isPresent(String str){
        return str != null && !str.equals("");
    }
    public static boolean isFew(String str){
        return str.length() > 1;
    }
    public static boolean isInputValuePresent(InputValue inputValue){
        if (inputValue == null) {
            return false;
        }
        return isPresent(inputValue.getNickname()) && isPresent(inputValue.getPalindrome()) && isFew(inputValue.getPalindrome());
    }
}
