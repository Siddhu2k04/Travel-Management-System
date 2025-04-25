package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Paytm extends JFrame {
    Paytm() {
        setLayout(new BorderLayout());

        // Load the Image
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/google.jpg"));
        Image img = icon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);
        
        JLabel imageLabel = new JLabel(scaledIcon, JLabel.CENTER); // Centered Image
        add(imageLabel, BorderLayout.CENTER); // Add to Center

        // Web View
        JEditorPane j = new JEditorPane();
        j.setEditable(false);
        try {
            j.setPage("https://paytm.com/electricity-bill-payment");
        } catch (Exception e) {
            j.setContentType("text/html");
            j.setText("<html>Could not load</html>");
        }
        JScrollPane scrollPane = new JScrollPane(j);
        add(scrollPane, BorderLayout.NORTH); // Place it at the top

        // Back Button
        JButton back = new JButton("Back");
        back.addActionListener(e -> setVisible(false));

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(back);
        add(bottomPanel, BorderLayout.SOUTH); // Place at Bottom

        setSize(800, 600);
        setLocation(600, 220);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Paytm().setVisible(true);
    }
}
