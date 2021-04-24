package components;

import components.entity.InputValue;
import components.entity.User;
import components.repository.ScoreManager;
import components.repository.ScoreManagerImpl;
import components.repository.UsersRepository;
import components.utility.PalindromeTester;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class GameCore {

    private static final UsersRepository usersRepository = new UsersRepository();
    private static final ScoreManager scoreManager = new ScoreManagerImpl();

    public void setInputValues(InputValue... inputValues){
        processIncomingValues(Arrays.stream(inputValues));
    }

    public void setInputValues(List<InputValue> inputValues){
        processIncomingValues(inputValues.stream());
    }

    private void processIncomingValues(Stream<InputValue> stream){
        stream.filter(inputValue -> PalindromeTester.isPalindrome(inputValue.getPalindrome()))
                .forEach(inputValue -> {
                    usersRepository.addUser(inputValue.getNickname());
                    scoreManager.scorePoints(usersRepository.,
                            PalindromeTester.getNormalizedString(inputValue.getPalindrome()));
                });
    }

    public List<User> getTopFive(){
        return usersRepository.getTopFive();
    }

}
