package worttrainer;

/**
 * Klasse WortEintrag
 * @author: Pavel Bakshi
 * @version: 18.09.2024
 */

public class WortEintrag implements Pruefen {
    private String name;
    private String url;

    /**
     * Konstruktor
     * @param name Name des Bildes
     * @param url Url des Bildes
     */
    public WortEintrag(String name, String url) {
        this.name = name;
        this.url = url;
    }

    /**
     * Getter Methode
     * @return gibt den Namen zurück
     */
    public String getName() {
        return name;
    }

    /**
     * Getter Methode
     * @return gibt die Url zurück
     */
    public String getUrl() {
        return url;
    }

    /**
     * Setter Methode
     * @param url Url
     * @return überprüft ob die URL gültig ist
     */
    public boolean setUrl(String url) {
        if(url != null) {
            this.url = url;
            return true;
        }
        return false;
    }

    /**
     * Setter Methode
     * @param name Name
     * @return überprüft ob der Name gültog ist
     */
    public boolean setName(String name) {
        if(name != null) {
            this.name = name;
            return true;
        }
        return false;
    }

    @Override
    public boolean check() {
        return false;
    }
}
