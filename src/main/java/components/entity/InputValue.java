package components.entity;

public class InputValue {
    private String nickname;
    private String palindrome;

    public InputValue(String nickname, String palindrome) {
        this.nickname = nickname;
        this.palindrome = palindrome;
    }

    public InputValue() {
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPalindrome() {
        return palindrome;
    }

    public void setPalindrome(String palindrome) {
        this.palindrome = palindrome;
    }
}
