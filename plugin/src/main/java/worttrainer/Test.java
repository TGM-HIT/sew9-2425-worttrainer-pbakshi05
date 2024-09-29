package worttrainer;

import java.io.IOException;
import java.lang.Math;

/**
 * Main
 * @author: Pavel Bakshi
 * @version: 18.09.2024
 */

public class Test {
    public static void main(String[] args) throws IOException {

        WortEintrag hund = new WortEintrag("Hund","https://www.zooroyal.at/magazin/wp-content/uploads/2019/10/hund-im-herbst-760x570.jpg");
        WortEintrag katze = new WortEintrag("Katze", "https://www.zooroyal.de/magazin/wp-content/uploads/2023/09/tuxedo-katze-760x570-1.gif");
        WortEintrag elefant = new WortEintrag("Elefant", "https://netzfrauen.org/wp-content/uploads/2020/06/elephant-firebombed-760x570.jpg");
        WortEintrag schlange = new WortEintrag("Schlange", "https://www.zooroyal.de/magazin/wp-content/uploads/2024/01/boa-constrictor-760x570-1.gif");
        WortEintrag biene = new WortEintrag("Biene", "https://www.zooroyal.at/magazin/wp-content/uploads/2019/10/nutzen-honigbienen-760x570.jpg");

        WortListe liste = new WortListe();
        liste.add(hund);
        liste.add(katze);
        liste.add(elefant);
        liste.add(schlange);
        liste.add(biene);

        int random = (int) (Math.random() * liste.getWort().size());
        WortEintrag eintrag = liste.getWort().get(random);
        new View(liste, biene);

    }
}
