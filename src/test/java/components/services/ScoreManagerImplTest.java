package components.services;

import components.GameCore;
import components.entity.InputValue;
import components.entity.User;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScoreManagerImplTest {

    @Test
    public void scorePoints() {
        ScoreManager scoreManager = new ScoreManagerImpl();
        User name = new User("name", 0);
        scoreManager.scorePoints(name, "dddd");
        Integer score = name.getScore();
        Integer actualScore = 4;
        assertEquals(score,actualScore);
    }

    @Test
    public void scorePointsNotSum() {
        ScoreManager scoreManager = new ScoreManagerImpl();
        User user = new User("name", 0);

        scoreManager.scorePoints(user, "nutripog");
        scoreManager.scorePoints(user, "nutripog");
        scoreManager.scorePoints(user, "nutripog");

        Integer score = user.getScore();
        Integer actualScore = 8;
        Assert.assertEquals(score, actualScore);
    }
}