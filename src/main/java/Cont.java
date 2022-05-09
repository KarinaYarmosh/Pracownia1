import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

public class Cont {

    public static void scanner() throws IOException {

        String input = new String();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Wybierz jeden z punktow: ");
        System.out.println("1: Dodaj jezyk");
        System.out.println("2: Szukaj slowo");

        input = br.readLine();

        switch (input){
            case "1":
                wybor();
                break;
            case"2":
                wybor_pdf();
                break;
        }
        Cont.scanner();
    }

    public static void wybor() throws IOException {

        String input = new String();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Wybierz: ");
        System.out.println("1: Dodaj nowy jezyk");
        System.out.println("2: Dodaj nowy jezyk i slowa z pliku");

        input = br.readLine();

        switch (input){
            case "1":
                dodaj_nowy();
                break;
            case"2":
                wczytaj_z_plika();
                break;
        }
        Cont.scanner();
    }

    public static void dodaj_nowy() throws IOException {
        System.out.println("Dodajemy nowy jezyk");
        JSON.nowy();
        }

    public static void wczytaj_z_plika() throws IOException {
        System.out.println("Szukamy plik");
        JSON.z_plika();
        }

    public static void wybor_pdf() throws IOException {
        System.out.println("Wprowadz slowo lub 'generate' to generate raport");
        HashMap<String, List<String>> raport = new HashMap<String, List<String>>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String input = br.readLine();
            switch (input){
                case "generate":
                    PDF.generate_raport(raport);
                    return;
                default:
                    raport.put(input, Potok.get_lang_by_word(input, null)); //nie ma
            }
        }

    }

}
