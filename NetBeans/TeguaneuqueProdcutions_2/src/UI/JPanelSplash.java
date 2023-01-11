/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *
 * @author /**Universidad pedagogica y tecnologica de Colombia * Tunja * Claudia
 * Jisell Alba Muñoz * codigo: 2013 11465
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelSplash extends JPanel {

    private Image image;
    private JLabel jLabelVersion;

    public JPanelSplash() {
        super();
        this.setOpaque(false);
        this.setLayout(new GridLayout(5, 1));
        Font font = new Font("Alegrian", 25, 25);
        this.jLabelVersion = new JLabel();
        this.jLabelVersion.setForeground(Color.BLACK);
        this.jLabelVersion.setFont(new Font("Fixed Miriam Transparent", 25, 25));

        this.add(jLabelVersion);
    }

    public void setBackgroundImage(Image bgImage) {
        this.image = bgImage;
    }

    public ImageIcon createImage(String path) {
        URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    @Override
    public void paint(Graphics g) {
        Dimension tamanio = this.getSize();
        if (image != null) {
            g.drawImage(image, 0, 0, tamanio.width, tamanio.height, null);
            super.paint(g);

        }
    }
}