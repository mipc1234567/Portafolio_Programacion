package gui;

import internacionalizacion.ParametrosGenerales;


import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.JWindow;
import javax.swing.UIManager;

/**
 * @author Mateo Ivan Peña C
 * @version 1.0
 * @Place Universidad Pedagogica y Tecnologica de Colombia
 */
public class RunSplash extends JWindow{ 
    splash p; 
    /** Creates new form RunSplash  
     * @throws InterruptedException */ 
    public RunSplash() throws InterruptedException{
        p= new splash(); 
        /**
         * se llama nuestra ventana que inicia las configuraciobes
         */
        ParametrosGenerales g= new ParametrosGenerales();
        this.add(p, BorderLayout.CENTER); 
        this.setSize(p.getWidth(), p.getHeight()); 
        this.setLocationRelativeTo(null);
        setVisible(true);
        p.velocidadDeCarga(); 
        this.dispose();
    	g.setVisible(true);
       
    } 
     
    public static void main(String args[]) throws InterruptedException { 
        new RunSplash(); // se invoca a la ventana RunSplash         
    } 
}  