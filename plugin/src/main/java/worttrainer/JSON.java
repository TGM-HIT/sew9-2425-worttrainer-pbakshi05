package worttrainer;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Klasse JSON ist eine Speicherart
 * @author: Pavel Bakshi
 * @version: 18.09.2024
 */

public class JSON implements SpeicherArt{
    private WortEintrag eintrag;
    private WortListe wortliste;
    private int richtig;
    private int flasch;
    private int insgesamt;


    /**
     * Konsztruktor
     * @param liste Wortliste
     * @param aktuell Worteintrag
     * @param richtig Anzahl der richtig geratenen Worte
     * @param falsch Anzahl der flaschen geratenen Worte
     * @param gesamt Anzahl der insgesamt geratenen Worte
     */
    public JSON(WortListe liste, WortEintrag aktuell, int richtig, int falsch, int gesamt) {
        this.wortliste = liste;
        this.eintrag = aktuell;
        this.richtig = richtig;
        this.flasch = falsch;
        this.insgesamt = gesamt;
    }

    /**
     * Leerer Konstruktor
     */
    public JSON(){}


    /**
     * speichert alles in ein json File
     */
    @Override
    public void speichern() {
        try (FileWriter writer = new FileWriter("worttrainer.json")) {
            writer.write(toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Ladet Daten von einem schon verhandenen Json File
     * @return gibt die Daten in einem String zurück
     */
    @Override
    public String laden() {
        String content ="";
        try (FileReader reader = new FileReader("worttrainer.json")) {
            content = new String(Files.readAllBytes(Paths.get("worttrainer.json")));
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    /**
     * Wandelt die Daten in ein String um
     * @return gibt ein Daten in einem String zurück
     */
    @Override
    public String toString() {
        return  "{\n" +
                "  \"Wort\": " + "\"" + eintrag.getName() + "\",\n" +
                "  \"URL\": " + "\"" + eintrag.getUrl() + "\",\n" +
                "  \"Wortliste\": " + "\"" + wortliste + "\",\n" +
                "  \"Richtig\": " + "\"" + richtig + "\",\n" +
                "  \"Falsch\": " + "\"" + flasch + "\",\n" +
                "  \"Insgesamt\": " + "\"" + insgesamt + "\"\n" +
                "}";
    }
}
