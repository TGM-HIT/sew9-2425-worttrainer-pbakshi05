package worttrainer;

/**
 * Klasse WortSpeichern
 * @author: Pavel Bakshi
 * @version: 18.09.2024
 */

public class WortSpeichern {
    private WortListe worliste;
    private SpeicherArt art;
    private WortEintrag eintrag;
    private int richtig;
    private int flasch;
    private int insgesamt;

    public WortSpeichern(SpeicherArt art, WortListe liste, WortEintrag aktuell, int richtig, int falsch, int gesamt) {
        this.art = art;
        this.worliste = liste;
        this.eintrag = aktuell;
        this.richtig = richtig;
        this.flasch = falsch;
        this.insgesamt = gesamt;
    }


    public void speichern(SpeicherArt speochern) {
        SpeicherArt j = new JSON(this.worliste, this.eintrag, this.richtig, this.flasch, this.insgesamt);
        SpeicherArt x = new XML();

        j.speichern();


    }
}
