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

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.JWindow;


public class SplashTeguanequeProduction extends JWindow implements Runnable{

    private Thread thread;
    private JProgressBar jProgressBarMain;
    private JPanelSplash jPanelInformation;

    public SplashTeguanequeProduction() {
        super();

        this.setSize(400,200);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        
        this.setAlwaysOnTop(true);
        this.setBackground(Color.BLUE);
        this.jProgressBarMain = new JProgressBar();
        this.jProgressBarMain.setIndeterminate(true);
        this.jPanelInformation = new JPanelSplash();
        this.jPanelInformation.setBackgroundImage(jPanelInformation.createImage("/image/Splash.png").getImage());
        this.jPanelInformation.setBackground(Color.blue);
        this.add(jPanelInformation, BorderLayout.CENTER);
        this.add(jProgressBarMain, BorderLayout.SOUTH);
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        this.setVisible(true);
        try {
            Thread.sleep(6000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.dispose();
        int[] auxVariable = new int[2];
    }
}


