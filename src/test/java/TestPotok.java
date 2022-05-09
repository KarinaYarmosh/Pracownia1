
//import com.sun.xml.internal.ws.policy.AssertionSet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;
public class TestPotok {
    @Test
    public void Potok() throws IOException {
        //создаем тестовые данные
        List<String> english = Arrays.asList("dog", "cat", "parking");
        List<String> polish = Arrays.asList("czesc", "parking");
        List<String> russian = Arrays.asList("лягушка", "творог");

        Language language1 = new Language(english, "english");
        Language language2 = new Language(polish, "polish");
        Language language3 = new Language(russian, "russian");

        HashMap<String, Language> test = new HashMap<String, Language>();
        test.put(language1.getLanguage(), language1);
        test.put(language2.getLanguage(), language2);
        test.put(language3.getLanguage(), language3);

        //создаем список expected и заполняем его данными нашего метода


        //создаем список actual в него помещаем данные для сравнения
        //то что мы предпологиаем метод должен вернуть
        List<List<String>> expected = new ArrayList<List<String>>();
        expected.add(Arrays.asList("english", "polish"));
        expected.add(Arrays.asList("polish"));
        expected.add(Arrays.asList("russian"));

        //запускаем тест, в случае если список expected и actual не будут равны
        //тест будет провален, о результатах теста читаем в консоли
        List<List<String>> actual = new ArrayList<List<String>>();
        actual.add(Potok.get_lang_by_word("parking", test));
        actual.add(Potok.get_lang_by_word("czesc", test));
        actual.add(Potok.get_lang_by_word("лягушка", test));


        Assert.assertEquals(expected, actual);

    }
}