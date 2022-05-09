import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class JSON {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static File plik = new File("mojplik.json");

    public static void Serialization(HashMap<String, Language> lang) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        objectMapper.writeValue(plik, lang);

    }

    public static HashMap<String, Language> deSerialization() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, Language> lang = new HashMap<String, Language>();
        if(plik.exists()) {
            lang = objectMapper.readValue(plik, new TypeReference<HashMap<String, Language>>(){});
        }
        else{
            Serialization(lang);
        }
        return lang;
    }

    public static void nowy() throws IOException {
        Language language = new Language();
        List<String> words = new ArrayList<String>();
        HashMap<String, Language> lang = deSerialization();
        String input = br.readLine();
        if(lang.containsKey(input)){
            System.out.println("Jezyk juz istnieje");
            return;
        }
        language.setLanguage(input);

        System.out.println("Prosze wpisac slowa, zeby przerwac wpisywanie wpisz 'dodac': ");
        while(true) {
            input = br.readLine();
            switch (input){
                case "dodac":
                    lang.put(language.getLanguage(), language);
                    Serialization(lang);
                    return;
                default:
                    words = Arrays.asList(input.split(" "));
                    for(int i=0;i<words.size();i++){
                        language.getWords().add(words.get(i));
//                        Cont.raport();
                    }
//                    System.out.println("Generacja raportu");
//                    Cont.raport();
            }

        }

    }

    public static void z_plika() throws IOException {
        System.out.println("wprowadz scezke do pliku");
        String sciezka_plik = br.readLine();
        File plik = new File(sciezka_plik);
        ObjectMapper objectMapper = new ObjectMapper();
        Language language = objectMapper.readValue(plik, new TypeReference<Language>(){});
        HashMap<String, Language> lang = deSerialization();
        lang.put(language.getLanguage(), language);
        Serialization(lang);
        System.out.println("dodano jezyk: " + language.getLanguage());

    }
}
