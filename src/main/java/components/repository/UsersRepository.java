package components.repository;

import components.entity.User;

import java.util.List;
import java.util.Optional;

public interface UsersRepository {
     void addUser(User user);
     List<User> getUserList();
     Optional<User> getUserByNickname(String nickname);
}
