package components.services;

import components.entity.User;

import java.util.*;

public class ScoreManagerImpl implements ScoreManager {

    //String Normalized palindrome and a list of users who used it
    private static final Hashtable<String, List<User>> palindromeAndUsers = new Hashtable<>();

    @Override
    public void scorePoints(User user, String normalizedString) {
        if (palindromeAndUsers.containsKey(normalizedString)) {
            CheckAndUpdateUsingList(user, normalizedString);
        } else {
            user.sumScore(normalizedString.length());
            palindromeAndUsers.put(normalizedString, new ArrayList<>(List.of(user)));
        }
    }

    public void CheckAndUpdateUsingList(User user, String normalizedString) {
        List<User> users = palindromeAndUsers.get(normalizedString);

        boolean isUserUsePalindrome = users
                .stream().anyMatch(user1 -> user1.getNickname().equals(user.getNickname()));

        if (!isUserUsePalindrome) {
            user.sumScore(normalizedString.length());
            users.add(user);
        }
    }
}
