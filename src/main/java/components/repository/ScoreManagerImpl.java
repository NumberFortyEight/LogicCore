package components.repository;

import components.entity.User;

import java.util.*;

public class ScoreManagerImpl implements ScoreManager {

    private static final Hashtable<String, List<User>> palindromeAndUsers = new Hashtable<>();

    @Override
    public void scorePoints(User user, String normalizedString) {
        Optional<User> optionalUser = userList.stream()
                .filter(user -> user.getNickname().equals(nickname)).findFirst();
        User user = optionalUser.get();

        if (palindromeAndUsers.containsKey(normalizedString)) {
            List<User> users = palindromeAndUsers.get(normalizedString);

            boolean isUserUsePalindrome = users
                    .stream().anyMatch(user1 -> user1.getNickname().equals(nickname));

            if (!isUserUsePalindrome) {
                user.sumScore(normalizedString.length());
                users.add(user);
            }
        } else {
            user.sumScore(normalizedString.length());
            palindromeAndUsers.put(normalizedString, List.of(user));
        }
    }
}
