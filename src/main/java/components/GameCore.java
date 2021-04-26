package components;

import  components.entity.InputValue;
import components.entity.User;
import components.repository.UsersRepository;
import components.repository.UsersRepositoryImpl;
import components.services.ResultService;
import components.services.ResultServiceImpl;
import components.services.ScoreManager;
import components.services.ScoreManagerImpl;
import components.utility.PalindromeTester;
import components.utility.ValuesFilter;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class GameCore {

    private final static Logger LOGGER = Logger.getLogger(GameCore.class.getName());

    private static final UsersRepository usersRepository = new UsersRepositoryImpl();
    private static final ScoreManager scoreManager = new ScoreManagerImpl();
    private static final ResultService resultService = new ResultServiceImpl(usersRepository);

    public ResultService getResultService() {
        return resultService;
    }
    public void setInputValues(InputValue... inputValues) {
        processIncomingValues(Arrays.stream(inputValues));
    }
    public void setInputValues(List<InputValue> inputValues) {
        processIncomingValues(inputValues.stream());
    }

    private void processIncomingValues(Stream<InputValue> valuesStream) {
        valuesStream
                .filter(inputValue -> PalindromeTester.isPalindrome(inputValue.getPalindrome()))
                .filter(ValuesFilter::isInputValuePresent)
                .forEach(inputValue -> {
                    LOGGER.info(String.format("processing input value {%s}, {%s}", inputValue.getNickname(), inputValue.getPalindrome()));

                    Optional<User> userByNickname = usersRepository.getUserByNickname(inputValue.getNickname());
                    String normalizedPalindrome = PalindromeTester.getNormalizedString(inputValue.getPalindrome());

                    if (userByNickname.isEmpty()) {
                        User newUser = new User(inputValue.getNickname(), 0);
                        usersRepository.addUser(newUser);
                        scoreManager.scorePoints(newUser, normalizedPalindrome);
                    } else {
                        scoreManager.scorePoints(userByNickname.get(), normalizedPalindrome);
                    }

                });


        // FIXME: 24.04.2021
        scoreManager.getPalindromeAndUsers();
    }
}
