package components.services;

import components.entity.User;
import components.repository.UsersRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ResultServiceImpl implements ResultService {

    private final UsersRepository usersRepository;

    public ResultServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<User> getTopFive() {
        return usersRepository.getUserList().stream()
                .sorted().limit(5)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> getBestResult() {
        return usersRepository.getUserList().stream()
                .sorted().findFirst();
    }
}
