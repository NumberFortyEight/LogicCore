package components;

import components.entity.InputValue;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameCoreTest {

    @Test
    public void isPalindromesNotSum() {
        GameCore gameCore = new GameCore();
        gameCore.setInputValues(new InputValue("Кет", "Довод"));
        gameCore.setInputValues(new InputValue("Кет", "Довод"));
        gameCore.setInputValues(new InputValue("Кет", "Довод"));
        Integer score = gameCore.getResultService().getBestResult().get().getScore();
        Integer actualScore = 5;
        Assert.assertEquals(score, actualScore);
    }

}