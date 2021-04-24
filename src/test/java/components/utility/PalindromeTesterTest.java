package components.utility;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class PalindromeTesterTest {

    @Test
    public void isPalindrome() {
        List<String> strings = List.of("n4et56ty", "Bass5ab", "brack65er", "bust5er", "hattah");
        List<Boolean> resultList = strings.stream()
                .map(PalindromeTester::isPalindrome)
                .collect(Collectors.toList());
        List<Boolean> actualList = List.of(false, false, false, false, true);
        Assert.assertEquals(resultList, actualList);
    }

    @Test
    public void getNormalizedString() {
        List<String> strings = List.of("ToDaY A SeCoNd DaY", "Numbers, symbols", "Фильтр");
        List<String> resultList = strings.stream()
                .map(PalindromeTester::getNormalizedString)
                .collect(Collectors.toList());
        List<String> actualList = List.of("todayasecondday", "numberssymbols", "фильтр");
        Assert.assertEquals(resultList, actualList);
    }
}