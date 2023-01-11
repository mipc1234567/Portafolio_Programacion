package internacionalizacion;

import gui.FrameScore;
import gui.GameAhorcado;
import gui.PanelGame;

import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.net.URL;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Mateo Ivan Peña C
 * @version 1.0
 * @Place Universidad Pedagogica y Tecnologica de Colombia
 * juego ahorcado
 */

public class PanelToolbar extends JPanel implements ActionListener {
    
	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
    private String newline = "\n";
    static final private String ABOUT = "Acerca de";
    static final private String HELP = "ayuda";
    static final private String CALCULATE = "calcular";
    static final private String FONT="font";
    static final private String COLOR="color";
    private PanelGame  panel;
    private GameAhorcado gameahorcado;
    private Fonts font;
    private ColorChooserDemo color;
    public PanelToolbar() {
        super();
        JToolBar toolBar = new JToolBar();
        addButtons(toolBar);
        setPreferredSize(new Dimension(450, 130));
        add(toolBar, BorderLayout.PAGE_START);
    }
/**
 * Contructor que permite instanciar por medio de la barra de herramientas las algunas tareas de la
 * aplicacion
 * @param panel
 * @param game
 * @param font
 * @param colorchosseer
 */
    
    public PanelToolbar(PanelGame panel,GameAhorcado game,Fonts font,ColorChooserDemo colorchosseer) {
        super();

     
        JToolBar toolBar = new JToolBar();
        addButtons(toolBar);
        this.panel= panel;
        this.gameahorcado= game;
        this.font=font;
        this.color=colorchosseer;

        textArea= new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);


        setPreferredSize(new Dimension(450, 130));
        add(toolBar, BorderLayout.PAGE_START);

    	
    }
    public void addButtons(JToolBar toolBar) {
        JButton button = null;

        //first button
        button = makeNavigationButton("about", ABOUT,
                                      "recive information about aplication",
                                      "about");
        toolBar.add(button);

        //second button
        button = makeNavigationButton("ayuda",HELP,
                                      "obtains help of the sistem",
                                      "help");
        toolBar.add(button);

        //third button
        button = makeNavigationButton("calcular", CALCULATE,
                                      "would initializace the aplication",
                                      "calculate");
        toolBar.add(button);
        
        button= makeNavigationButton("fuentes", FONT,"Change the font", "fuentes");
        
        toolBar.add(button);
        
        
        
        button=makeNavigationButton("colores",COLOR, "change the color", "colores");
        toolBar.add(button);
    }

    public JButton makeNavigationButton(String imageName,
                                           String actionCommand,
                                           String toolTipText,
                                           String altText) {
        //Look for the image.
    	
        String imgLocation = "images/"
                             + imageName
                             + ".png";
        
        URL imageURL = PanelToolbar.class.getResource(imgLocation);
        //Create and initialize the button.
        JButton button = new JButton();
        button.setActionCommand(actionCommand);
        button.setToolTipText(toolTipText);
        button.addActionListener(this);

        if (imageURL != null) {                      //image found
            button.setIcon(new ImageIcon(imageURL, altText));
        } else {                                     //no image found
            button.setText(altText);
            System.err.println("Resource not found: "
                               + imgLocation);
        }

        return button;
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        String description = null;

        // Handle each button.
        if (ABOUT.equals(cmd)) { 
        	FrameScore d= new FrameScore();
        	String[] total = new String[(int)panel.getScore().sizerecord()];
        	panel.getScore().open();
			total=panel.getScore().ReadToCharge();
        	d.setVisible(true);
        	d.Actualiza(total);
            description = "recive information about aplication <something>.";
            
        } else if (HELP.equals(cmd)) { 
            description = "obtains help of the sistem <something>.";
        } else if (CALCULATE.equals(cmd)) { 
            description = "would initializace the aplication <something>.";
        panel.add2();
        }  else if (FONT.equals(cmd)) { 
        	System.out.println("entro a fuentes");
            description = "would initializace the aplication <something>.";
        font.setVisible(true);
        }  else if (COLOR.equals(cmd)) { // third button clicked
    	System.out.println("entro a COLORES");
        description = "would initializace the aplication <something>.";
    color.setVisible(true);
    }

      
    }

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public String getNewline() {
		return newline;
	}

	public void setNewline(String newline) {
		this.newline = newline;
	}
    

 /*   public void displayResult(String actionDescription) {
        textArea.append(actionDescription + newline);
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
*/
}