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


public class View extends JPanel {

    private String u;
    private String sp;
    private String eingabe;
    private String ausgabe;
    private int i = 0;

    public View(WortListe liste, WortEintrag eintrag) throws IOException {
        JFrame frame = new JFrame();

        //Layouts
        JPanel panel = new JPanel(new BorderLayout());
        JPanel box = new JPanel(new FlowLayout());
        JPanel grid = new JPanel(new GridLayout(1,2));
        JPanel action = new JPanel(new GridLayout(8,1,20,40));

        //Labels
        JLabel stats = new JLabel("Statistik:");
        JLabel richtig = new JLabel("R=" + i);
        JLabel label = new JLabel("Worttrainer");
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel("Erate das Tier auf dem Bild!");
        JTextField input = new JTextField(16);
        JButton button = new JButton("Check");




        label.setFont(new Font("Verdana", Font.PLAIN, 38));
        label.setForeground(Color.WHITE);
        stats.setFont(new Font("Verdana", Font.PLAIN, 30));
        stats.setForeground(Color.WHITE);
        richtig.setFont(new Font("Verdana", Font.PLAIN, 30));
        richtig.setForeground(Color.WHITE);
        label4.setFont(new Font("Verdana", Font.PLAIN, 18));
        action.setBorder(BorderFactory.createEmptyBorder(120,70,0,0));

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Rechtschreibtrainer trainer = new Rechtschreibtrainer(liste);
                // Zufälligen WortEintrag auswählen
                ausgabe = sp;
                eingabe = input.getText();
                // Trainer starten
                trainer.trainieren(eingabe, ausgabe);
                i += trainer.getRichtig();

                int random = (int) (Math.random() * liste.getWort().size());
                WortEintrag ein = liste.getWort().get(random);
                u = ein.getUrl();
                sp = ein.getName();
                richtig.setText("R=" + i);

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
        }});

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
        panel.add(action, BorderLayout.LINE_START);
        panel.add(label3, BorderLayout.LINE_END);
        grid.add(stats);
        grid.add(richtig);
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
