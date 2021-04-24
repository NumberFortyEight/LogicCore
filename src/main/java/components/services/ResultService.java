package components.services;

import components.entity.User;

import java.util.Hashtable;
import java.util.List;
import java.util.Optional;

public interface ResultService {
    List<User> getTopFive();
    Optional<User> getBestResult();
}
