package worttrainer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Klasse WortListe
 * @author: Pavel Bakshi
 * @version: 18.09.2024
 */

public class WortListe implements Pruefen{
    private ArrayList<WortEintrag> wort = new ArrayList<WortEintrag>();

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

    /**
     * Getter Methode
     * @return eine liste aus worteinträgen
     */
    public ArrayList<WortEintrag> getWort() {
        return wort;
    }

    /**
     * Überprüft ob alle Werte sinnvoll sind
     * @return
     */
    @Override
    public boolean check() {
        return false;
    }
}
