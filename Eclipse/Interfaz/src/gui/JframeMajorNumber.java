package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.ConstructorProperties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class JframeMajorNumber extends JFrame{

public static final String APP_NAME ="Mayor de 2 numeros";
public static final int APP_WIDTH=300;
public static final int APP_HEIGTH=300;
public static final String APP_ICON_FILENAME="src/imagen.gif";



private JmenuBarMajorNumber jmenu;
private JpanelStatusBarMajorNumber Jpanel;
private PanelToolbar jtoolbar;
private JPanelWorkArea Jworkarea;
private JLabel label;
private ColorChooserDemo JcolorChoser;
private Principal principal;




public JframeMajorNumber(){
super(APP_NAME);
this.setSize(APP_WIDTH, APP_HEIGTH);
this.setResizable(true);
this.setIconImage(new ImageIcon(APP_ICON_FILENAME).getImage());
this.setLayout(new BorderLayout());
jmenu= new JmenuBarMajorNumber();




this.Jpanel= new JpanelStatusBarMajorNumber();
this.jtoolbar= new PanelToolbar();
this.Jworkarea= new JPanelWorkArea(24,234,0);
this.JcolorChoser= new ColorChooserDemo();
principal= new Principal();


this.add(jmenu,BorderLayout.NORTH);
this.add(Jpanel,BorderLayout.SOUTH);  
this.add(jtoolbar,BorderLayout.AFTER_LAST_LINE);
this.add(Jworkarea,BorderLayout.CENTER);



}






}
