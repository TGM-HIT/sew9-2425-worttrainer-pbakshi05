package worttrainer;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONObject;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Klasse JSON
 * @author: Pavel Bakshi
 * @version: 18.09.2024
 */

public class JSON implements SpeicherArt{
    private WortEintrag eintrag;
    private WortListe wortliste;
    private int richtig;
    private int flasch;
    private int insgesamt;

    public JSON(WortListe liste, WortEintrag aktuell, int richtig, int falsch, int gesamt) {
        this.wortliste = liste;
        this.eintrag = aktuell;
        this.richtig = richtig;
        this.flasch = falsch;
        this.insgesamt = gesamt;
    }

    public JSON(){}

    @Override
    public void speichern() {
        try (FileWriter writer = new FileWriter("worttrainer.json")) {
            writer.write(toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

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
