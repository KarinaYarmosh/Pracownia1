import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class PDF {

    public static void generate_raport(HashMap<String, List<String>> raport) throws IOException {

        try (PDDocument doc = new PDDocument()) {

            PDPage myPage = new PDPage();
            doc.addPage(myPage);

            try (PDPageContentStream cont = new PDPageContentStream(doc, myPage)) {

                cont.beginText();

                cont.setFont(PDType1Font.TIMES_ROMAN, 12);
                cont.setLeading(14.5f);
                cont.newLineAtOffset(25, 700);

                cont.showText("Podano slow: " + raport.keySet().size());

                for (String word: raport.keySet()){
                    cont.newLine();
                    cont.showText(word + " " + raport.get(word));
                }

                cont.endText();
            }

            doc.save("./pdfff.pdf");
        }
    }
}
