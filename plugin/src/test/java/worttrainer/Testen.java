/**
 * @author: Pavel Bakshi
 * @version: 02.10.2024
 */

package worttrainer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Testen {

    @Test
    void TestValidWortPaar() {
        WortEintrag wortEintrag = new WortEintrag("Hund", "www.google.com");
        assertEquals("Hund", wortEintrag.getName());
        assertEquals("www.google.com", wortEintrag.getUrl());
    }

    @Test
    void TestValidURL() {
        WortEintrag eintrag = new WortEintrag("Hund", "www.google.com");
        eintrag.setUrl("www.amazon.com");
        assertEquals("www.amazon.com", eintrag.getUrl());
    }

    @Test
    void TestValidName() {
        WortEintrag eintrag = new WortEintrag("Hund", "www.google.com");
        eintrag.setName("Katze");
        assertEquals("Katze", eintrag.getName());
    }

    @Test
    void TestValidspeichern() {
        WortEintrag eintrag = new WortEintrag("Hund", "www.google.com");
        WortListe liste = new WortListe();
        liste.add(eintrag);
        SpeicherArt j = new JSON(liste,eintrag, 0,0,0);


        j.speichern();

    }


}
