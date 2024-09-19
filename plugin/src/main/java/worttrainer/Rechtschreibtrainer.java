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
     * @param speichern WortSpeichern
     */
    public Rechtschreibtrainer(WortListe liste, WortSpeichern speichern) {
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

    @Override
    public boolean check() {
        return false;
    }

    public void trainieren(String nameInput) {
        do {
            int random = (int)(Math.random() * liste.getWort().size() -1);
            String name = liste.getWort().get(random).getName();
            String url = liste.getWort().get(random).getUrl();

            if (nameInput.equals(name)) {
                this.richtig++;
                liste.getWort().remove(liste.getWort().get(random));

            }
            this.insgesamt++;

        }while(liste.getWort().size() >= 1);
    }
}
