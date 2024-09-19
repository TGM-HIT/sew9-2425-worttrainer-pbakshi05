/**
 * Klasse View
 * @author: Pavel Bakshi
 * @version: 18.09.2024
 */

package worttrainer;
import javax.swing.*;
import java.awt.*;


public class View {

    public View() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JButton button = new JButton("Click");
        JLabel label = new JLabel("Worttrainer");

        panel.setBorder(BorderFactory.createEmptyBorder(500,500,200,500));
        panel.setLayout(new GridLayout(0,1));
        panel.setBackground(new java.awt.Color(15, 18, 18));
        panel.add(button);
        label.setFont(new Font("Verdana", Font.PLAIN, 38));
        label.setForeground(Color.WHITE);
        label.setBounds(100, 50, 100, 30);
        panel.add(label);

        frame = new JFrame() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                // Zeichne ein Rechteck (x, y, Breite, Höhe)
                g.setColor(new java.awt.Color(76, 84, 84));
                g.fillRect(0,0,2000,100);
                g.drawRect(0, 0, 2000, 100);
            }
        };



        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Worttrainer");
        frame.pack();
        frame.setVisible(true);
    }


}
