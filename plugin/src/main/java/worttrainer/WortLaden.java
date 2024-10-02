package worttrainer;
/**
 * Klasse Wortladen
 * @author: Pavel Bakshi
 * @version: 29.09.2024
 */

public class WortLaden {

    /**
     * Ladet die Daten von einem Json file
     * @return gibt die Daten zurück
     */
    public String laden() {
        SpeicherArt j = new JSON();
        SpeicherArt x = new XML();

        return j.laden();
    }
}
