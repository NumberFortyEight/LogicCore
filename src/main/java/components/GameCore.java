package components;

import components.entity.InputValue;
import components.repository.UsersRepository;
import components.repository.UsersRepositoryImpl;
import components.services.ResultService;
import components.services.ResultServiceImpl;
import components.services.ScoreManager;
import components.services.ScoreManagerImpl;
import components.utility.PalindromeTester;

import java.util.Arrays;
import java.util.List;
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

    private void processIncomingValues(Stream<InputValue> stream) {
        stream.filter(inputValue -> PalindromeTester.isPalindrome(inputValue.getPalindrome()))
                .forEach(inputValue -> {
                    LOGGER.info(String.format("processing input value {%s}, {%s}", inputValue.getNickname(), inputValue.getPalindrome()));
                    usersRepository.addUser(inputValue.getNickname());
                    scoreManager.scorePoints(usersRepository.getUserByNickname(inputValue.getNickname()),
                            PalindromeTester.getNormalizedString(inputValue.getPalindrome()));
                });


        // FIXME: 24.04.2021
        scoreManager.getPalindromeAndUsers();
    }
}
