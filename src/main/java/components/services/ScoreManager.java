package components.services;

import components.entity.User;

import java.util.Hashtable;
import java.util.List;
import java.util.Optional;

public interface ScoreManager {
    void scorePoints(Optional<User> user, String normalizedString);

    // FIXME: 24.04.2021
    Hashtable<String, List<User>> getPalindromeAndUsers();
}
