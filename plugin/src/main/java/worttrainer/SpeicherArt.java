package worttrainer;

/**
 * Interface SpeicherArt
 * @author Pavel Bakshi
 * @version 18.09.2024S
 */
public interface SpeicherArt {
    /**
     * speichert die Daten
     */
    public void speichern();

    /**
     * ladet die Daten als String
     * @return
     */
    public String laden();
}
