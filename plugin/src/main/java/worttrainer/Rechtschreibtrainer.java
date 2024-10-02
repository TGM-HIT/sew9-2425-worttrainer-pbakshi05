package worttrainer;

/**
 * Klasse Rechtschreibtrainer
 * @author pavel
 * @version 2024.08.18
 */

public class Rechtschreibtrainer implements Pruefen {
    private WortListe liste;
    private int insgesamt, richtig, falsch = 0;
    private WortSpeichern speichern;

    /**
     * Konstruktor
     * @param liste Wortliste
     */
    public Rechtschreibtrainer(WortListe liste) {
        this.liste = liste;
        this.speichern = speichern;
    }

    /**
     * Getter Methode
     * @return insgesamte Anzahl der beantworteten Bilder
     */
    public int getInsgesamt() {
        return insgesamt;
    }

    /**
     * Getter Methode
     * @return Anzahl der richtig beantworteten Bilder
     */
    public int getRichtig() {
        return richtig;
    }

    /**
     * Getter Methode
     * @return Anzahl der falsch beantworteten Bilder
     */
    public int getFalsch() {
        return falsch;
    }

    /**
     * Setter Methode
     * @param liste Wortliste
     * @return überprüft ob die Liste nicht Leer ist
     */
    public boolean setListe(WortListe liste) {
        if (liste == null) {
            this.liste = liste;
            return true;
        }
        return false;
    }

    /**
     * Überprüft ob die Werte gültig sind
     * @return true, wenn alle Werte passen
     */
    @Override
    public boolean check() {

        if(setListe(liste) == true ) {
            return true;
        }
        return false;
    }

    /**
     * zählt mit wie viele richtig/falsch/insgesamt geraten wurde
     * @param nameInput Name, welche der Benutzer eingegeben hat
     * @param name Name des Bildes
     */
    public void trainieren(String nameInput, String name) {

        /**
         * Wenn die beiden Namen mit einander übereinstimmen
         */
        if (nameInput.equals(name)) {
                this.richtig++;

            } else {
                falsch++;

            }
            this.insgesamt++;
    }
}
