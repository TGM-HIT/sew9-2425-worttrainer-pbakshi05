/**
 * Klasse View
 * @author: Pavel Bakshi
 * @version: 18.09.2024
 */

package worttrainer;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class View extends JPanel {

    public View() throws IOException {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(new BorderLayout());
        JPanel box = new JPanel(new FlowLayout());
        JPanel grid = new JPanel(new BorderLayout());
        JLabel label2 = new JLabel("Statistik:");
        JLabel label = new JLabel("Worttrainer");

        panel.setBackground(new java.awt.Color(255, 255, 255));

        label.setFont(new Font("Verdana", Font.PLAIN, 38));
        label.setForeground(Color.WHITE);
        label2.setFont(new Font("Verdana", Font.PLAIN, 30));
        label2.setForeground(Color.WHITE);

        box.add(label);
        box.setBackground(new java.awt.Color(32, 41, 41));
        panel.add(box, BorderLayout.PAGE_START);

        URL url =  new URL("https://www.zooroyal.at/magazin/wp-content/uploads/2019/10/hund-im-herbst-760x570.jpg");
        BufferedImage image = ImageIO.read(url);
        JLabel label3 = new JLabel(new ImageIcon(image));
        panel.add(label3, BorderLayout.CENTER);

        grid.add(label2, BorderLayout.CENTER);
        grid.setLayout(new BoxLayout(grid, BoxLayout.LINE_AXIS));
        grid.setBackground(new java.awt.Color(32, 41, 41));
        panel.add(grid, BorderLayout.PAGE_END);

        /**
        box.setLayout(new BorderLayout());

        panel.add(button, BorderLayout.PAGE_END);
        label.setFont(new Font("Verdana", Font.PLAIN, 38));
        label.setForeground(Color.WHITE);
        label.setBackground(new java.awt.Color(86, 122, 117));

        panel.add(label, BorderLayout.PAGE_START);
        */



        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,50,1200,800);
        frame.setTitle("Worttrainer");
        frame.setVisible(true);
    }


}
