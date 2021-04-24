package components.repository;

import components.entity.User;

import java.util.List;

public interface ScoreManager {
    void scorePoints(User user, String normalizedString);
}
