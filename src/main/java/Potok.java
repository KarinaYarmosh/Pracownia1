import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Potok {
    public static List<String> get_lang_by_word(String word, HashMap<String, Language> test) throws IOException {

        HashMap<String, Language> lang = null;
        if(!(test == null)){
            lang = test;
        }
        else {
            lang = JSON.deSerialization();
        }

        List<String> result = lang.entrySet().stream()
                .filter(s -> s.getValue().getWords().contains(word))
                .map(s -> s.getValue().getLanguage())
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("Nie ma takiego slowa");
        }
        else {
            System.out.println(result);
        }

        return result;
    }
}
