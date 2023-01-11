package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;


public class JmenuBarMajorNumber extends JMenuBar  {
	
	public static final String OPTION_CALCULATE ="CALCULAR";
	public static final String HELP ="AYUDA";
	public static final String OPTIONS_OPTIONS="OPCIONES";
	public static final String OPTIONS_ABOUT="A CERCA DE";
	public static final String OPTIONS_APP_HELP="Ayuda General";	
	public static final String HELP_ICON_FILENAME="src/ayuda.png";
	public static final String ABOUT_ICON_FILENAME="src/about.png";
	public static final String EJECUTE_ICON_FILENAME="src/calcular.png";
	public static final String FILE="ARCHIVO";
	
	private ColorChooserDemo color;
	//private Color
	private JMenu  jMenuHelp;
	private JMenu jMenuAbout;
	private JMenu jMenuCalculate;
	private JMenu jMenufile;
	private JMenuItem menuItem1;
	private JMenuItem menuItem2;
	private Principal principal;
	public JmenuBarMajorNumber(){
	super();
	
	init();	
	}
	
	
	public void init(){
		
		

	
	 
	
	   ColorListener l = new ColorListener();
	   FontListener f= new FontListener();
	   
/*	   
	    JMenuItem mi;
	    mi = menu.add(new JMenuItem("Cut", 't'));
	    mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CTRL_MASK));
	    mi.addActionListener(l);
	    mi = menu.add(new JMenuItem("Copy", 'c'));
	    mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.CTRL_MASK));
	    mi.addActionListener(l);
	    mi = menu.add(new JMenuItem("Paste", 'p'));
	    mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK));
	    mi.addActionListener(l);

	    setJMenuBar(bar);
	    getContentPane().add(new JLabel("A placeholder"));

	    pack();
	    setSize(700, 700);
	    setVisible(true);
	
	    */
	   JMenuItem exit = new JMenuItem("Exit");
	    exit.setMnemonic('x');
	    exit.addActionListener(new ActionListener() {
	      
	    	
	    	public void actionPerformed(ActionEvent e) {
	        System.out.println("Exit performed");
	       // this.dispose();
	        System.exit(0);
	      }
	    });
menuItem1= new JMenuItem("Elegir color");
menuItem2= new JMenuItem("Elegir fuente");
menuItem1.addActionListener(l);
menuItem2.addActionListener(f);
jMenufile= new JMenu(FILE);
jMenufile.add(menuItem1);
jMenufile.add(menuItem2);
this.add(jMenufile);
jMenufile.add(exit);		
		
	
//this.setIconImage(new ImageIcon(APP_ICON_FILENAME).getImage());
	
this.setCursor(java.awt.Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	
//Calcular opciones ayuda
	
jMenuHelp= new JMenu(OPTION_CALCULATE);
	
jMenuHelp.add(new JMenuItem("Help"));
	
jMenuHelp.add(new JMenuItem("Help Especific"));
	
//this.jMenuHelp.setIconImage(new ImageIcon(HELP_ICON_FILENAME).getImage());
	
//jMenuHelp.setIcon(new ImageIcon(HELP_ICON_FILENAME).getImage());
	
this.add(jMenuHelp);

	

jMenuAbout= new JMenu(OPTIONS_ABOUT);
	
jMenuAbout.add(new JMenuItem("Version"));
	
this.add(jMenuAbout);
	
	
jMenuCalculate= new JMenu(OPTIONS_ABOUT);
	
jMenuCalculate.add(new JMenuItem(OPTIONS_APP_HELP));

	
this.add(jMenuCalculate);
	
	
	}
	
	  private class ColorListener implements ActionListener {
		    public void actionPerformed(ActionEvent e) {
		      System.out.println(e.getActionCommand());
		  color= new ColorChooserDemo();
		 color.setVisible(true);
		    }
		  }
	  
	  private class FontListener implements ActionListener {
		    public void actionPerformed(ActionEvent e) {
		      System.out.println(e.getActionCommand());
		      principal= new Principal();
		    		  principal.setVisible(true);
		    }
		  }
	
}


