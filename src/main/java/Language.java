import java.util.ArrayList;
import java.util.List;

public class Language {

    List<String> words;
    String language;

    public Language(List<String> words, String language) {
        this.words = words;
        this.language = language;
    }

    public Language() {
        words = new ArrayList<String>();
        language = new String();
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }


}

