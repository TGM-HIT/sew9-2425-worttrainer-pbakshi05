/**
 * Klasse View
 * @author: Pavel Bakshi
 * @version: 18.09.2024
 */

package worttrainer;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import org.json.JSONObject;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class View extends JPanel {

    private String u;
    private String sp;
    private String eingabe;
    private String ausgabe;
    private int r = 0;
    private int f = 0;
    private int ins = 0;
    private WortEintrag aktuell;
    private WortListe liste;

    public View(WortListe liste, WortEintrag eintrag) throws IOException {
        JFrame frame = new JFrame();
        this.liste = liste;

        //Layouts
        JPanel panel = new JPanel(new BorderLayout());
        JPanel box = new JPanel(new FlowLayout());
        JPanel grid = new JPanel(new GridLayout(1,5,20,40));
        JPanel action = new JPanel(new GridLayout(8,1,20,40));

        //Labels
        JLabel stats = new JLabel("Statistik:");
        JLabel richtig = new JLabel("R=" + r);
        JLabel falsch = new JLabel("F=" + f);
        JLabel insgesamt = new JLabel("Insgesamt=" + ins);
        JLabel label = new JLabel("Worttrainer");
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel("Erate das Tier auf dem Bild!");
        JTextField input = new JTextField(16);
        JButton button = new JButton("Check");
        JButton speichern = new JButton("Speichern");
        JButton laden = new JButton("Laden");




        label.setFont(new Font("Verdana", Font.PLAIN, 38));
        label.setForeground(Color.WHITE);
        stats.setFont(new Font("Verdana", Font.PLAIN, 30));
        stats.setForeground(Color.WHITE);
        richtig.setFont(new Font("Verdana", Font.PLAIN, 30));
        richtig.setForeground(Color.WHITE);
        falsch.setFont(new Font("Verdana", Font.PLAIN, 30));
        falsch.setForeground(Color.WHITE);
        insgesamt.setFont(new Font("Verdana", Font.PLAIN, 30));
        insgesamt.setForeground(Color.WHITE);
        label4.setFont(new Font("Verdana", Font.PLAIN, 18));
        action.setBorder(BorderFactory.createEmptyBorder(120,70,0,70));
        grid.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));

        panel.setBackground(new java.awt.Color(32, 41, 41));
        action.setBackground(new java.awt.Color(185, 204, 227));


        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Rechtschreibtrainer trainer = new Rechtschreibtrainer(liste);
                    // Zufälligen WortEintrag auswählen
                    ausgabe = sp;
                    eingabe = input.getText();
                    // Trainer starten
                    trainer.trainieren(eingabe, ausgabe);
                    r += trainer.getRichtig();
                    f += trainer.getFalsch();
                    ins += trainer.getInsgesamt();
                if(eingabe.equals(ausgabe) == true) {
                    int random = (int) (Math.random() * liste.getWort().size());
                    WortEintrag ein = liste.getWort().get(random);
                    u = ein.getUrl();
                    sp = ein.getName();
                    richtig.setText("R=" + r);
                    falsch.setText("F=" + f);
                    insgesamt.setText("Insgesamt:" + ins);
                    aktuell = new WortEintrag(ausgabe, u);
                    // Bild von der URL laden und anzeigen
                    try {
                        URL url = new URL(u);
                        BufferedImage image = ImageIO.read(url);
                        if (image != null) {
                            label3.setIcon(new ImageIcon(image));
                        } else {
                            System.out.println("Bild konnte nicht geladen werden.");
                        }
                    } catch (IOException ioException) {
                        ioException.printStackTrace();

                    }
                }
                else {
                    richtig.setText("R=" + r);
                    falsch.setText("F=" + f);
                    insgesamt.setText("Insgesamt:" + ins);
                }
        }});

        speichern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SpeicherArt art = new JSON(liste, aktuell, r, f, ins);
                WortSpeichern save = new WortSpeichern(art,liste, aktuell, r, f, ins );
                save.speichern(art);
            }
        });

        laden.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WortLaden laden = new WortLaden();
                JSONObject jsonObject = new JSONObject(laden.laden());


                String url = jsonObject.getString("URL");
                int r = Integer.parseInt(jsonObject.getString("Richtig"));
                int f = Integer.parseInt(jsonObject.getString("Falsch"));
                int ins = Integer.parseInt(jsonObject.getString("Insgesamt"));

                BufferedImage image = null;
                try {
                    image = ImageIO.read(new URL(url));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                label3.setIcon(new ImageIcon(image));
                richtig.setText("R=" + r);
                falsch.setText("F=" + f);
                insgesamt.setText("Insgesamt:" + ins);

            }
        });

        sp = eintrag.getName();
        BufferedImage image = ImageIO.read(new URL(eintrag.getUrl()));
        label3.setIcon(new ImageIcon(image));


        box.add(label);
        box.setBackground(new java.awt.Color(32, 41, 41));
        panel.add(box, BorderLayout.PAGE_START);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        action.add(label4);
        action.add(input);
        action.add(button);
        action.add(speichern);
        action.add(laden);
        panel.add(action, BorderLayout.LINE_START);
        panel.add(label3, BorderLayout.LINE_END);
        stats.setBorder(BorderFactory.createEmptyBorder(0,0,0,100));
        richtig.setBorder(BorderFactory.createEmptyBorder(0,0,0,40));
        falsch.setBorder(BorderFactory.createEmptyBorder(0,0,0,40));
        grid.add(stats);
        grid.add(richtig);
        grid.add(falsch);
        grid.add(insgesamt);
        grid.setLayout(new BoxLayout(grid, BoxLayout.LINE_AXIS));
        grid.setBackground(new java.awt.Color(32, 41, 41));
        panel.add(grid, BorderLayout.PAGE_END);




        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,50,1200,800);
        frame.setTitle("Worttrainer");
        frame.setVisible(true);
    }


}
