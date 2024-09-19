import java.util.LinkedList;

/**
 * Klasse WortListe
 * @author: Pavel Bakshi
 * @version: 18.09.2024
 */

public class WortListe implements Pruefen{
    private LinkedList<WortEintrag> wort = new LinkedList<WortEintrag>();

    /**
     * Konstruktor
     */
    public WortListe() {}

    /**
     * Fügt einen Worteintrag in die Liste hinzu
     * @param w Worteintrag
     */
    public void add(WortEintrag w) {
        wort.add(w);

    }

    /**
     * Löscht aus der Liste einen Worteintrag
     * @param w Worteintrag
     */
    public void remove(WortEintrag w) {
        wort.remove(w);
    }

    public LinkedList<WortEintrag> getWort() {
        return wort;
    }

    @Override
    public boolean check() {
        return false;
    }
}
