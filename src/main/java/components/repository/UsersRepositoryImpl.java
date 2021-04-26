package components.repository;

import components.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UsersRepositoryImpl implements UsersRepository{

    private static final List<User> userList = new ArrayList<>();

    public void addUser(User user){
        userList.add(user);
    }

    public List<User> getUserList() {
        return userList;
    }

    public Optional<User> getUserByNickname(String nickname) {
        return userList.stream().filter(user -> user.getNickname().equals(nickname)).findFirst();
    }

}
