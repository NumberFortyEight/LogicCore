package components.repository;

import components.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UsersRepository {
    private static final List<User> userList = new ArrayList<>();

    public void addUser(String nickname){
        boolean isUserExist = userList.stream().anyMatch(user -> user.getNickname().equals(nickname));
        if (isUserExist) {
            userList.add(new User(nickname, 0));
        }
    }
    public List<User> getTopFive() {
        return userList.stream()
                .sorted().limit(5)
                .collect(Collectors.toList());
    }

    public User getUserByNickname(String nickname) {
        Optional<User> optionalUser = userList.stream().filter(user -> user.getNickname().equals(nickname)).findFirst();
        optionalUser 
        return ;
    }
}
